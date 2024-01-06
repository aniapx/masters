package pl.edu.zut.wi.awir;

import javax.naming.ldap.LdapContext;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.ObjectUtils.anyNull;

public class ValidatorImpl extends UnicastRemoteObject implements Validator {
	private static final long serialVersionUID = 1754156931382519288L;

	public ValidatorImpl() throws RemoteException {
	}

	@Override
	public String authenticate(final String login, final String password) throws RemoteException {
		if (anyNull(login, password)) {
			throw new RemoteException("Nie przekazano danych logowania");
		}

		LdapContext ldapContext = null;
		try {
			ldapContext = AuthenticatorAD.authenticate(login, password, AuthenticatorAD.DOMAIN, AuthenticatorAD.LDAP_HOST_1, AuthenticatorAD.LDAP_PORT);
			return SecretVault.INSTANCE.generateSecret();
		} catch (Exception cause) {
			throw new RemoteException("Niepoprawne dane logowania");
		} finally {
			if (nonNull(ldapContext)) {
				try {
					ldapContext.close();
				} catch (Throwable ignored) {
				}
			}
		}
	}
}
