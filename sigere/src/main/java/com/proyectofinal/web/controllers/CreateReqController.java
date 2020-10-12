package com.proyectofinal.web.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.proyectofinal.web.model.ReqCreate;
import com.proyectofinal.web.model.User;
import com.proyectofinal.web.service.ImageService;
import com.proyectofinal.web.service.RequirementService;
/**
 * Project:Sigere
 * Developer:Laura Arango, Tania Obando
 * Contact email: lauarangom@gmail.com, taniaobando1998@gmail.com
 * Creation date: 30/04/2019
 * Last modification: 05/06/2019
 */
@Controller
public class CreateReqController{
	//Create a Requirement Service to access to its functions.
	@Autowired
	RequirementService RequirementService;
	@Autowired
	ImageService imageService;
	//When loads the page from other view.
	@RequestMapping(value = "/crearrequerimiento", method = RequestMethod.GET)
	  public ModelAndView getCreation(HttpServletRequest request, HttpServletResponse response,
			  @RequestParam(name = "id") int id) {
		//Verify that a user has logged in. If not, it is redirected to the home page
		if (request.getSession().getAttribute("user") == null) {
			return new ModelAndView("redirect:/home");
		}
	    return new ModelAndView("reqcreate").addObject("object", new ReqCreate());
	  }
	//When something is sent from the view to the controller. 
	@RequestMapping(value = "/crearrequerimiento", method = RequestMethod.POST)
	  public ModelAndView postCreation(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") ReqCreate requirement,
			  @RequestParam(name = "id") int id,@RequestParam("nameDiagram") String nameDiagram,
			  @RequestParam("image") MultipartFile image) {
		//Verify that a user has logged in. If not, it is redirected to the home page
		final User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/home");
		}
		String reqId = requirement.getReqId();
		int checkId = RequirementService.checkReqId(reqId,id);
		if (checkId == 1) {
			RequirementService.createRequirement(requirement);
			try {
				imageService.inserRecords("Diagrama de secuencia",image,id);
			    return new ModelAndView("redirect:/proyecto?id="+id);

			} catch (Exception e) {
				return new ModelAndView("redirect:/proyecto?id="+id+e.getMessage());
			}
		}
		else {
			//Poner lo de flashAttribute para retornar un mensaje de error si no esta disponible el id.

		}
		//returns to the view .jsp in ModelAndView("View").
		return new ModelAndView("redirect:/proyecto?id="+id);
	  }
	
}
