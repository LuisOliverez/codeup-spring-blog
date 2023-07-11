package com.codeup.codeupspringblog.models;

import com.codeup.codeupspringblog.controllers.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("mailService")
public class EmailService {


    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

//    @Autowired
//    public EmailService(JavaMailSender emailSender) {
//        this.emailSender = emailSender;
//    }

    public void prepareAndSend(Post post, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(post.getUser().getEmail());
        msg.setSubject(subject);
        msg.setText(body);

        System.out.println(Arrays.toString(msg.getTo()));
        System.out.println(msg.getFrom());
        System.out.println(msg.getText());
        System.out.println(msg.getSubject());


        try {
            this.emailSender.send(msg);
//            System.out.println("Email sent successfully to: " + post.getUser().getEmail());
        } catch (MailException ex) {
            System.err.println("Failed to send email: " + ex.getMessage());
        }
    }
}