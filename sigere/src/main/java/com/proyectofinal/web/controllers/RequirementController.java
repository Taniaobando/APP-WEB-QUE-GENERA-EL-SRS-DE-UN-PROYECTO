package com.proyectofinal.web.controllers;
/**
 * Project:Sigere
 * Developer:Laura Arango, Verónica Tofiño
 * Contact email: lauarangom@gmail.com, veronicatofino@gmail.com
 * Creation date: 25/04/2019
 * Last modification: 31/05/2019
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyectofinal.web.model.Requirement;
import com.proyectofinal.web.model.Specification;
import com.proyectofinal.web.model.VersionRequirement;
import com.proyectofinal.web.model.VersionSpecification;
import com.proyectofinal.web.model.User;
import com.proyectofinal.web.service.MemberService;
import com.proyectofinal.web.service.RequirementService;
import com.proyectofinal.web.service.SpecificationService;
@Controller
public class RequirementController {
	//Create a Requirement Service to access to it functions.
	@Autowired
	RequirementService requirementService;	
	//Create a Specification Service to access to it functions.
	@Autowired
	SpecificationService specificationService;
	//Create a Member Service to access to it functions.
	@Autowired
	MemberService memberService;
	//When loads the page from other view.
	  @RequestMapping(value = "/requerimiento", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response,
			  @RequestParam(name = "id") final int id) {
		//Verify that a user has logged in. If not, it is redirected to the home page
		  if (request.getSession().getAttribute("user") == null) {
			//returns to the view .jsp in ModelAndView("View").
			return new ModelAndView("redirect:/home");
		}
		final User user = (User) request.getSession().getAttribute("user");
		final Requirement requirement = requirementService.getRequirementById(id);
		final List<Specification> specifications = specificationService.getSpecificationByRequirementId(id);	
		final StringBuilder builder2 = new StringBuilder();
		String varNull = "\"Null\"";
		int specificationId= 0;
		if (specifications.isEmpty()) {
			
		}else {
			Specification specification= specifications.get(0);
			specificationId=specification.getId();
			List<VersionSpecification> versionSpecifications = specificationService.getSpecificationVersions(specification.getRequirementId());
			builder2.append("<div class=\"mySlides2\"><table style=\"display:inline-block;border: 0px ;width:45%;margin-left:110px\"><tr><th>Código</th><th colspan=\"2\">Nombre </th><th width=\"10%\">Fecha </th><th>Grado de necesidad</th></tr><tr><td>"+specification.getCode()+"</td><td colspan=\"2\">"+specification.getName()+"</td><td>"+specification.getDate()+"</td><td>"+specification.getGradeOfNeed()+"</td></tr><tr><th>Descripción</th><td colspan=\"4\">"+specification.getDescription()+"</tr><tr><th>Entradas</th><th>Fuente</th><th>Salida</th><th>Destino</th><th>Restricciones</th></tr><tr><td>"+specification.getEntry()+"</td><td>"+specification.getFont()+"</td><td>"+specification.getOutt()+"</td><td>"+specification.getDestiny()+"</td><td>"+specification.getRestriction()+"</td></tr><tr><th>Proceso</th><td colspan=\"4\">"+specification.getProcess()+"</td></tr><tr><th>Efecto Colateral </th><td colspan=\"4\">"+specification.getColateralEffect()+"</td></tr></table></div>");
			
			for (VersionSpecification s : versionSpecifications) {
				builder2.append("<div class=\"mySlides2 \"><table style=\"display:inline-block;border: 0px ;width:45%;margin-left:110px\"><tr><th>Código</th><th colspan=\"2\">Nombre </th><th width=\"10%\">Fecha </th><th>Grado de necesidad</th></tr><tr><td>"+s.getCode()+"</td><td colspan=\"2\">"+s.getName()+"</td><td>"+s.getDate()+"</td><td>"+s.getGradeOfNeed()+"</td></tr><tr><th>Descripción</th><td colspan=\"4\">"+s.getDescription()+"</tr><tr><th>Entradas</th><th>Fuente</th><th>Salida</th><th>Destino</th><th>Restricciones</th></tr><tr><td>"+s.getEntry()+"</td><td>"+s.getFont()+"</td><td>"+s.getOutt()+"</td><td>"+s.getDestiny()+"</td><td>"+s.getRestriction()+"</td></tr><tr><th>Proceso</th><td colspan=\"4\">"+s.getProcess()+"</td></tr><tr><th>Efecto Colateral </th><td colspan=\"4\">"+s.getColateralEffect()+"</td></tr></table></div>");			
			}
			if (builder2.length() == 0 ) {
				varNull = "\"Null\"";
			}else {
				varNull="\"notNull\"";
			}
		}
		List<VersionRequirement> versionRequirements = requirementService.getVersionsByReqId(requirement.getReqId(),requirement.getProjectId());
		final StringBuilder builder = new StringBuilder();
		builder.append("<div class=\"mySlides\"><table style=\"display: inline-block;border: 0px ;width:35%;float:left\"><tr><th width=\"5%\">Id</th><th width=\"10%\">Tipo</th><th width=\"20%\">Nombre</th><th width=\"10%\">Versión</th></tr><tr><td>"+requirement.getReqId()+"</td><td>"+requirement.getType()+"</td><td>"+requirement.getName()+"</td><td>"+requirement.getVersion()+"</tr><tr><th>Descripción</th><td colspan=\"3\">"+requirement.getDescription()+"</td></tr><tr><th>Estado</th><td colspan=\"3\">"+requirement.getStatus()+"</td></tr></table></div>");
		for (VersionRequirement r : versionRequirements) {
			builder.append("<div class=\"mySlides\"><table style=\"display: inline-block;border: 0px ;width:35%;float:left\"><tr><th width=\"5%\">Id</th><th width=\"10%\">Tipo</th><th width=\"20%\">Nombre</th><th width=\"10%\">Versión</th></tr><tr><td>"+r.getReqId()+"</td><td>"+r.getType()+"</td><td>"+r.getName()+"</td><td>"+r.getVersion()+"</tr><tr><th>Descripción</th><td colspan=\"3\">"+r.getDescription()+"</td></tr><tr><th>Estado</th><td colspan=\"3\">"+r.getStatus()+"</td></tr></table></div>");
		}
		String roleUser = "\""+(memberService.getMemberByUpId(user.getId(),(requirementService.getRequirementById(requirement.getId())).getProjectId())).getRole()+"\"";
		//returns to the view .jsp in ModelAndView("View").
	    return new ModelAndView("requirement").addObject("specificationId",specificationId).addObject("varNull",varNull).addObject("requirements", builder.toString()).addObject("specifications",builder2.toString()).addObject("id",requirement.getId()).addObject("firstname",user.getFirstname()).addObject("idFromUser",requirement.getReqId()).addObject("roleUser",roleUser).addObject("type","\""+requirement.getType()+"\"");
	  }
}
