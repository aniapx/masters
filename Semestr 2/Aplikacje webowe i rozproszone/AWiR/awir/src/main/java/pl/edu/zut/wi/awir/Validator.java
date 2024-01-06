package pl.edu.zut.wi.awir;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Validator extends Remote {
	String authenticate(String login, String password) throws RemoteException;
}
