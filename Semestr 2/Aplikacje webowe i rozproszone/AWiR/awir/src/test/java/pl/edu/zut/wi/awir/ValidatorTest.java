package pl.edu.zut.wi.awir;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.zut.wi.awir.vault.Secret;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Base64;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ValidatorTest {
	public static final String SERVICE = "rmi://localhost:1099/validator";

	@ParameterizedTest
	@MethodSource("provideCredentials")
	public void authenticate_ShouldPassOrFail(final String login, final String password, final boolean success) throws Exception {
		final Validator validator = (Validator) Naming.lookup(SERVICE);

		if (success) {
			final String secret = validator.authenticate(login, new String(Base64.getDecoder().decode(password)));
			assertNotNull(secret);
			assertTrue(SecretVault.INSTANCE.verifyAndInvalidate(secret));
			assertFalse(SecretVault.INSTANCE.verifyAndInvalidate(secret));
		} else {
			assertThrows(RemoteException.class, () -> validator.authenticate(login, new String(Base64.getDecoder().decode(password))));
		}
	}

	@Test
	public void authenticate_ShouldExpired() throws Exception {
		final Validator validator = (Validator) Naming.lookup(SERVICE);
		final String secret = validator.authenticate("kkraska", new String(Base64.getDecoder().decode(Secret.PASSWORD)));
		assertNotNull(secret);
		Thread.sleep(SecretVault.INSTANCE.getValidSeconds() * 1_000L + 1L);
		assertFalse(SecretVault.INSTANCE.verifyAndInvalidate(secret));
	}

	private static Stream<Arguments> provideCredentials() {
		return Stream.of(
				Arguments.of("kkraska", Secret.PASSWORD, true),
				Arguments.of("admin", Base64.getEncoder().encodeToString("awir".getBytes()), false),
				Arguments.of("admin", Base64.getEncoder().encodeToString("awir1".getBytes()), false),
				Arguments.of("admin1", Base64.getEncoder().encodeToString("awir".getBytes()), false)
		);
	}
}
