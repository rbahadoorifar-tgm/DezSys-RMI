package remoteService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.commands.Command;

/**
 * DoSomethingService Interface, welcher von allen Service Klassen, wie ServerService implementiert wird.
 */
public interface DoSomethingService extends Remote {

    public void doSomething(Command c) throws RemoteException;

}