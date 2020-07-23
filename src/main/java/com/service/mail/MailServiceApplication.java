package com.service.mail;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailServiceApplication.class, args);
	}

}

@RestController
class Health {
	@GetMapping("/health")
	public String health() {
		return "Ok";
	}

	@CrossOrigin
	@GetMapping("/api/SMTPController/send/{body}")
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
