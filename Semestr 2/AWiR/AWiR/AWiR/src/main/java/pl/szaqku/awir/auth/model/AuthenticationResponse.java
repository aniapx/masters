package pl.szaqku.awir.auth.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
public final class AuthenticationResponse implements Serializable {
    private final String encodedToken;
    private final LocalDateTime expirationDate;

    /**
     * @param encodedToken in B64
     */
    public AuthenticationResponse(String encodedToken, LocalDateTime expirationDate) {
        this.encodedToken = encodedToken;
        this.expirationDate = expirationDate;
    }
}