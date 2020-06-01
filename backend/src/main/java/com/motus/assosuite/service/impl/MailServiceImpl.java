package com.motus.assosuite.service.impl;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.motus.assosuite.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private final String ADD_SUBJECT_MAIL="Adhesion réussie";
	
	@Override
	public void sendMailOnAdd(String adhrentMail) throws MessagingException, IOException{
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(adhrentMail);
        msg.setSubject(ADD_SUBJECT_MAIL);
        msg.setText("AZUUUUUUUUUUUUUUUUUL      ==== Bonjour, vous venez d'être ajouté à une association");
        javaMailSender.send(msg);
	}

}