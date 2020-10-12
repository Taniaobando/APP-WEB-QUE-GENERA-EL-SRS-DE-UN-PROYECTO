package com.proyectofinal.web.controllers;

import java.util.List;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyectofinal.web.model.Project;
import com.proyectofinal.web.model.Requirement;
import com.proyectofinal.web.model.SRS;
import com.proyectofinal.web.model.SRSEditDescrGlobal;
import com.proyectofinal.web.model.SRSEditIntro;
import com.proyectofinal.web.model.SRSEditReqs;
import com.proyectofinal.web.model.User;
import com.proyectofinal.web.model.Calendar;
import com.proyectofinal.web.model.CalendarCreate;
import com.proyectofinal.web.service.MemberService;
import com.proyectofinal.web.service.ProjectService;
import com.proyectofinal.web.service.RequirementService;
import com.proyectofinal.web.service.SRSService;
import com.proyectofinal.web.service.ImageService;
import com.proyectofinal.web.model.Image;

/**
 * Project:Sigere
 * Developer:Laura Arango, Tania Obando,Verónica Tofiño
 * Contact email: lauarangom@gmail.com, taniaobando1998@gmail.com, veronicatofino@gmail.com
 * Creation date: 28/04/2019
 * Last modification: 05/06/2019
 */
@Controller
public class ProjectController {
	//Create a Project Service to access to it functions.
	@Autowired
	ProjectService projectService;
	//Create a Requirement Service to access to it functions.
	@Autowired
	RequirementService requirementService;
	//Create a Member Service to access to it functions.
	@Autowired
	MemberService memberService;
	//Create a SRS Service to access to it functions.
	@Autowired
	SRSService srsService;
	//Create a Image Service to access to it functions.
	@Autowired
	ImageService imageService;
	
