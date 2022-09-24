package Pi.Spring.Service;

import Pi.Spring.Entity.EmailDetails;

public interface IEmailService {
	 // To send a simple email
	public String sendSimpleMail(EmailDetails details);
	 // To send an email with attachment
	public String sendMailWithAttachment(EmailDetails details);
	
	 public String sendEMailByActivity(EmailDetails details,String activite);

}
