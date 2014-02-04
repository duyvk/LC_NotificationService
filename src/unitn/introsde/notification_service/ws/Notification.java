package unitn.introsde.notification_service.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface Notification {

	@WebMethod(operationName = "sendEmail")
	public void sendEmail (@WebParam(name="emailAddress") String emailAddress, 
			@WebParam(name="subject") String subject, @WebParam(name="body") String body);
	
	
}
