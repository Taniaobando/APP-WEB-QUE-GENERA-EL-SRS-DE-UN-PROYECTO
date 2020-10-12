package com.proyectofinal.web.model;
/**
 * Project:Sigere
 * Developer:Tania Obando
 * Contact email: taniaobando1998@gmail.com
 * Creation date: 15/05/2019
 * Last modification: 18/05/2019
 */
public class NoteCreate {
	private String  receiver; //The receiver is the username of the person that receivs the note.
	private String nte; //The nte is the note for the receiver.
	
	public NoteCreate(final String receiver , final String nte) {
		this.receiver =receiver;
		this.nte=nte;
		
	}
	
	public NoteCreate () {
			
	}
	
	public void setReceiver (final String receiver) {
		this.receiver=receiver;
	}
	
	public String getReceiver() {
		return receiver;
	}
	
	public void setNte (final String nte) {
		this.nte=nte;
		
	}
	public String getNte() {
		return nte;
	}
	
	
		
}
