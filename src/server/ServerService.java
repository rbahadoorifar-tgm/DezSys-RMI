package server;

import java.rmi.RemoteException;

import remoteService.DoSomethingService;
import server.commands.Command;

/**
 * Führ den gewünschten Befehl vom Client aus.
 */
public class ServerService implements DoSomethingService {

    @Override
    public void doSomething(Command c) throws RemoteException {
        c.execute();

    }

}