/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author charoy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
//        if (System.getSecurityManager() == null) {
//        	System.setSecurityManager(new SecurityManager());
//        }
        
        try {
        	String name = "sensor";
        	Registry registry = LocateRegistry.getRegistry();
        	ISensorListener sensor = (ISensorListener) registry.lookup(name);
        	Client c = new Client(sensor);
        	Client stub = (Client) UnicastRemoteObject.exportObject(c,0);
        	sensor.addListener(stub);
        	c.menu();
        } catch(Exception e) {
        	System.out.println("Sensor exception:");
        	e.printStackTrace();
        }
    }
}
