package pl.szaqku.awir.auth.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.szaqku.awir.auth.config.LdapProperties;
import pl.szaqku.awir.auth.service.AuthenticationProvider;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import java.io.Serializable;
import java.util.Hashtable;

@Slf4j
@Service
@RequiredArgsConstructor
public class LdapAuthenticationProvider implements AuthenticationProvider, Serializable {

    private final LdapProperties properties;

    @Override
    public boolean authenticate(String username, String password) {
        try {
            var env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, properties.getDomain() + "\\" + username);
            env.put(Context.SECURITY_CREDENTIALS, password);
            env.put(Context.PROVIDER_URL, properties.getLdapUrl());

            new InitialLdapContext(env, null).close();
            return true;
        } catch (NamingException e) {
            log.error("Failed to authenticate username", e);
        }

        return false;
    }

}

