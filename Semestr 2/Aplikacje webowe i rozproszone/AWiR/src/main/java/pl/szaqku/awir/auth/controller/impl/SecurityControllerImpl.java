package pl.szaqku.awir.auth.controller.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.szaqku.awir.auth.controller.SecurityController;
import pl.szaqku.awir.auth.exception.SecurityException;
import pl.szaqku.awir.auth.model.AuthenticationRequest;
import pl.szaqku.awir.auth.model.AuthenticationResponse;
import pl.szaqku.awir.auth.service.AuthenticationProvider;
import pl.szaqku.awir.auth.service.AuthorizationService;
import pl.szaqku.awir.auth.service.TokenStorage;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static pl.szaqku.awir.auth.util.TokenUtil.decodeToken;
import static pl.szaqku.awir.auth.util.TokenUtil.encodeToken;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class SecurityControllerImpl implements SecurityController {

    @Setter
    private transient AuthenticationProvider authenticationProvider;

    @Setter
    private transient TokenStorage tokenStorage;

    @Setter
    private transient AuthorizationService singleUseAuthorizationService;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest credentials) throws SecurityException {
        var authentication = authenticationProvider.authenticate(
            credentials.getName(),
            new String(Base64.getDecoder().decode(credentials.getEncodedPassword().getBytes(StandardCharsets.UTF_8)))
        );

        if (authentication) {
            log.info("Authenticated successfully.");
            var tokenResponse = tokenStorage.issueNewToken();
            return new AuthenticationResponse(
                encodeToken(tokenResponse.getToken()),
                tokenResponse.getExpireAt()
            );
        }

        log.warn("Failed to authenticate user.");
        throw new SecurityException();
    }

    @Override
    public void doAuthorizedAction(String encodedToken) throws SecurityException {
        String token = decodeToken(encodedToken);
        singleUseAuthorizationService.authorize(token);

        log.info("Execute authorized action...");
        //do something ...
    }

}
