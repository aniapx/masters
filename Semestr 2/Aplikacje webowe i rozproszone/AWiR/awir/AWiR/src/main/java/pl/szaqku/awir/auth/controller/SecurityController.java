package pl.szaqku.awir.auth.controller;

import pl.szaqku.awir.auth.exception.SecurityException;
import pl.szaqku.awir.auth.model.AuthenticationRequest;
import pl.szaqku.awir.auth.model.AuthenticationResponse;

import java.io.Serializable;
import java.rmi.Remote;

public interface SecurityController extends Remote, Serializable {

    String RMI_NAME = "securityController";

    void doAuthorizedAction(String token) throws SecurityException;

    AuthenticationResponse authenticate(AuthenticationRequest credentials) throws SecurityException;

}