	//When loads the page from other view.
	  @RequestMapping(value = "/proyecto", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response,
			  @RequestParam(name = "id") final int id) {
		//Verify that a user has logged in. If not, it is redirected to the home page
		  if (request.getSession().getAttribute("user") == null) {
			//returns to the view .jsp in ModelAndView("View").  
			return new ModelAndView("redirect:/home");
		}
		final User user = (User) request.getSession().getAttribute("user");
		final List<Requirement> requirements = requirementService.getRequirementByProjectId(id);		
		final Project project = projectService.getProjectById(id);
		final StringBuilder builder = new StringBuilder();
		final StringBuilder builder2 = new StringBuilder();
		final StringBuilder builderDiagrams = new StringBuilder();
		final List<Image> diagrams = imageService.infoImageList(id);
		for (Requirement r : requirements) {
			builder.append("<tr><td width=\"15%\">"+r.getType()+"</td>").append("<td width=\"15%\">"+r.getStatus()+"</td>").append("<td width=\"10%\">"+r.getReqId()+"</td>").append("<td width=\"20%\">").append("<a href = \"requerimiento?id=" + r.getId() + "\">").append(r.getName()).append("</a></td>").append("<td width=\"20%\">"+r.getVersion()+"</td>").append("<td><a id=\"myBtn1\" class=\"btn btn-default\" href=editarrequerimiento?id="+r.getId()+"><em class=\"fa fa-pencil\"></em></a><a id=\"myBtn2\" class=\"btn btn-danger\" href=eliminarrequerimiento?id="+r.getId()+"><em class=\"fa fa-trash\"></em></a></td></tr>");
		}
		
		final List <Calendar> events =projectService.getEventsByProjectId(id);
		for (Calendar c : events) {
			int montt = Integer.parseInt(c.getMonth())-1;
			builder2.append("{'Date':  new Date("+c.getYear()+", "+montt+"," +c.getDay()+"), 'Title': '"+c.getTitle()+"'},");
		}
		String roleUser = "\""+(memberService.getMemberByUpId(user.getId(),id)).getRole()+"\"";
		
		SRS srs = srsService.getSRSByProjectId(id);
		
		for (Image d : diagrams) {
			int idDiagram = d.getIdIm();
			builderDiagrams.append("<div class=\"gallery\"><a target=\"_blank\" href=\"/sigere/getPhoto?id="+idDiagram+"\"><img src=\"/sigere/getPhoto?id="+idDiagram+"\" width=\"600\" height=\"400\"></a><div class=\"desc\">"+d.getNameIm()+"</div></div>");
			
		}
		
		//Controlador de imagenes
		//returns to the view .jsp in ModelAndView("View").
	    return new ModelAndView("project").addObject("diagrams",builderDiagrams).addObject("events",builder2.toString()).addObject("name", project.getName()).addObject("desc", project.getDescription()).addObject("id",project.getId()).addObject("requirements", builder.toString()).addObject("firstname",user.getFirstname()).addObject("roleUser",roleUser).addObject("systemProspect", srs.getSystemProspect()).addObject("scope", srs.getScope()).addObject("objectives", srs.getObjectives()).addObject("definitions", srs.getDefinitions()).addObject("referencs", srs.getReferencs()).addObject("globalAppraisal", srs.getGlobalAppraisal()).addObject("productPerspective", srs.getProductPerspective()).addObject("interfaces", srs.getInterfaces()).addObject("userCharacteristics", srs.getUserCharacteristics()).addObject("productFunctions", srs.getProductFunctions()).addObject("domainModel", srs.getDomainModel()).addObject("restrictions", srs.getRestrictions()).addObject("suppositions", srs.getSuppositions()).addObject("dbRequirements", srs.getDBRequirements()).addObject("designRestrictions", srs.getDesignRestrictions()).addObject("ruleAcceptance",srs.getRuleAcceptance()).addObject("version",srs.getVersion());
	  }
	//When something is sent from the view to the controller. 
	  @RequestMapping(value = "/agregarevento", method = RequestMethod.POST)
	  public ModelAndView postCreation(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") CalendarCreate calendar,
			  @RequestParam(name = "projectId") int id) {
		final User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/home");
		}
		projectService.createEvent(calendar);
	    return new ModelAndView("redirect:/proyecto?id="+id);
	  }
	//When something is sent from the view to the controller. 
	  @RequestMapping(value = "/editarIntroSRS", method = RequestMethod.POST)
	  public ModelAndView postSRSIntro(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") SRSEditIntro srs,@RequestParam(name = "version") final String version) {
		  final User user = (User) request.getSession().getAttribute("user");
		  if (user == null) {
	    	return new ModelAndView("redirect:/home");
		  }
		  srsService.editSRSIntro(srs,version);
		  return new ModelAndView("redirect:/proyecto?id="+srs.getProjectId());
	  }
	  
	//When something is sent from the view to the controller. 
	  @RequestMapping(value = "/editarDescrSRS", method = RequestMethod.POST)
	  public ModelAndView postSRSDescr(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") SRSEditDescrGlobal srs,@RequestParam(name = "version") final String version) {
		  final User user = (User) request.getSession().getAttribute("user");
		  if (user == null) {
	    	return new ModelAndView("redirect:/home");
		  }
		  srsService.editSRSDescrGlobal(srs,version);
		  return new ModelAndView("redirect:/proyecto?id="+srs.getProjectId());
	  }
	  
	 @RequestMapping(value="/editarReqsSRS", method=RequestMethod.POST)
	 public ModelAndView postSRSReqs(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("object") SRSEditReqs srs,@RequestParam(name = "version") final String version){
		 final User user = (User) request.getSession().getAttribute("user");
		  if (user == null) {
	    	return new ModelAndView("redirect:/home");
		  }
		  srsService.editSRSReqs(srs,version);
		  return new ModelAndView("redirect:/proyecto?id="+srs.getProjectId());
	 }
	 
	 @RequestMapping(value = "/buscarrequerimiento", method = RequestMethod.POST)
	  public ModelAndView getCreation(HttpServletRequest request, HttpServletResponse response,
			  @RequestParam(name = "search") final String search, @RequestParam(name = "projectId") final int id) {
		//Verify that a user has logged in. If not, it is redirected to the home page
		  if (request.getSession().getAttribute("user") == null) {
				//returns to the view .jsp in ModelAndView("View").  
				return new ModelAndView("redirect:/home");
			}
		  	//Declares the variables that are going to be used
			final User user = (User) request.getSession().getAttribute("user");
			final List<Requirement> requirements = requirementService.getRequirementByProjectId(id);
			HashMap<Integer, Requirement > htSelectedReqs = new HashMap<Integer, Requirement >();
			Pattern requiredPattern = Pattern.compile(".*"+search+".*");
			final Project project = projectService.getProjectById(id);
			final StringBuilder builder = new StringBuilder();
			final StringBuilder builder2 = new StringBuilder();
			String message = "'null'";
			//Find the matches between the requirements names and the pattern searched
			for (Requirement r : requirements) {
				Matcher reqMatcher = requiredPattern.matcher(r.getName());
				boolean match = reqMatcher.matches();
				if (match) {
					if (!htSelectedReqs.containsKey(r.getId())) {
						htSelectedReqs.put(r.getId(),r);
					}
				}
				builder.append("<tr><td width=\"15%\">"+r.getType()+"</td>").append("<td width=\"15%\">"+r.getStatus()+"</td>").append("<td width=\"10%\">"+r.getReqId()+"</td>").append("<td width=\"20%\">").append("<a href = \"requerimiento?id=" + r.getId() + "\">").append(r.getName()).append("</a></td>").append("<td width=\"20%\">"+r.getVersion()+"</td>").append("<td><a class=\"btn btn-default\" href=editarrequerimiento?id="+r.getId()+"><em class=\"fa fa-pencil\"></em></a><a class=\"btn btn-danger\" href=eliminarrequerimiento?id="+r.getId()+"><em class=\"fa fa-trash\"></em></a></td></tr>");
			}
			final List <Calendar> events =projectService.getEventsByProjectId(id);
			for (Calendar c : events) {
				int montt = Integer.parseInt(c.getMonth())-1;
				builder2.append("{'Date':  new Date("+c.getYear()+", "+montt+"," +c.getDay()+"), 'Title': '"+c.getTitle()+"'}");
			}
			final StringBuilder builderResult = new StringBuilder();
			htSelectedReqs.forEach((k, v) -> { 
				  //The builder contains the links to the matched requirements	
				builder.append("<li><a href = \"requerimiento?id=" + v.getId() + "\">").append(v.getName()).append("</a></li>");
			});
			//Validates there are actual results
			if (!htSelectedReqs.isEmpty()) {
				message = "'Hay resultados'";
			} 
			System.out.println(message);
		    return new ModelAndView("project").addObject("message",message.toString()).addObject("results",builderResult.toString()).addObject("events",builder2.toString()).addObject("name", project.getName()).addObject("desc", project.getDescription()).addObject("id",project.getId()).addObject("requirements", builder.toString()).addObject("firstname",user.getFirstname());
	  }
			
	  
}
