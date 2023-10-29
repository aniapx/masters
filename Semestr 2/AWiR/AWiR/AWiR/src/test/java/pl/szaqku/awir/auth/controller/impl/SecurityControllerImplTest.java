package pl.szaqku.awir.auth.controller.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import pl.szaqku.awir.auth.controller.SecurityController;
import pl.szaqku.awir.auth.exception.SecurityException;
import pl.szaqku.awir.auth.model.AuthenticationRequest;
import pl.szaqku.awir.auth.model.AuthenticationResponse;
import pl.szaqku.awir.auth.service.AuthenticationProvider;
import pl.szaqku.awir.auth.service.impl.SingleUseAuthorizationService;
import pl.szaqku.awir.auth.service.TokenStorage;
import pl.szaqku.awir.auth.service.impl.LdapAuthenticationProvider;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
@DirtiesContext
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public final class SecurityControllerImplTest {

    public static final String ZUT_LOGIN_ENV_VAR = "zutLogin";
    public static final String ZUT_PASSWORD_ENV_VAR = "zutPassword";
    public static final String RANDOM_STRING = "xxx";

    private SecurityController securityController;

    @Value("${app.rmi.auth.port}")
    private int rmiAuthPort;

    @Autowired
    protected TokenStorage tokenStorage;

    @Autowired
    protected AuthenticationProvider authenticationProvider;

    @Autowired
    protected SingleUseAuthorizationService singleUseAuthorizationService;

    @MockBean
    protected LdapAuthenticationProvider ldapAuthenticationProvider;

    @BeforeEach
    void setUp() throws MalformedURLException, NotBoundException, RemoteException {
        var securityController = (SecurityControllerImpl) Naming.lookup("rmi://localhost:"+rmiAuthPort+"/"+ SecurityController.RMI_NAME);
        securityController.setTokenStorage(tokenStorage);
        securityController.setAuthenticationProvider(authenticationProvider);
        securityController.setSingleUseAuthorizationService(singleUseAuthorizationService);
        this.securityController = securityController;
    }

    @Test
    void authenticate_SuccessfulWithRealCredentials() throws SecurityException {
        Mockito.when(ldapAuthenticationProvider.authenticate(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        securityController.authenticate(new AuthenticationRequest(
            System.getenv("zutLogin"), System.getenv("zutPassword")
        ));
    }

    @Test
    void authenticate_Fail() {
        Mockito.when(ldapAuthenticationProvider.authenticate(Mockito.anyString(), Mockito.anyString())).thenReturn(false);
        Assertions.assertThrows(SecurityException.class, () -> securityController.authenticate(new AuthenticationRequest(
            RANDOM_STRING, RANDOM_STRING
        )));
    }

    @Test
    void doAuthorizedAction_AfterSuccessfulAuthentication() throws SecurityException {
        Mockito.when(ldapAuthenticationProvider.authenticate(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        var authenticationResponse = securityController.authenticate(new AuthenticationRequest(
            System.getenv(ZUT_LOGIN_ENV_VAR), System.getenv(ZUT_PASSWORD_ENV_VAR)
        ));

        String token = authenticationResponse.getEncodedToken();

        securityController.doAuthorizedAction(token);

        Assertions.assertThrows(SecurityException.class, () -> securityController.doAuthorizedAction(token),
            "Using one time encodedToken again should fail"
        );
    }

    @Test
    void doAuthorizedAction_FailDueToInvalidToken() {
        Mockito.when(ldapAuthenticationProvider.authenticate(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        var authenticationResponse = new AuthenticationResponse(RANDOM_STRING, LocalDateTime.now());

        String token = authenticationResponse.getEncodedToken();

        Assertions.assertThrows(SecurityException.class, () -> securityController.doAuthorizedAction(token));
    }

    @Test
    void doAuthorizedAction_FailedDueToExpiredToken() throws SecurityException, InterruptedException {
        Mockito.when(ldapAuthenticationProvider.authenticate(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        var authenticationResponse = securityController.authenticate(new AuthenticationRequest(
            System.getenv(ZUT_LOGIN_ENV_VAR), System.getenv(ZUT_PASSWORD_ENV_VAR)
        ));

        String token = authenticationResponse.getEncodedToken();
        long sleepTimeInSeconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), authenticationResponse.getExpirationDate()) + 1;

        log.info("Sleeping for {}s", sleepTimeInSeconds);

        Thread.sleep(sleepTimeInSeconds*1_000);

        Assertions.assertThrows(SecurityException.class, () -> securityController.doAuthorizedAction(token));
    }
}