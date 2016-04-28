package callback;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Ramin on 28.04.2016.
 */
public interface Callback<T> extends Remote {

    public void execute(T command);
}
