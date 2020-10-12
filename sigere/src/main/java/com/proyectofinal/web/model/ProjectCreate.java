package com.proyectofinal.web.model;

import java.sql.Blob;
/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email: lauarangom@gmail.com
 * Creation date: 30/04/2019
 * Last modification: 15/05/2019
 */

public class ProjectCreate {

	private String name; //The name of the project.
	private String description; //The description of the project.
	private Blob contextDiagram; //The context diagram image of the project.
	
	public ProjectCreate(final String name, final String description, final Blob contextDiagram) {
		this.name = name;
		this.description = description;
		this.contextDiagram = contextDiagram;
	}
	
	public ProjectCreate() {
		
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(final String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setContextDiagrama (final Blob contextDiagram) {
		this.contextDiagram=contextDiagram;
	}
	
	public Blob getContextDiagram () {
		return contextDiagram;
	}
}
