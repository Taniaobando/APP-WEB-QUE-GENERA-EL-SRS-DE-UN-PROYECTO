package com.proyectofinal.web.controllers;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyectofinal.web.model.Requirement;
import com.proyectofinal.web.model.Specification;
import com.proyectofinal.web.model.SpecificationCreate;
import com.proyectofinal.web.model.User;
import com.proyectofinal.web.service.MemberService;
import com.proyectofinal.web.service.RequirementService;
import com.proyectofinal.web.service.SpecificationService;

/**
 * Project:Sigere
 * Developers:Laura Arango
 * Contact emails:lauarangom@gmail.com
 * Creation date: 02/06/2019
 * Last modification:  02/06/2019
 */
@Controller
public class EditSpecificationController {
	//Create the required services.
		@Autowired
		RequirementService requirementService;
		@Autowired
		MemberService memberService;
		@Autowired
		SpecificationService specificationService;
		//Load page.
		@RequestMapping(value = "/editarespecificacion", method = RequestMethod.GET)
		  public ModelAndView getCreation(HttpServletRequest request, HttpServletResponse response,
				  @RequestParam(name = "id") int id) {
			//Verify that a user has logged in. If not, it is redirected to the home page
			if (request.getSession().getAttribute("user") == null) {
				return new ModelAndView("redirect:/home");
			}
			final Specification specification = specificationService.getSpecificationById(id);
		    return new ModelAndView("specificationedit").addObject("object", new SpecificationCreate()).addObject("code",specification.getCode()).addObject("name",specification.getName()).addObject("gradeOfNeed",specification.getGradeOfNeed()).addObject("description",specification.getDescription()).addObject("entry",specification.getEntry()).addObject("font",specification.getFont()).addObject("outt",specification.getOutt()).addObject("destiny",specification.getDestiny()).addObject("restriction",specification.getRestriction()).addObject("process",specification.getProcess()).addObject("colateralEffect",specification.getColateralEffect()).addObject("requirementId",specification.getRequirementId()).addObject("version",specification.getVersion());
		  }
		//When something is sent from the view to the controller. 
		@RequestMapping(value = "/editarespecificacion", method = RequestMethod .POST)
		  public ModelAndView postCreation(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") SpecificationCreate specification,
				  @RequestParam(name = "id") int id) {
			//Verify that a user has logged in. If not, it is redirected to the home page
			final User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				return new ModelAndView("redirect:/home");
			}
			String role = (memberService.getMemberByUpId(user.getId(),(requirementService.getRequirementById(specification.getRequirementId())).getProjectId())).getRole();
			//Here the actual version of the specification becomes an old one and the specification is updated, same does its requirement
			if (!role.equals("observador")) {
				final Requirement req = requirementService.getRequirementById(specification.getRequirementId());
				final Specification spe = specificationService.getSpecificationById(id);
				Timestamp ts = new Timestamp((new Date()).getTime());
				specificationService.createSpecificationVersion(spe);
				specificationService.updateSpecificationFromSpec(id,specification,ts);
				requirementService.createRequirementVersion(req);
				requirementService.updateRequirementFromSpec(specification.getRequirementId(),specification.getVersion());
				
			}
			//returns to the view .jsp in ModelAndView("View").
			return new ModelAndView("redirect:/requerimiento?id="+ specification.getRequirementId());
		  }
}
