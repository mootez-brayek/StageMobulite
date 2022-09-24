package Pi.Spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Pi.Spring.Entity.EmailDetails;
import Pi.Spring.Service.IEmailService;


@RestController
@RequestMapping("/email")
@CrossOrigin("*")
public class EmailController {

	 @Autowired private IEmailService emailService;
	 
	    // Sending a simple Email
	    @PostMapping("/sendMail")
	    public String
	    sendMail(@RequestBody EmailDetails details)
	    {
	        String status
	            = emailService.sendSimpleMail(details);
	 
	        return status;
	    }
	 
	    // Sending email with attachment
	    @PostMapping("/sendMailWithAttachment")
	    public String sendMailWithAttachment(
	        @RequestBody EmailDetails details)
	    {
	        String status
	            = emailService.sendMailWithAttachment(details);
	 
	        return status;
	    }
	    
	    // Sending email By Activity
	    @PostMapping("/sendEMailByActivity/{activity}")
	    public String sendEMailByActivity( @RequestBody EmailDetails details,@PathVariable(value="activity") String activity)
	    {
	        String status
	            = emailService.sendEMailByActivity(details,activity);
	 
	        return status;
	    }
	    

}
