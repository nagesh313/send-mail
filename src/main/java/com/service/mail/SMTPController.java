package main.java.com.service.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

@CrossOrigin
@RequestMapping("/api/SMTPController")
public class SMTPController {
    @GetMapping("/health")
    public String health(@PathVariable String body) {
        return "Ok";
    }

    @GetMapping("/send/{body}")
    public void sendSimpleMessage(@PathVariable String body) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("lushdelightful.decor");
        mailSender.setPassword(password);
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("lushdelightful.decor@gmail.com");
        message.setTo("lushdelightful.decor@gmail.com");
        message.setSubject("lushdelightful.decor@gmail.com");
        message.setText(body);
        mailSender.send(message);
    }

    @Value("${spring.mail.password}")
    private String password;

}