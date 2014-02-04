package unitn.introsde.notification_service.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import unitn.introsde.notification_service.ws.Notification;


public class NotificationClient {

	static URL url;

	public static void main(String[] args) {
		try {
			url = new URL ("http://localhost:5901/ws/notification?wsdl");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		QName qname = new QName("http://ws.notification_service.introsde.unitn/", "NotificationService");

		Service service = Service.create(url,qname);

		Notification notification = service.getPort(Notification.class);
		
		notification.sendEmail("duyvkvn@gmail.com", "test2", "bodytest2");
	}
}