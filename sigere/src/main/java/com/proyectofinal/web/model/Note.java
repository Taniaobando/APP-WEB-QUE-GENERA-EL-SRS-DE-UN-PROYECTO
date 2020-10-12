package com.proyectofinal.web.model;
/**
 * Project:Sigere
 * Developer:Tania Obando
 * Contact email: taniaobando1998@gmail.com
 * Creation date: 15/05/2019
 * Last modification: 23/05/2019
 */
public class Note {
	
	private String receiver; //The receiver is the username of the person whoes the note is addressed to.
	private String nte ; //The nte is the note sent to the receiver from the sender.
	private String sender; //The sender is the username of the person who sent the note.
	
	
	public Note (final String receiver, final String nte, final String sender) {
		this.receiver=receiver;
		this.nte=nte;
		this.sender=sender;
	}
	
	public String getReceiver() {
		return receiver;
	}
	public String getNte() {
		return nte;
	}
	public String getSender() {
		return sender;
	}
}
