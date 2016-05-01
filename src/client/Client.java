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

/**
 * Klasse, welche vom Client gestartet wird.
 */
public class Client {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            //Mit der Registry verbinden an einer IP-Adresse mit dem Standard Port 1099
            Registry registry = LocateRegistry.getRegistry(args[0]);

            //DoSomethingService vom Server bekommen
            DoSomethingService uRemoteObject = (DoSomethingService) registry.lookup("Service");
            System.out.println("Service found");

            //Anzahl der digits speichern
            int wishedNumber = Integer.parseInt(args[1]);

            //Callback erstellen
            Callback callback = new CalculationCallback();
            //Callback dem Server übergeben und dann einen gemeinsamen Callback speichern
            Callback callbackUnicast = (Callback) UnicastRemoteObject.exportObject(callback, 0);
            //Den gemeinsamen Callback der Calculation übergeben, welcher bei erfolgreicher Berechnung diesen aufruft.
            Calculation calculation = new EulerCalculation(wishedNumber, callbackUnicast);
            //Command aus der Calculation erstellen
            Command command = new CalculationCommand(calculation);
            //Und dem DoSomethingService vom Server übergeben
            uRemoteObject.doSomething(command);

            System.exit(1);
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