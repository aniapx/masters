package pl.szaqku.awir.auth.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public final class Token implements Serializable {

    private static final long serialVersionUID = 0L;

    private final String token;
    private final LocalDateTime expireAt;

    public Token(String token, LocalDateTime expireAt) {
        this.token = token;
        this.expireAt = expireAt;
    }
}
