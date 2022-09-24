package Pi.Spring.Service;
import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.EmailDetails;
import Pi.Spring.Entity.partenaires;
import Pi.Spring.Repositury.PartenaireRepository;

@Service
public class EmailService implements IEmailService {
	
	 
	    @Autowired
	    private JavaMailSender javaMailSender;
		@Autowired
		PartenaireRepository partenaireRepository;
	 
	    @Value("${spring.mail.username}") private String sender;
	 
	    // Method 1
	    // To send a simple email
	    public String sendSimpleMail(EmailDetails details)
	    {
	 
	        // Try block to check for exceptions
	        try {
	 
	            // Creating a simple mail message
	            SimpleMailMessage mailMessage
	                = new SimpleMailMessage();
	 
	            // Setting up necessary details
	            mailMessage.setFrom("es9667000@gmail.com");
	            mailMessage.setTo(details.getRecipient());
	            mailMessage.setText(details.getMsgBody());
	            mailMessage.setSubject(details.getSubject());
	 
	            // Sending the mail
	            javaMailSender.send(mailMessage);
	            return "Mail Sent Successfully...";
	        }
	 
	        // Catch block to handle the exceptions
	        catch (Exception e) {
	            return "Error while Sending Mail";
	        }
	    }
	 
	    // Method 2
	    // To send an email with attachment
	    public String
	    sendMailWithAttachment(EmailDetails details)
	    {
	        // Creating a mime message
	        MimeMessage mimeMessage
	            = javaMailSender.createMimeMessage();
	        MimeMessageHelper mimeMessageHelper;
	 
	        try {
	 
	            // Setting multipart as true for attachments to
	            // be send
	            mimeMessageHelper
	                = new MimeMessageHelper(mimeMessage, true);
	            mimeMessageHelper.setFrom(sender);
	            mimeMessageHelper.setTo(details.getRecipient());
	            mimeMessageHelper.setText(details.getMsgBody());
	            mimeMessageHelper.setSubject(
	                details.getSubject());
	 
	            // Adding the attachment
	            FileSystemResource file
	                = new FileSystemResource(
	                    new File(details.getAttachment()));
	 
	            mimeMessageHelper.addAttachment(
	                file.getFilename(), file);
	 
	            // Sending the mail
	            javaMailSender.send(mimeMessage);
	            return "Mail sent Successfully";
	        }
	 
	        // Catch block to handle MessagingException
	        catch (MessagingException e) {
	 
	            // Display message when exception occurred
	            return "Error while sending mail!!!";
	        }
	    }
	    
	    
	    
	    
	 // Method 3
	    // To send an email to more than one +
	    public String sendEMailByActivity(EmailDetails details,String activite)
	    {
//to know how many mail
	    	 List<partenaires> list = 	partenaireRepository.findByActivite( activite);
	    	 int nbremails = list.size();

	    			 
	    			 
	    			// Try block to check for exceptions
	    		        try {
	    		        	 if(nbremails>1) {
	    			    		 //there wehave 2 or more so 
	    			    		 for(int i = 0; i < nbremails; i++) {
	    		            // Creating a simple mail message
	    		            SimpleMailMessage mailMessage
	    		                = new SimpleMailMessage();
	    		 
	    		            // Setting up necessary details
	    		            mailMessage.setFrom("es9667000@gmail.com");
	    		            mailMessage.setTo(list.get(i).getEmail());
	    		            mailMessage.setText(details.getMsgBody());
	    		            mailMessage.setSubject(details.getSubject());
	    		 
	    		            // Sending the mail
	    		            javaMailSender.send(mailMessage);
	    		           
	    			    		 }}
	    		        	 return "Mail Sent Successfully...";
	    		        }
	    		 
	    		        // Catch block to handle the exceptions
	    		        catch (Exception e) {
	    		            return "Error while Sending Mail";
	    		        }
	    		        

	        
	    }
	    
	    
	    
	    

}
