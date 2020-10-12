package com.proyectofinal.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyectofinal.web.service.MailService;
/**
 * Project:Sigere
 * Developer:Tania Obando
 * Contact email: taniaobando1998@gmail.com
 * Creation date: 25/05/2019
 * Last modification: 29/05/2019
 */
@Controller

public class MailController {
	//Create a Mail Service to access to it functions.
	@Autowired	
	MailService mailService;
	//When something is sent from the view to the controller. 
	  @RequestMapping(value = "/enviarcontrasena", method = RequestMethod.POST)
	  public ModelAndView sendEmail(HttpServletRequest request, HttpServletResponse response,
		  @RequestParam(name = "email") String email) {
		  String password = mailService.getPasswordByEmail(email);
		  mailService.sendEmail(email,password);
		  //returns to the view .jsp in ModelAndView("View").
		  return new ModelAndView("redirect:/home");
	  }
}

