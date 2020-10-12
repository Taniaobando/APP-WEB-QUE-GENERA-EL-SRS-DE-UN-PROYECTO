package com.proyectofinal.web.model;

import java.sql.Blob;
/**
 * Project:Sigere
 * Developer:Verónica Tofiño
 * Contact email: veronicatofino@gmail.com
 * Creation date: 28/04/2019
 * Last modification: 15/05/2019
 */
public class Project {
	
	private final int id; //The id of the project is unique and given by the DB.
	private final String name; //The name of the project.
	private final String description; //The description of the project. 
	private final Blob contextDiagram; //The context diagram image of the project.
	
	public Project(final int id, final String name, final String description, final Blob contextDiagram) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.contextDiagram = contextDiagram;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Blob getContextDiagram() {
		return contextDiagram;
	}
}
