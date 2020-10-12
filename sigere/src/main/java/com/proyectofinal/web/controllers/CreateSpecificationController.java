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
import com.proyectofinal.web.model.SpecificationCreate;
import com.proyectofinal.web.model.Requirement;
import com.proyectofinal.web.model.User;
import com.proyectofinal.web.service.SpecificationService;
import com.proyectofinal.web.service.RequirementService;
/**
 * Project:Sigere
 * Developers:Laura Arango, Verónica Tofiño
 * Contact emails: lauarangom@gmail.com , veronicatofino@gmail.com
 * Creation date: 14/05/2019
 * Last modification: 15/05/2019
 */
@Controller
public class CreateSpecificationController {
	//Create a Specification Service to access to it functions.
	@Autowired
	SpecificationService specificationService;
	//Create a Requirement Service to access to it functions.
	@Autowired
	RequirementService requirementService;
	//When loads the page from other view.
	@RequestMapping(value = "/crearespecificacion", method = RequestMethod.GET)
	  public ModelAndView getCreation(HttpServletRequest request, HttpServletResponse response,@RequestParam(name = "id") final int id) {
		//Verify that a user has logged in. If not, it is redirected to the home page
		if (request.getSession().getAttribute("user") == null) {
			//returns to the view .jsp in ModelAndView("View").
			return new ModelAndView("redirect:/home");
		}
		Requirement requirement= requirementService.getRequirementById(id);
		//returns to the view .jsp in ModelAndView("View").
	    return new ModelAndView("specificationcreate").addObject("object", new SpecificationCreate()).addObject("idReq",requirement.getReqId()).addObject("versionReq",requirement.getVersion()).addObject("type",requirement.getType()).addObject("id",requirement.getId()).addObject("version",requirement.getVersion());
	  }
	@RequestMapping(value = "/crearespecificacion", method = RequestMethod.POST)
	  public ModelAndView postCreation(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") SpecificationCreate specification,
			  @RequestParam(name = "id") int id) {
		final User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/home");
		}
		specificationService.createSpecification(specification);
		return new ModelAndView("redirect:/requerimiento?id="+id);
	  }
	

}
