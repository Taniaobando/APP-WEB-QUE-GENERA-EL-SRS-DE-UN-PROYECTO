package com.proyectofinal.web.service;

import java.util.List;

import com.proyectofinal.web.model.Calendar;
import com.proyectofinal.web.model.CalendarCreate;
import com.proyectofinal.web.model.Project;
import com.proyectofinal.web.model.ProjectCreate;

import com.proyectofinal.web.model.User;
/**
 * Project:Sigere
 * Developer:Verónica Tofiño
 * Contact email: veronicatofino@gmail.com
 * Creation date: 28/04/2019
 * Last modification: 02/06/2019
 */
public interface ProjectService {
	//Returns the projects of a user
	List<Project> getProjectsByUserId(final int id);
	//Returns the project by its id
	Project getProjectById(final int id);
	//Create a new project
	//Returns the project by its name
	Project getProjectByName(final String name);
	void createProject(ProjectCreate project); 
	//Associates a user to a project
	void linkProjectWithUser(final ProjectCreate project, final String role,final User user);
	//Returns the events of a project
	List<Calendar> getEventsByProjectId(int id);
	//Create a new event
	void createEvent(CalendarCreate calendar);

}
