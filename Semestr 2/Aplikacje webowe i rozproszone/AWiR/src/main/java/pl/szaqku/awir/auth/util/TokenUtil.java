package pl.szaqku.awir.auth.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenUtil {

    public static String decodeToken(String authorizationToken) {
        return authorizationToken == null ? null : new String(Base64.getDecoder().decode(authorizationToken));
    }
    public static String encodeToken(String authorizationToken) {
        return authorizationToken == null ? null : Base64.getEncoder().encodeToString(authorizationToken.getBytes(StandardCharsets.UTF_8));
    }
}
