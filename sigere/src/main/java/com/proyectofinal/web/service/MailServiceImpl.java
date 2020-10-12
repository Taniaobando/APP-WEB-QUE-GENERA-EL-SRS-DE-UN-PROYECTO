package com.proyectofinal.web.service;

import java.util.Properties;


import org.springframework.beans.factory.annotation.Autowired;

import com.proyectofinal.web.dao.MailDao;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Project:Sigere
 * Developer:Tania Obando
 * Contact email: taniaobando1998@gmail.com
 * Creation date: 25/05/2019
 * Last modification: 29/05/2019
 */

public class MailServiceImpl implements MailService{
	
	//Create a Mail Dao to access to its functions.
	@Autowired
	public MailDao mailDao;

	//Returns the password of the user
	@Override
	public String getPasswordByEmail(String email) {
		return mailDao.getPasswordByEmail(email);
	}
	
	@Override
	//This function was implemented with parts of code of the video https://youtu.be/DeVSmx6X5aM.
	//Sends the email using the java email package. It also verifies if the correct was sent correctly. 
	public boolean sendEmail (String destination,String password) {
		

		try {

			Properties properties =new Properties();
			properties.put("mail.smtp.host","smtp.gmail.com");
			properties.setProperty("mail.smtp.starttls.enable","true");
			properties.setProperty("mail.smtp,port", "587");
			properties.setProperty("mail.smtp.user","ingesoftvtl@gmail.com");
			properties.setProperty("mail.smtp.auth", "true");
			
			Session session = Session.getInstance(properties,
	                 new javax.mail.Authenticator() {
	                     protected PasswordAuthentication getPasswordAuthentication() {
	                         return new PasswordAuthentication("ingesoftvtl@gmail.com","ovklivlgiyzpqvkx");
	                     }
	                 });

			
			MimeMessage message= new MimeMessage(session );
			message.setFrom(new InternetAddress("ingesoftvtl@gmail.com"));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(destination));
			message.setSubject("COMO RESPUESTA A SU SOLICITUD SE ADJUNTA A ESTE EMAIL SU CONTRASEÑA");
			message.setText("La contraseña es: "+password);
			
			Transport.send(message);
			System.out.println("good"); 

			
			return true;
			
			
		}catch(Exception e) {
			System.out.println("Error"+e); 
			
			return false;
		}
	}
}
