package com.proyectofinal.web.service;
/**
 * Project:Sigere
 * Developer:Tania Obando
 * Contact email: taniaobando1998@gmail.com
 * Creation date: 25/05/2019
 * Last modification: 29/05/2019
 */



public interface MailService{
	//Returns the password of a email given.
	public String getPasswordByEmail(String email);
	//Sends a email to the user with his/her password.
	public boolean sendEmail(String destination, String password);

}
