/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charoy
 */
public class Client implements SensorListener {
    ISensor sense;
    Scanner c=new Scanner(System.in);
    public Client(ISensor sensor) {
        sense=sensor;
    }
    
    public void menu() {
        String rep="";
        while (!"q".equals(rep)) {
            try {
                rep= c.nextLine();
                switch (rep) {
                    case "o": {
                        sense.onOff(this);
                        break;
                    }
                    case "s": {
                        System.out.println("status :"+sense.getStatus());
                        break;
                    }
                    case "v": {
                        System.out.println("value :"+sense.getValue());
                        break;
                    }
                    default : System.out.println("q: quitter - o: switch - s: status - v: value");
                }
            } catch (SensorNotActivated ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException e) {
				e.printStackTrace();
			}
        }
    }

	@Override
	public void statusChanged() {
		System.out.println("Callback to Client");
	}
    
//   Code pour JDK 1.6
//
//       public void menu6() {
//        String rep="";
//        while (!"q".equals(rep)) {
//            try {
//                rep= c.nextLine();
//                if ("o".equals(rep))
//                        sense.onOff();
//                else if ("s".equals(rep))
//                        System.out.println("status :"+sense.getStatus());
//                else if ("v".equals(rep))
//                        System.out.println("value :"+sense.getValue());
//                else System.out.println("q: quitter - o: switch - s: status - v: value");
//            } catch (SensorNotActivated ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
