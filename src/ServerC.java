import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Server3
 * 
 * 
 *
 */
public class ServerC extends PaxosServer{

	public ServerC(int serverNumber) throws RemoteException {
		super(serverNumber);
	}

	public static void main(String args[]) throws Exception{
    	
		
		try {
		    ServerC server = new ServerC(3);
		    
		    KeyStoreInterface stub = (KeyStoreInterface) 
		    		UnicastRemoteObject.exportObject(server, 0);
		    Registry registry = LocateRegistry.createRegistry(Constants.SERVER3_PORT_NO); 
		    registry.bind(Constants.SERVER3, stub);
	
		    System.out.println("ServerC ready");
		} catch (Exception e) {
		    System.out.println("Server exception: " + e.toString());
		}
		
	    }
}
