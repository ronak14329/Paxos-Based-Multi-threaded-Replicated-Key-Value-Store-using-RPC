

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.Scanner;


public class KeyStoreClient {

	public static void main(String args[]){
		try {
			Registry registry = LocateRegistry.getRegistry(args[0], 
					ServerHelper.getPortNumber(args[1]));
			KeyStoreInterface stub = (KeyStoreInterface) registry.lookup(args[1]);
			int count=2;
			
			System.out.println("Server response time : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.put(1007));
			System.out.println("Server response time  "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.get(100));
			System.out.println("Server response time  "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.put(2000));
			System.out.println("Server response time : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.delete(1410));
			System.out.println("Server response time  : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.get(1000));
			System.out.println("Server response time  : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.put(1510));
			System.out.println("Server response time  : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.delete(754));
			System.out.println("Server response time  : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.get(1420));
			System.out.println("Server response time  : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.put(2000));
			System.out.println("Server response time : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.delete(417));
			System.out.println("Server response time  : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.get(427));
			System.out.println("Server response time  : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.put(2153));
			System.out.println("Server response time  : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.delete(2553));
			System.out.println("Server response time  : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.get(810));
			System.out.println("Server response time : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.put(1777));
			System.out.println("Server response time  : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.delete(1111));
			System.out.println("Server response time : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.put(1788));
			
			System.out.println( "our Key value store is populated now You can enter new value");
			while(count>0)
			{
				System.out.println("Enter the operation PUT/GET/DEL");
			Scanner Scan = new Scanner(System.in);
			String s1= Scan.nextLine();
			
			if(s1.equalsIgnoreCase("PUT"))
			{System.out.println("Enter the Key");
			int s2=Scan.nextInt();
			System.out.println("You have entered the Key " + s2 + " whose the value is automatically generated and the value is " +(s2*s2));
			System.out.println("Server response time  "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.put(s2));
			}
			else if(s1.equalsIgnoreCase("GET"))
			{System.out.println("Enter the Key");
			int s2 = Scan.nextInt();
			System.out.println(" You have Entered Key " + s2 );
			System.out.println("Server response time  "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.get(s2));
			
			}
			else if(s1.equalsIgnoreCase("DEL"))
			{System.out.println("Enter the Key");
			int s2 = Scan.nextInt();
			System.out.println(" You have Entered Key " + s2);
			System.out.println("Server response time : "+Constants.FORMATTER.format(new Date().getTime()) + " " + stub.delete(s2));
			
			}
			else 
			{System.out.println("You have entered a invalid String" );
			
			}
			count--;
			
			}
		
		}
		catch(RemoteException re){
			System.out.println("Unable to find the RMI Server");
		} catch(NotBoundException ne){
			System.out.println("RMI Server not bound");
		}
	}
}
