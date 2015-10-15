/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.RemoteException;
import java.util.Random;

/**
 *
 * @author charoy
 */
public class RandomSensor implements ISensor {
    private boolean status=false; //false = off - true = on
    double start = 50;
    double end = 100;
    
    @Override
    public double getValue() throws SensorNotActivated, RemoteException {
        if (status) {
         double random = new Random().nextDouble();
        return start + (random * (end - start));    
        } else throw new SensorNotActivated("random Sensor not activated");
    }

    @Override
    public void onOff() throws RemoteException {
        status=!status;
    }

    @Override
    public boolean getStatus() throws RemoteException {
        return status;
    }
    
}
