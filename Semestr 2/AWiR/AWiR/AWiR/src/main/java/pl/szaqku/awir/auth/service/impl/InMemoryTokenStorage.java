package pl.szaqku.awir.auth.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.szaqku.awir.auth.config.TokenStorageProperties;
import pl.szaqku.awir.auth.model.Token;
import pl.szaqku.awir.auth.service.TokenStorage;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class InMemoryTokenStorage implements TokenStorage, Serializable {

    private final TokenStorageProperties properties;

    /**
     * Token, Expiration date
     */
    private final ConcurrentHashMap<String, LocalDateTime> tokenMap = new ConcurrentHashMap<>();

    @Override
    public Token issueNewToken() {
        var token = createToken();
        var expirationDate = LocalDateTime.now().plusSeconds(properties.getTokenExpireInSeconds());

        tokenMap.put(token, expirationDate);

        return new Token(token, expirationDate);
    }

    @Override
    public boolean isTokenValid(String token) {
        if (!tokenMap.containsKey(token)) {
            return false;
        }

        return tokenMap.get(token).isAfter(LocalDateTime.now());
    }

    @Override
    public void invalidateToken(String token) {
        tokenMap.remove(token);
    }

    protected String createToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
