package pl.szaqku.awir.auth.service;

public interface AuthenticationProvider {

    boolean authenticate(String name, String password);
}
