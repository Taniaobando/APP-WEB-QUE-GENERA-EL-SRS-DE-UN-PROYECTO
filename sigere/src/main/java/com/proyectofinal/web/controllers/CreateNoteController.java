package com.proyectofinal.web.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyectofinal.web.model.User;

import com.proyectofinal.web.model.NoteCreate;
import com.proyectofinal.web.service.NoteService;
/**
 * Project:Sigere
 * Developer:Tania Obando
 * Contact email: taniaobando1998@gmail.com
 * Creation date: 15/05/2019
 * Last modification: 18/05/2019
 */

@Controller
public class CreateNoteController{
	
	@Autowired
	NoteService noteService;
	
	@RequestMapping(value = "/enviarnota", method = RequestMethod.GET)
	  public ModelAndView getCreation(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession().getAttribute("user") == null) {
			return new ModelAndView("redirect:/home");
		}
	    return new ModelAndView("notecreate").addObject("object", new NoteCreate());
	  }
	
	@RequestMapping(value = "/enviarnota", method = RequestMethod.POST)
	  public ModelAndView postCreation(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") NoteCreate note,
			  @RequestParam(name = "id") int id) {
		final User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/home");
		}
		final String sender=user.getUsername();
		noteService.linkMessageWithUser(note,sender,id);
	    return new ModelAndView("redirect:/notas?id="+id);
	  }
}