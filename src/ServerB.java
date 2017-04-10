import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Server2
 * 
 * 
 *
 */
public class ServerB extends PaxosServer{

	public ServerB(int serverNumber) throws RemoteException {
		super(serverNumber);
	}

	public static void main(String args[]) throws Exception{
    	
		
		try {
		    ServerB server = new ServerB(2);
		    KeyStoreInterface stub = (KeyStoreInterface) 
		    		UnicastRemoteObject.exportObject(server, 0); 
		    Registry registry = LocateRegistry.createRegistry(Constants.SERVER2_PORT_NO);  
		    registry.bind(Constants.SERVER2, stub);
	
		    System.out.println("ServerB ready");
		} catch (Exception e) {
			System.out.println("Server exception: " + e.toString());
		}
		
	    }
}