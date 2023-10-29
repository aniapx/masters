package pl.szaqku.awir.auth.model;

import lombok.Data;

import java.io.Serializable;

@Data
public final class AuthenticationRequest implements Serializable {
    private final String name;
    private final String encodedPassword;

    /**
     * @param encodedPassword in B64
     */
    public AuthenticationRequest(String name, String encodedPassword) {
        this.name = name;
        this.encodedPassword = encodedPassword;
    }

}
