package eu.telecomnancy;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

	public static void main(String[] args) {
		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			String name = "sensor";
			ISensor sensor = new RandomSensor();
			ISensor stub = (ISensor) UnicastRemoteObject.exportObject(sensor, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, stub);
			System.out.println("New registry binded for object "+name);
		} catch (Exception e) {
			System.err.println("Sensor exception:");
			e.printStackTrace();
		}
	}

}
