package pl.szaqku.awir.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.szaqku.awir.auth.exception.SecurityException;
import pl.szaqku.awir.auth.service.AuthorizationService;
import pl.szaqku.awir.auth.service.TokenStorage;

@Slf4j
@Service
//@RequiredArgsConstructor
public class SingleUseAuthorizationService implements AuthorizationService {

    private final TokenStorage tokenStorage;

    public SingleUseAuthorizationService(TokenStorage tokenStorage) {
        this.tokenStorage = tokenStorage;
    }

    @Override
    public void authorize(String token) throws SecurityException {
        if (token == null) {
            throw new SecurityException();
        }

        var authorized = tokenStorage.isTokenValid(token);

        if (!authorized) {
            log.warn("Unauthorized user attempted to do authorized action");
            throw new SecurityException();
        }

        tokenStorage.invalidateToken(token);
    }
}
