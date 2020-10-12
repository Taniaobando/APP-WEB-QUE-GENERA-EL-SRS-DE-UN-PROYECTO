package com.proyectofinal.web.controllers;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.proyectofinal.web.model.User;

/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email: lauarangom@gamail.com
 * Creation date: 04/06/2019
 * Last modification: 04/06/2019
 */
@Controller
public class ProfileController {

	  @RequestMapping(value = "/perfil", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		//Verify that a user has logged in. If not, it is redirected to the home page
		  if (request.getSession().getAttribute("user") == null) {
			//returns to the view .jsp in ModelAndView("View").  
			return new ModelAndView("redirect:/home");
		}
		 //Extract all the information from the user
		final User user = (User) request.getSession().getAttribute("user");
		final String firstname = user.getFirstname();
		final String lastname = user.getLastname();
		final String email = user.getEmail();
		final String username = user.getUsername();
		final String password = user.getPassword();
		//returns to the view .jsp in ModelAndView("View").
	    return new ModelAndView("profile").addObject("firstname",firstname).addObject("lastname",lastname).addObject("email",email).addObject("username",username).addObject("password",password);
	  }
	  
	  @RequestMapping(value="/actualizarperfil", method= RequestMethod.POST)
	  public ModelAndView getProfile (HttpServletRequest request, HttpServletResponse response) {
		  if (request.getSession().getAttribute("user") == null) {
				//returns to the view .jsp in ModelAndView("View").  
				return new ModelAndView("redirect:/home");
			}
			 //Extract all the information from the user
		  final User user = (User) request.getSession().getAttribute("user");
		  return new ModelAndView("redirect:/bienvenido?firstname="+user.getFirstname());
	  }
}	