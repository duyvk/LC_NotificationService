package unitn.introsde.notification_service.endpoint;

import javax.xml.ws.Endpoint;

import unitn.introsde.notification_service.ws.NotificationImpl;


// TODO: Auto-generated Javadoc
/**
 * The Class PeoplePublisher.
 */
public class NotificationPublisher {
	
	/** The server url. */
	public static String SERVER_URL = "http://localhost";
	
	/** The port. */
	public static String PORT = "5901";
	
	/** The base url. */
	public static String BASE_URL = "/ws/notification";
	
	/**
	 * Gets the endpoint url.
	 *
	 * @return the endpoint url
	 */
	public static String getEndpointURL() {
		return SERVER_URL+":"+PORT+BASE_URL;
	}
 
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String endpointUrl = getEndpointURL();
		System.out.println("Starting Notification Service...");
		System.out.println("--> Published at = "+endpointUrl);
		Endpoint.publish(endpointUrl, new NotificationImpl());
    }
}

