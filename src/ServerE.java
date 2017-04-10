import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Server5
 * 
 * 
 *
 */
public class ServerE extends PaxosServer{

	public ServerE(int serverNumber) throws RemoteException {
		super(serverNumber);
	}

	public static void main(String args[]) throws Exception{
    	
		
		try {
		    ServerE server = new ServerE(5);
		    
		    KeyStoreInterface stub = (KeyStoreInterface) 
		    		UnicastRemoteObject.exportObject(server, 0);
		    Registry registry = LocateRegistry.createRegistry(Constants.SERVER5_PORT_NO); 
		    registry.bind(Constants.SERVER5, stub);
	
		    System.out.println("Hello ....... :)ServerE ready");
		} catch (Exception e) {
		    System.out.println("Server exception: " + e.toString());
		}
		
	    }
}
