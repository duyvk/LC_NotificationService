package unitn.introsde.notification_service.ws;

import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebService(endpointInterface="unitn.introsde.notification_service.ws.Notification", serviceName="NotificationService")
public  class NotificationImpl implements Notification{

	@Override
	@WebMethod(operationName = "sendEmail")
	public void sendEmail(@WebParam(name = "emailAddress") String emailAddress,
			@WebParam(name = "subject") String subject,
			@WebParam(name = "body") String body) {
		
		final String username = "trento.univ@gmail.com";
		final String password = "trentouniv39";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("trento.univ@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(emailAddress));
			message.setSubject(subject);
			message.setText(body
				+ "\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
			/*System.out.println(e.getMessage());*/
		}
	}
/*	public static void main(String[] args) {
		new NotificationImpl().sendEmail("duyvkvn@gmail.com", "test", "test");
	}*/
}
