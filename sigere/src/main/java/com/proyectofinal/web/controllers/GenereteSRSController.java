package com.proyectofinal.web.controllers;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;
import com.proyectofinal.web.model.User;
import com.proyectofinal.web.service.SRSService;

/**
 * Project:Sigere
 * Developers:Verónica Tofiño
 * Contact emails:veronicatofino@gmail.com
 * Creation date: 02/06/2019
 * Last modification: 02/06/2019
 */
@Controller
public class GenereteSRSController{
	//Create a Project Service to access to it functions.
	@Autowired
	SRSService srsService;
	//When loads the page from other view.
	@RequestMapping(value = "/generarSRS", method = RequestMethod.POST)
	  public ModelAndView getSRS(HttpServletRequest request, HttpServletResponse response,
			  @RequestParam(name = "id") int projectId) throws DocumentException, IOException {
		//Verify that a user has logged in. If not, it is redirected to the home page
		final User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/home");
		}
		srsService.generateSRS(projectId);
		return new ModelAndView("redirect:/proyecto?id="+projectId);
	}
	
}