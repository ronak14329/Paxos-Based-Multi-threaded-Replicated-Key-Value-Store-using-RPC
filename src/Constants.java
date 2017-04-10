import java.text.DateFormat;
import java.text.SimpleDateFormat;


public interface Constants {

	/** The formatter for Date and timestamp **/
	DateFormat FORMATTER = new SimpleDateFormat("HH:mm:ss:SSS");
	
	/** The port numbers for server1 */
	int SERVER1_PORT_NO = 12345;

	/** The port numbers for all server2 */
	int SERVER2_PORT_NO = 12346;
	
	/** The port numbers for all server3 */
	int SERVER3_PORT_NO = 12347;
	
	/** The port numbers for all server4 */
	int SERVER4_PORT_NO = 12348;
	
	/** The port numbers for all server5 */
	int SERVER5_PORT_NO = 12349;

	/** The RMI Name for Server1 */
	String SERVER1 = "Server1";
	
	/** The RMI Name for Server2 */
	String SERVER2 = "Server2";
	
	/** The RMI Name for Server3 */
	String SERVER3 = "Server3";
	
	/** The RMI Name for Server4 */
	String SERVER4 = "Server4";
	
	/** The RMI Name for Server5 */
	String SERVER5 = "Server5";

	/** Size of the map in keystore **/
	int MAP_SIZE = 1500;
	 
	/** Number of servers participating  **/
	int NUMBER_OF_SERVERS = 5;

}
