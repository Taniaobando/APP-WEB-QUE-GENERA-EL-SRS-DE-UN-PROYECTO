package com.proyectofinal.web.service;

import java.util.List;

import com.proyectofinal.web.model.NoteCreate;
import com.proyectofinal.web.model.Note;
/**
 * Project:Sigere
 * Developer:Tania Obando
 * Contact email: taniaobando1998@gmail.com
 * Creation date: 15/05/2019
 * Last modification: 23/05/2019
 */
public interface NoteService{
	//Associates a Message to a user
	void linkMessageWithUser(NoteCreate note, String sender, int id);
	//Returns the notes for a user sent in the same project
	List<Note> getNotesByName (String receiver, int projectId);

}




	