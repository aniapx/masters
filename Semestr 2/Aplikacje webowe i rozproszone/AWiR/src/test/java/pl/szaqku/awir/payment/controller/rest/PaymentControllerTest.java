package pl.szaqku.awir.payment.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import pl.szaqku.awir.auth.controller.SecurityController;
import pl.szaqku.awir.auth.controller.impl.SecurityControllerImpl;
import pl.szaqku.awir.auth.exception.SecurityException;
import pl.szaqku.awir.auth.model.AuthenticationRequest;
import pl.szaqku.awir.auth.service.AuthenticationProvider;
import pl.szaqku.awir.auth.service.TokenStorage;
import pl.szaqku.awir.auth.service.impl.LdapAuthenticationProvider;
import pl.szaqku.awir.auth.service.impl.SingleUseAuthorizationService;
import pl.szaqku.awir.payment.model.PaymentAddRequest;
import pl.szaqku.awir.payment.model.PaymentAddResponse;
import pl.szaqku.awir.payment.model.PaymentDocument;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Value("${app.rmi.auth.port:1099}")
    private int rmiAuthPort;

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
    }

    @Test
    public void addPayment_FailDueToLackOfToken() throws Exception {
        var request = new PaymentAddRequest();
        var httpEntity = new HttpEntity<>(request);
        assertThat(
            this.restTemplate.postForObject("http://localhost:" + port + "/api/payments", httpEntity, PaymentAddResponse.class)
        )
        .extracting(r -> r.getContent())
        .extracting(r -> r.get(0))
        .hasFieldOrPropertyWithValue("statusCode", "Authorization error.");
    }

    @Test
    void addPayment_Successful() throws SecurityException {
        Mockito.when(ldapAuthenticationProvider.authenticate(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        var authResponse = securityController.authenticate(new AuthenticationRequest("xxx", "xxx"));
        var request = new PaymentAddRequest();
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", authResponse.getEncodedToken());
        var httpEntity = new HttpEntity<>(request, httpHeaders);
        var response = restTemplate.postForObject("http://localhost:" + port + "/api/payments", httpEntity, PaymentAddResponse.class);

        Assertions.assertEquals(PaymentDocument.class, response.getContent().get(0).getClass());

        response.getContent().stream()
            .filter(o -> o instanceof PaymentDocument)
            .map(o -> (PaymentDocument) o)
            .limit(1)
            .flatMap(o -> o.getPaymentLineItem().stream())
            .limit(3)
            .forEachOrdered(i -> log.info("{}", i.getCardIdentifier().getCardIdent()));
    }
}