package pl.edu.zut.wi.awir;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SecretVault {
	public static final SecretVault INSTANCE = new SecretVault();

	private final Map<String, LocalDateTime> secrets = new ConcurrentHashMap<>();

	@Getter
	@Setter
	private long validSeconds = 5L;

	public String generateSecret() {
		final String uuid = UUID.randomUUID().toString();
		secrets.put(uuid, LocalDateTime.now());
		return Base64.getEncoder().encodeToString(uuid.getBytes());
	}

	public boolean verifyAndInvalidate(final String secret) {
		try {
			final LocalDateTime timestamp;
			if ((timestamp = secrets.remove(new String(Base64.getDecoder().decode(secret)))) != null) {
				return !LocalDateTime.now().minusSeconds(validSeconds).isAfter(timestamp);
			}
		} catch (Exception ignore) {
		}
		return false;
	}
}
