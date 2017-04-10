import java.net.SocketTimeoutException;
import java.rmi.RemoteException;

public class Acceptor extends KeyValueStore implements Runnable{

	private static int myproposalId;
	
	private boolean active;
	
	private int serverNumber;

	public int getMyproposalId() {
		return myproposalId;
	}

	public void setMyproposalId(int myproposalId) {
		Acceptor.myproposalId = myproposalId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isAlive) {
		this.active = isAlive;
	}
	
	public void start(){
		active = true;
	}
	
	public void kill(){
		active = false;
	}
	
	public boolean accept(int proposalId, int key, int action) throws RemoteException,
	SocketTimeoutException{
		return check(proposalId, key, action);
	}
	
	public boolean prepare(int proposalId, int key, int action) throws RemoteException,
	SocketTimeoutException{
		return check(proposalId, key, action);
	}

	private boolean check(int proposalId, int key, int action) throws RemoteException
	, SocketTimeoutException{
		//Randomly put a server to sleep
		try{
			if(((int)((Math.random()*Constants.NUMBER_OF_SERVERS)+1)) == serverNumber){
				System.out.println("Server"+serverNumber+" going to sleep");
				Thread.sleep(10000);
			}
		} catch (InterruptedException ie){
			
		}
		if(proposalId < myproposalId){
			return false;
		}
		if(super.checkAction(key, action)){
			setMyproposalId(proposalId);
			return true;
		}
		return false;
	}

	public int getServerNumber() {
		return serverNumber;
	}

	public void setServerNumber(int serverNumber) {
		this.serverNumber = serverNumber;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
