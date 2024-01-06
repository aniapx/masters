package pl.szaqku.awir.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Data
@Configuration
@ConfigurationProperties("app.auth")
public class TokenStorageProperties implements Serializable {

    private Integer tokenExpireInSeconds;
}
