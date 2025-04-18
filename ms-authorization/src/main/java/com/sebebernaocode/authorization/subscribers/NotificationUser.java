package com.sebebernaocode.authorization.subscribers;
import com.sebebernaocode.authorization.entities.email.Email;
import com.sebebernaocode.authorization.entities.user.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NotificationUser {
    public final RabbitTemplate rabbitTemplate;
    public NotificationUser(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    private final String routingKey = "send-email";

    public void publishRegistrationEmail (User user) {
        var email = new Email();
        email.setFromEmail("marchesaneduardofw@gmail.com");
        email.setToEmail(user.getEmail());
        email.setSubject("Registration completed successfully!");
        email.setBody(user.getFirstName() + " Your registration has been completed!");
        rabbitTemplate.convertAndSend(routingKey, email);
    }

    public void publishChangePasswordEmail (User user) {
        var email = new Email();
        email.setFromEmail("marchesaneduardofw@gmail.com");
        email.setToEmail(user.getEmail());
        email.setSubject("Change password completed successfully!");
        email.setBody(user.getFirstName() + " Your password has been changed!");
        rabbitTemplate.convertAndSend(routingKey, email);
    }

    public void publishChangeEmail (User user) {
        var email = new Email();
        email.setFromEmail("marchesaneduardofw@gmail.com");
        email.setToEmail(user.getEmail());
        email.setSubject("Your information was changed successfully!");
        email.setBody(user.getFirstName() + " Your information on our system has been changed!");
        rabbitTemplate.convertAndSend(routingKey, email);
    }
}
