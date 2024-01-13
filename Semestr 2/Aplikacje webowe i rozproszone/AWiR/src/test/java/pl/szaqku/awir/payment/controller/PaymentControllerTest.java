package pl.szaqku.awir.payment.controller;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.CommonsHttpConnection;
import org.springframework.ws.transport.http.HttpComponentsConnection;
import org.springframework.ws.transport.http.HttpUrlConnection;
import pl.szaqku.awir.auth.controller.SecurityController;
import pl.szaqku.awir.auth.controller.impl.SecurityControllerImpl;
import pl.szaqku.awir.auth.exception.SecurityException;
import pl.szaqku.awir.auth.model.AuthenticationRequest;
import pl.szaqku.awir.auth.service.AuthenticationProvider;
import pl.szaqku.awir.auth.service.TokenStorage;
import pl.szaqku.awir.auth.service.impl.LdapAuthenticationProvider;
import pl.szaqku.awir.auth.service.impl.SingleUseAuthorizationService;
import pl.szaqku.awir.payment.model.DocumentStatus;
import pl.szaqku.awir.payment.model.PaymentAddRequest;
import pl.szaqku.awir.payment.model.PaymentAddResponse;
import pl.szaqku.awir.payment.model.PaymentDocument;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


@Slf4j
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {

    @LocalServerPort
    private int port;

    @Value("${app.rmi.auth.port:1099}")
    private int rmiAuthPort;

    private WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

    @Autowired
    protected TokenStorage tokenStorage;

    @Autowired
    protected AuthenticationProvider authenticationProvider;

    @Autowired
    protected SingleUseAuthorizationService singleUseAuthorizationService;

    @MockBean
    protected LdapAuthenticationProvider ldapAuthenticationProvider;

    private SecurityController securityController;

    @BeforeEach
    protected void setUp() throws MalformedURLException, NotBoundException, RemoteException {
        var securityController = (SecurityControllerImpl) Naming.lookup("rmi://localhost:"+rmiAuthPort+"/"+ SecurityController.RMI_NAME);
        securityController.setTokenStorage(tokenStorage);
        securityController.setAuthenticationProvider(authenticationProvider);
        securityController.setSingleUseAuthorizationService(singleUseAuthorizationService);
        this.securityController = securityController;

        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan("pl.szaqku.awir.payment.model");
        Map<String,Object> map = new HashMap<>();
        map.put("jaxb.formatted.output", true);
        jaxb2Marshaller.setMarshallerProperties(map);

        webServiceTemplate.setMarshaller(jaxb2Marshaller);
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller);
        this.webServiceTemplate.setDefaultUri("http://localhost:" + port + "/ws");
    }

    @Test
    void addPayment_FailDueToMissingAuthToken() {
        PaymentAddRequest request = new PaymentAddRequest();
        var response = (PaymentAddResponse) this.webServiceTemplate.marshalSendAndReceive(request);

        Assertions.assertEquals(1, response.getContent().size());
        Assertions.assertEquals(DocumentStatus.class, response.getContent().get(0).getClass());
        Assertions.assertEquals("Authorization error.", ((DocumentStatus) response.getContent().get(0)).getStatusCode());
    }

    @Test
    void addPayment_AllGood() throws SecurityException {
        Mockito.when(ldapAuthenticationProvider.authenticate(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        var authResponse = securityController.authenticate(new AuthenticationRequest("xxx", "xxx"));

        PaymentAddRequest request = new PaymentAddRequest();
        var response = (PaymentAddResponse) this.webServiceTemplate.marshalSendAndReceive(request, webServiceMessage -> {
            TransportContext context = TransportContextHolder.getTransportContext();
            HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();
            connection.addRequestHeader("Authorization", authResponse.getEncodedToken());
        });

        Assertions.assertTrue(response.getContent().size() > 0);
        Assertions.assertNotEquals(DocumentStatus.class, response.getContent().get(0).getClass());

        response.getContent().stream()
            .filter(o -> o instanceof PaymentDocument)
            .map(o -> (PaymentDocument) o)
            .limit(1)
            .flatMap(o -> o.getPaymentLineItem().stream())
            .limit(3)
            .forEachOrdered(i -> log.info("{}", i.getCardIdentifier().getCardIdent()));
    }
}