import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Server1
 * 
 * 
 *
 */
public class ServerA extends PaxosServer{

	public ServerA(int serverNumber) throws RemoteException {
		super(serverNumber);
	}

	public static void main(String args[]) throws Exception{
    	
		
		try {
		    ServerA server = new ServerA(1);
		    
		    KeyStoreInterface stub = (KeyStoreInterface) 
		    		UnicastRemoteObject.exportObject(server, 0);
		    Registry registry = LocateRegistry.createRegistry(Constants.SERVER1_PORT_NO); 
		    registry.bind(Constants.SERVER1, stub);
	
		    System.out.println("Hello :) ServerA ready");
		} catch (Exception e) {
		    System.out.println("Server exception: " + e.toString());
		}
		
	    }
}
