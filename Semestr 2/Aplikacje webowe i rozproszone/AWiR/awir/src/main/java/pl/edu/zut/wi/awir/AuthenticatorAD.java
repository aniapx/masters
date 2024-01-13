package pl.edu.zut.wi.awir;

import lombok.experimental.UtilityClass;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

@UtilityClass
public class AuthenticatorAD {
    public static final String  LDAP_HOST_1 = "ni.wi.tuniv.szczecin.pl";
    public static final String  LDAP_HOST_2 = "eta.wi.tuniv.szczecin.pl";
    public static final int     LDAP_PORT = 389;
    public static final String  DOMAIN = "WIPSAD";
    
    /* gpresult /r
     * nltest /dclist:wipsad
     *                
     * Get list of DCs in domain 'wipsad' from '\\NI'.
     *  NI.WIPSAD.local [PDC]  [DS] Site: Nazwa-pierwszej-lokacji   "ni.wi.tuniv.szczecin.pl"
     * ETA.WIPSAD.local        [DS] Site: Nazwa-pierwszej-lokacji   "eta.wi.tuniv.szczecin.pl"
    */    
    public static LdapContext authenticate(final String username, final String password, final String domain,
                                           final String ldapHost, final int port) throws NamingException {
        final Hashtable<String, String> environment = new Hashtable<>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
        environment.put(Context.SECURITY_PRINCIPAL, domain + "\\" + username );
        environment.put(Context.SECURITY_CREDENTIALS, password);
        
        String ldapURL = "ldap://" + ldapHost;
        ldapURL += (port == 0) ? "/" : ( ":" + port + "/" );
        environment.put(Context.PROVIDER_URL, ldapURL);

        return new InitialLdapContext(environment, null);
    }
}
