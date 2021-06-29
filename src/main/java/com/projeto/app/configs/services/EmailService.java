package com.projeto.app.configs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail (String email, String body, String subject){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("eqysselproj@gmail.com");
        message.setTo(email);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("TESTEEE");

    }
    
    
}