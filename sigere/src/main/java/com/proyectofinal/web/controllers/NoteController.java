package com.proyectofinal.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyectofinal.web.model.Note;
import com.proyectofinal.web.model.User;
import com.proyectofinal.web.service.NoteService;
/**
 * Project:Sigere
 * Developer:Tania Obando
 * Contact email: taniaobando1998@gmail.com
 * Creation date: 15/05/2019
 * Last modification: 18/05/2019
 */

@Controller
public class NoteController {
	//Creates a Note Service to access to its functions.
	@Autowired
	NoteService noteService;
	//When loads the page from other view.
	@RequestMapping(value = "/notas", method = RequestMethod.GET)
	  public ModelAndView getCreation(HttpServletRequest request, HttpServletResponse response, 
			  @RequestParam(name = "id") final int id) {
		//Verify that a user has logged in. If not, it is redirected to the home page
		if (request.getSession().getAttribute("user") == null) {
			//returns to the view .jsp in ModelAndView("View").
			return new ModelAndView("redirect:/home");
		}
		final User user = (User) request.getSession().getAttribute("user");
		final List<Note> notes = noteService.getNotesByName(user.getUsername(),id);		
		final StringBuilder builder = new StringBuilder();
		for (Note n : notes) {
			builder.append("<li><h2>De: "+n.getSender() +"</h2><p>"+ n.getNte()+"</p></li>");
		}
		
		//returns to the view .jsp in ModelAndView("View").
		return new ModelAndView("notes").addObject("notes", builder.toString()).addObject("firstname",user.getFirstname()).addObject("id",id);
		}
}		
	
	
	
	  


