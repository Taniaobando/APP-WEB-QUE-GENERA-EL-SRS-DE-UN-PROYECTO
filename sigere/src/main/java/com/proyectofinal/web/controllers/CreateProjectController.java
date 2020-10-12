/**
 * Project:Sigere
 * Developer:Laura Arango, Tania Obando
 * Contact email: lauarangom@gmail.com, taniaobando1998@gmail.com
 * Creation date: 30/04/2019
 * Last modification: 05/06/2019
 */
package com.proyectofinal.web.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.proyectofinal.web.model.Project;
import com.proyectofinal.web.model.ProjectCreate;
import com.proyectofinal.web.model.User;
import com.proyectofinal.web.service.ImageService;
import com.proyectofinal.web.service.ProjectService;
import com.proyectofinal.web.service.SRSService;

@Controller
public class CreateProjectController {
	//Create a Project Service to access to it functions.
	@Autowired
	ProjectService projectService;
	@Autowired
	SRSService srsService;
	@Autowired
	ImageService imageService;
	//When loads the page from other view.
	@RequestMapping(value = "/crearproyecto", method = RequestMethod.GET)
	  public ModelAndView getCreation(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession().getAttribute("user") == null) {
			return new ModelAndView("redirect:/home");
		}
		final User user = (User) request.getSession().getAttribute("user");
	    return new ModelAndView("projectcreate").addObject("object", new ProjectCreate()).addObject("firstname",user.getFirstname());
	  }
	//When something is sent from the view to the controller. 
	@RequestMapping(value = "/crearproyecto", method = RequestMethod.POST)
	  public ModelAndView postCreation(HttpServletRequest request, HttpServletResponse response, 
			  @ModelAttribute("object") ProjectCreate project,@RequestParam("nameDiagram") String nameDiagram,
			  @RequestParam("image") MultipartFile image)
			  throws IOException, ServletException {
		//Verify that a user has logged in. If not, it is redirected to the home page 
		final User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/home");
		}
		projectService.createProject(project);
		srsService.createSRS(project);
		final String role = "admin";
		projectService.linkProjectWithUser(project,role, user);
		int proId = projectService.getProjectByName(project.getName()).getId();
		try {
			imageService.inserRecords("Diagrama de contexto",image,proId);
		    return new ModelAndView("redirect:/bienvenido?firstname="+user.getFirstname());

		} catch (Exception e) {
		    return new ModelAndView("redirect:/bienvenido?firstname="+user.getFirstname()+e.getMessage());
		}
	  }
}
