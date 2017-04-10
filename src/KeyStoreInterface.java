

import java.net.SocketTimeoutException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface KeyStoreInterface extends Remote {
	
	  
	  public String get(int key) throws RemoteException;
	  public String put(int key) throws RemoteException;
	  public String delete(int key) throws RemoteException;
	   public boolean prepare(int proposalId, int key, int action) 
			  throws RemoteException, SocketTimeoutException;
	  public boolean accept(int proposalId, int key, int action) 
			  throws RemoteException, SocketTimeoutException;
	   public String commit(int key, int action) 
			  throws RemoteException, SocketTimeoutException;

}
