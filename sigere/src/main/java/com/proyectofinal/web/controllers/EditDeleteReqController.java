package com.proyectofinal.web.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java. util. Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyectofinal.web.model.ReqCreate;
import com.proyectofinal.web.model.VersionRequirement;
import com.proyectofinal.web.model.VersionSpecification;
import com.proyectofinal.web.model.User;
import com.proyectofinal.web.service.MemberService;
import com.proyectofinal.web.service.SpecificationService;
import com.proyectofinal.web.service.RequirementService;
import com.proyectofinal.web.model.Requirement;
import com.proyectofinal.web.model.Specification;
import java.sql.Timestamp;
/**
 * Project:Sigere
 * Developers:Laura Arango, Verónica Tofiño
 * Contact emails:lauarangom@gmail.com, veronicatofino@gmail.com
 * Creation date: 19/05/2019
 * Last modification: 02/06/2019
 */
@Controller
public class EditDeleteReqController{
	//Create a Requirement Service to access to its functions.
	@Autowired
	RequirementService requirementService;
	@Autowired
	MemberService memberService;
	@Autowired
	SpecificationService specificationService;
	//When loads the page from other view.
	@RequestMapping(value = "/editarrequerimiento", method = RequestMethod.GET)
	  public ModelAndView getCreation(HttpServletRequest request, HttpServletResponse response,
			  @RequestParam(name = "id") int id) {
		//Verify that a user has logged in. If not, it is redirected to the home page
		if (request.getSession().getAttribute("user") == null) {
			return new ModelAndView("redirect:/home");
		}
		final Requirement requirement = requirementService.getRequirementById(id);
	    return new ModelAndView("reqedit").addObject("object", new ReqCreate()).addObject("reqId",requirement.getReqId()).addObject("descrp",requirement.getDescription()).addObject("name",requirement.getName()).addObject("status",requirement.getStatus()).addObject("type",requirement.getType()).addObject("version",requirement.getVersion()).addObject("projectId",requirement.getProjectId());
	  }
	//When something is sent from the view to the controller. 
	@RequestMapping(value = "/editarrequerimiento", method = RequestMethod.POST)
	  public ModelAndView postCreation(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") ReqCreate requirement,
			  @RequestParam(name = "id") int id) {
		//Verify that a user has logged in. If not, it is redirected to the home page
		final User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/home");
		}
		String role = (memberService.getMemberByUpId(user.getId(),requirement.getProjectId())).getRole();
		//Here the actual version of the requirement becomes an old one and the requirement is updated, same does its specification
		if (!role.equals("observador")) {
			final Requirement req = requirementService.getRequirementById(id);
			final Specification spe = specificationService.getSpecificationByRequirementId(req.getId()).get(0);
			Timestamp ts = new Timestamp((new Date()).getTime());
			if (spe != null) {
				specificationService.createSpecificationVersion(spe);
				specificationService.updateSpecificationFromReq(spe,ts,requirement.getVersion());
			}
			requirementService.createRequirementVersion(req);
			requirementService.updateRequirementFromReq(id,requirement);
			
		}
		//returns to the view .jsp in ModelAndView("View").
		return new ModelAndView("redirect:/proyecto?id="+requirement.getProjectId());
	  }
	
	@RequestMapping(value="/eliminarrequerimiento",method=RequestMethod.GET)
	public ModelAndView getElimination(HttpServletRequest request, HttpServletResponse response,
			  @RequestParam(name = "id") int id) {
		//Verify that a user has logged in. If not, it is redirected to the home page
		if (request.getSession().getAttribute("user") == null) {
			return new ModelAndView("redirect:/home");
		}
		final Requirement requirement = requirementService.getRequirementById(id);
		return new ModelAndView("reqdelete").addObject("reqId",requirement.getReqId()).addObject("projectId",requirement.getProjectId()).addObject("name",requirement.getName());
	  }
	
	@RequestMapping(value="/eliminarrequerimiento",method=RequestMethod.POST)
	public ModelAndView postElimination(HttpServletRequest request, HttpServletResponse response,
			  @RequestParam(name = "id") int id, @RequestParam(name="projectId")int projectId)  {
		//Verify that a user has logged in. If not, it is redirected to the home page
		if (request.getSession().getAttribute("user") == null) {
			return new ModelAndView("redirect:/home");
		}
		//Requirement to delete
		System.out.println("projectId: "+id);
		Requirement requirement = requirementService.getRequirementById(id);
		System.out.println("foo");
		final List<Specification> specification = specificationService.getSpecificationByRequirementId(requirement.getId());
		System.out.println("faa");

		final User user = (User) request.getSession().getAttribute("user");
		System.out.println("f");
		String role = (memberService.getMemberByUpId(user.getId(),requirement.getProjectId())).getRole();
		if (role.equals("admin")) {
			VersionRequirement lastVersionReq = requirementService.getLastVersionReq(requirement.getReqId(),requirement.getProjectId());
			VersionSpecification lastVersionSpe = specificationService.getLastVersionSpe(requirement.getId());
			//Checks if the requirement has an older version of itself
			if (lastVersionReq != null) {
				System.out.println("ee");
				//Switch the actual versions of the requirement and its specification for the last one stored
				requirementService.enableVersionReq(lastVersionReq);
				requirementService.deleteVersionRequirement(lastVersionReq.getRId());
				if ( lastVersionSpe != null) {
					specificationService.enableVersionSpec(lastVersionSpe);
					specificationService.deleteVersionSpecification(lastVersionSpe.getSId());
				} 
				System.out.println("g");
			}
			else {
				System.out.println("gg");
				//If  the requirement has no older versions, deletes it
				if (!specification.isEmpty()) {
					System.out.println("ggggg");
					specificationService.deleteSpecification((specification.get(0)).getId());
					System.out.println("h");
				}
				requirementService.deleteRequirement(id);
				System.out.println("i");
			}
		}
		System.out.println("j");
		return new ModelAndView("redirect:/proyecto?id="+projectId);
	  }
}
