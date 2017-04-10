import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ServerHelper {
	
	
	public static Map<String, String> getServerMap(){
		Map<String, String> propertyMap = new HashMap<String, String>();
		try{
			Properties properties = new Properties();
			InputStream in = ServerHelper.class.getResourceAsStream("servers.properties");
			properties.load(in);			
			Enumeration<?> e = properties.propertyNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = properties.getProperty(name);
				propertyMap.put(name, value);
			}
		} catch(FileNotFoundException fnfe){
			System.out.println("Properties file not found" + fnfe);
		} catch(IOException ioe){
			System.out.println("IOException while reading the properties file" + ioe);
		}
		return propertyMap;
	}
	
	public static int getPortNumber(String value) {
		if(value.equals(Constants.SERVER1)){
			return Constants.SERVER1_PORT_NO;
		}
		if(value.equals(Constants.SERVER2)){
			return Constants.SERVER2_PORT_NO;
		}
		if(value.equals(Constants.SERVER3)){
			return Constants.SERVER3_PORT_NO;
		}
		if(value.equals(Constants.SERVER4)){
			return Constants.SERVER4_PORT_NO;
		}
		if(value.equals(Constants.SERVER5)){
			return Constants.SERVER5_PORT_NO;
		}
		return 0;
	} 
}
