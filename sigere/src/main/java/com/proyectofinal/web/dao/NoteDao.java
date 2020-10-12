package com.proyectofinal.web.dao;

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

public interface NoteDao {
		//Associates a message to a user in specific.
		void linkMessageWithUser(NoteCreate note, String sender, int id);
		//Returns all the notes for a user and a project in specific.
		List <Note> getNotesByName (String receiver, int projectId);

			
}
