/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

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
        	ISensor sensor = (ISensor) registry.lookup(name);
        	Client c = new Client(sensor);
        	c.menu();
        } catch(Exception e) {
        	System.out.println("Sensor exception:");
        	e.printStackTrace();
        }
    }
}
