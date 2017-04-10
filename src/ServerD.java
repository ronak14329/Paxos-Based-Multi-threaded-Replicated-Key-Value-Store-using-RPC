import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Server4
 * 
 *
 *
 */
public class ServerD extends PaxosServer{

	public ServerD(int serverNumber) throws RemoteException {
		super(serverNumber);
	}

	public static void main(String args[]) throws Exception{
    	
		
		try {
		    ServerD server = new ServerD(4);
		    
		    KeyStoreInterface stub = (KeyStoreInterface) 
		    		UnicastRemoteObject.exportObject(server, 0);
		    Registry registry = LocateRegistry.createRegistry(Constants.SERVER4_PORT_NO); 
		    registry.bind(Constants.SERVER4, stub);
	
		    System.out.println("ServerD ready");
		} catch (Exception e) {
		    System.out.println("Server exception: " + e.toString());
		}
		
	    }
}
