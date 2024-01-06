package pl.szaqku.awir.auth.service;

import pl.szaqku.awir.auth.model.Token;

public interface TokenStorage {
    Token issueNewToken();
    boolean isTokenValid(String token);
    void invalidateToken(String token);
}
