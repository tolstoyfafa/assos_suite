package com.motus.assosuite.service;

import java.io.IOException;

import javax.mail.MessagingException;

public interface MailService {
	
	void sendMailOnAdd(String adhrentMail ) throws MessagingException, IOException;
}