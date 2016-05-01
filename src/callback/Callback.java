package callback;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Callback Interface, der von allen Callback Klassen implementiert wird.
 *
 * @param <T> Datentyp, welcher verarbeitet werden soll.
 */
public interface Callback<T> extends Remote {

    public void execute(T command) throws RemoteException;
}
