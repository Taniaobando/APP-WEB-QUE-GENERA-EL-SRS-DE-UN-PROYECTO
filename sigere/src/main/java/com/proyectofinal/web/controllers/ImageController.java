package com.proyectofinal.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.proyectofinal.web.service.ImageService;
/**
 * Project:Sigere
 * Developers:Tania Obando
 * Contact emails: taniaobando1998@gmail.com
 * Creation date: 02/06/2019
 * Last modification: 02/06/2019
 */


@Controller

public class ImageController {
	//Create a Image Service to access to it functions.
	@Autowired
	ImageService imageService;
	//When loads from other view.
	@RequestMapping(value = "/guardarimagen", method = RequestMethod.GET)
	  public ModelAndView getCreation(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("???");

		if (request.getSession().getAttribute("user") == null) {
			return new ModelAndView("redirect:/home");
		}
	    return new ModelAndView("projectcreate");
	  }	
	//When a form is sent from the view.
	@RequestMapping(value = "/guardarimagen", method = RequestMethod.POST)
		public ModelAndView save(HttpServletRequest request, HttpServletResponse response, @RequestParam("name") String name,
				@RequestParam("image") MultipartFile image) {
			
				
			try {
				imageService.inserRecords(name,image,66);
				return new ModelAndView("projectcreate", "msg", "Records succesfully inserted into database.");

			} catch (Exception e) {
				return new ModelAndView("projectcreate", "msg", "Error: " + e.getMessage());
			}
		}
}
