/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.Remote;

/**
 *
 * @author charoy
 */
public interface SensorListener extends Remote {
    public void statusChanged();
}
