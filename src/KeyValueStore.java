import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class KeyValueStore {
private HashMap<Integer, Integer> keyValueMap = null;
	
	public KeyValueStore(){
		keyValueMap = new HashMap<Integer, Integer>();
		for(int i = 1 ; i <= Constants.MAP_SIZE ; i++){
			keyValueMap.put(i, getValue(i));
		}
	}
	
	
	private static int getValue(int key){
		return key*key;
	}

	
	public String getKey(int key) {
		String response  = "Returning value : "+ keyValueMap.get(key)
				+" for the key : " + key + " from the store";
		System.out.println(response + " at : " 
		+ Constants.FORMATTER.format(new Date().getTime()));
		return response;
	}
	
		public String putKey(int key) {
		String response  = "Added key : " + key + " to the store";
		keyValueMap.put(key, getValue(key));
		System.out.println(response + " at : " 
		+ Constants.FORMATTER.format(new Date().getTime()));
		return response;
	}
	
	public String deleteKey(int key) {
		String response  = "Deleted key : " + key + 
		        			" from the store";
		Set<Integer> set = keyValueMap.keySet();
	    Iterator<Integer> itr = set.iterator();
	    while (itr.hasNext())
	    {
	        Integer obj = itr.next();
	        if (obj.equals(key)) {
		        	itr.remove();
		        	System.out.println(response+" at :" 
		        	+ Constants.FORMATTER.format(new Date().getTime()));
		        	break;
			}
	    }
	    return response;
	}	
	
	public boolean checkAction(int key, int action){
		//If get the action is 1, put then action is 2 and delete then action is 3
		switch(action) {
		case 1:if(keyValueMap.containsKey(key))
				return true;				
		case 2:if(!keyValueMap.containsKey(key))
				return true;				
		case 3:if(keyValueMap.containsKey(key))
				return true;				
		}
		return false;
	}
}
