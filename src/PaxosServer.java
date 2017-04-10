

import java.net.SocketTimeoutException;
import java.rmi.RemoteException;


public class PaxosServer implements KeyStoreInterface{
	
	private Proposer proposer;
	
	private Learner learner;
	private Acceptor acceptor;

	public PaxosServer(int serverNumber) throws RemoteException {
		proposer = new Proposer();
		learner = new Learner();
		acceptor = new Acceptor();
		proposer.start();
		learner.start();
		acceptor.start();
		acceptor.setServerNumber(serverNumber);
	}
	
	public String get(int key){

		return proposer.propose(key, 1);
	}
	
	
	public String put(int key){
		
		return proposer.propose(key, 2);
	}

	
	public String delete(int key){

		return proposer.propose(key, 3);
	}

	@Override
	public boolean prepare(int proposalId, int key, int action)
			throws RemoteException, SocketTimeoutException {
		return acceptor.prepare(proposalId, key, action);
	}
	
	@Override
	public boolean accept(int proposalId, int key, int action) 
			throws RemoteException, SocketTimeoutException  {
		return acceptor.accept(proposalId, key, action);
	}

	@Override
	public String commit(int key, int action) 
			throws RemoteException, SocketTimeoutException  {
		return learner.commit(key, action);			
	}
}
