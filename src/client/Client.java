package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import remoteService.DoSomethingService;
import calculation.*;
import callback.*;
import server.commands.CalculationCommand;
import server.commands.Command;


public class Client {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Registry registry = LocateRegistry.getRegistry(1234);

            DoSomethingService uRemoteObject = (DoSomethingService) registry.lookup("Service");
            System.out.println("Service found");

            int wishedNumber = Integer.parseInt(args[1]);

            Calculation calculation = new EulerCalculation(wishedNumber);
            Callback callback = new CalculationCallback();
            Callback callbackUnicast = (Callback) UnicastRemoteObject.exportObject(callback, 0);
            Command command = new CalculationCommand(calculation, callbackUnicast);

            uRemoteObject.doSomething(command);

            while ( System.in.read() != '\n' );
                UnicastRemoteObject.unexportObject(callback, true);

        } catch (RemoteException re) {
            System.err.println("Service not found?" + " Check your RMI-Registry!");
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Service exception:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}