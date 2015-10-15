/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import org.junit.Test;
import static org.junit.Assert.*;

import java.rmi.RemoteException;

/**
 *
 * @author charoy
 */
public class RandomSensorTest {
    /**
     * Test of getValue method, of class RandomSensor.
     */
    @Test
    public void testGetValue() throws Exception {
        System.out.println("getValue");
        RandomSensor instance = new RandomSensor();
        instance.onOff();
        double result = instance.getValue();
        assertTrue(result>0.0);
    }

    @Test
    public void testGetValueFail() throws Exception {
        System.out.println("getValueFail");
        RandomSensor instance = new RandomSensor();
        try {
            //double result = instance.getValue();
            fail("Should have throw an exception. The sensor is off");
            instance.getValue();
        } catch (SensorNotActivated s) {
            assertTrue(!instance.getStatus());
        }
    }

    /**
     * Test of onOff method, of class RandomSensor.
     */
    @Test
    public void testOnOff() {
        System.out.println("onOff");
        RandomSensor instance = new RandomSensor();
        try {
			assertFalse(instance.getStatus());
	        instance.onOff();
	        assertTrue(instance.getStatus());
	        instance.onOff();
	        assertFalse(instance.getStatus());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}