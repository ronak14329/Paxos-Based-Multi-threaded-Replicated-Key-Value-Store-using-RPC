/**
 * Learner is responsible to maintain the state of the server and handles the commits to it
 
 */
public class Learner extends KeyValueStore implements Runnable{

	public void start(){
		
	}
	
	public String commit(int key, int action){
		String response = "";
		// If the consensus is met then go ahead and perform the commit
		switch(action) {
			case 1: response = super.getKey(key);
					break;
			case 2: response = super.putKey(key);
					break;
			case 3: response = super.deleteKey(key);
					break;
		}
		return response;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
