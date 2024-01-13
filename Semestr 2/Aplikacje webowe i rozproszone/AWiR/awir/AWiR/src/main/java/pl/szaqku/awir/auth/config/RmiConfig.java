package pl.szaqku.awir.auth.config;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
import pl.szaqku.awir.auth.controller.SecurityController;
import pl.szaqku.awir.auth.controller.impl.SecurityControllerImpl;
import pl.szaqku.awir.auth.service.AuthenticationProvider;
import pl.szaqku.awir.auth.service.AuthorizationService;
import pl.szaqku.awir.auth.service.TokenStorage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@Slf4j
@Configuration
public class RmiConfig {

    @Value("${app.rmi.auth.port}")
    private int RMI_PORT;

    @Bean
    public SecurityController authenticationController(
        final AuthenticationProvider authenticationProvider,
        final TokenStorage tokenStorage,
        final AuthorizationService authorizationService
    ) throws RemoteException {
        Registry registry;
        try {
            registry = LocateRegistry.createRegistry(RMI_PORT);
            log.info("Create registry");
        } catch (RemoteException e) {
            log.info("Reuse RMI registry");
            registry = LocateRegistry.getRegistry(null, RMI_PORT);
        }
        var domainController = new SecurityControllerImpl(authenticationProvider, tokenStorage, authorizationService);
        registry.rebind(SecurityController.RMI_NAME, domainController);
        return domainController;
    }

}
