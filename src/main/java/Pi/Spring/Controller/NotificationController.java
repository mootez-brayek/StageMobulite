package Pi.Spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Pi.Spring.Entity.Notifications;

@RestController
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate template;

    // Initialize Notifications

    
    private Notifications notificationsE = new Notifications("emails successfully sent ");

    
    @GetMapping("/notify")
    public String getNotification() {

        // Increment Notification by one
      //  notifications.increment();

        // Push notifications to front-end
        template.convertAndSend("/topic/notification", notificationsE);

        return "Notifications successfully sent to Angular !";
    }
}