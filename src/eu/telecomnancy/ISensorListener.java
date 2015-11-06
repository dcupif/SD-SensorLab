package eu.telecomnancy;

import java.rmi.RemoteException;

public interface ISensorListener extends ISensor {
	public void addListener(SensorListener s) throws RemoteException;
}
