package pl.edu.zut.wi.awir;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

@Slf4j
@Service
public class RmiService implements ApplicationRunner {
	public static final String SERVICE = "validator";
	private Registry registry;
	private boolean initialized;

	@Override
	public void run(ApplicationArguments args) {
		if (startRmiRegistry()) {
			bindServiceValidator();
		}
	}

	private boolean startRmiRegistry() {
		log.info("RMI Registry Started");
		try {
			registry = LocateRegistry.createRegistry(1099);
			initialized = true;
		} catch (RemoteException cause) {
			log.error("Błąd tworzenia RMI Registry. Szczegóły", cause);
		}
		return initialized;
	}

	private void bindServiceValidator() {
		try {
			final Validator validator = new ValidatorImpl();
			Naming.rebind(SERVICE, validator);
		} catch (RemoteException | MalformedURLException cause) {
			log.error("Błąd rejestrowania usługi {}. Szczegóły", SERVICE, cause);
		}
	}

	@EventListener(ContextClosedEvent.class)
	public void shutdown() {
		log.info("Zamykanie aplikacji");

		if (initialized) {
			try {
				Naming.unbind(SERVICE);
			} catch (RemoteException | MalformedURLException | NotBoundException cause) {
				log.error("Błąd wyrejestrowania usługi Validator", cause);
			}

			try {
				UnicastRemoteObject.unexportObject(registry, true);
			} catch (NoSuchObjectException cause) {
				log.error("Błąd niszczenia RMI Registry", cause);
			}
			log.info("RMI Registry Stopped");
		}
	}
}