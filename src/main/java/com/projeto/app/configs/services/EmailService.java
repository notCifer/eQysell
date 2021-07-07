package com.projeto.app.configs.services;

import com.projeto.app.configs.tools.UserPDFExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail (String email, UserPDFExporter exporter,String body, String subject){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("eqysselproj@gmail.com");
        message.setTo(email);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        
    }
    
    
}