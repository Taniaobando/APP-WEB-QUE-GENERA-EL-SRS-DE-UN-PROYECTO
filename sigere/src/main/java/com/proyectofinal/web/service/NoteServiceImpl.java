package com.proyectofinal.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyectofinal.web.dao.NoteDao;
import com.proyectofinal.web.model.NoteCreate;
import com.proyectofinal.web.model.Note;
import com.proyectofinal.web.service.NoteService;
/**
 * Project:Sigere
 * Developer:Tania Obando
 * Contact email: taniaobando1998@gmail.com
 * Creation date: 15/05/2019
 * Last modification: 23/05/2019
 */

public class NoteServiceImpl implements NoteService {
		//Create a Note Dao to access to its functions.
		@Autowired
		public NoteDao noteDao;

		//Associates a Message with the receiver
		@Override
		public void linkMessageWithUser(NoteCreate note, String sender, int id) {
			noteDao.linkMessageWithUser(note, sender,id);
			
		}
		//Returns the notes for a user in a project in specific.
		@Override
		public List<Note> getNotesByName (String receiver, int projectId) {
			return noteDao.getNotesByName(receiver, projectId);	
		}
	
}
