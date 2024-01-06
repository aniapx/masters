package pl.szaqku.awir.auth.service;

import pl.szaqku.awir.auth.exception.SecurityException;

public interface AuthorizationService {
    void authorize(String token) throws SecurityException;
}
