package pl.szaqku.awir.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Data
@Configuration
@ConfigurationProperties("app.ldap")
public class LdapProperties implements Serializable {

    private String host;
    private String port;
    private String domain;

    public String getLdapUrl() {
        return String.format("ldap://%s:%s/", host, port);
    }
}
