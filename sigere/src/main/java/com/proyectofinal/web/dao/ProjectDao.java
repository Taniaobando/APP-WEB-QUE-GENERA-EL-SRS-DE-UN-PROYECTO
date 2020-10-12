package com.proyectofinal.web.dao;

import java.util.List;

import com.proyectofinal.web.model.Calendar;
import com.proyectofinal.web.model.CalendarCreate;
import com.proyectofinal.web.model.Project;
import com.proyectofinal.web.model.ProjectCreate;

import com.proyectofinal.web.model.User;
/**
 * Project:Sigere
 * Developer:Laura Arango, Verónica Tofiño
 * Contact email: lauarangom@gmail.com, veronicatofino@gmail.com
 * Creation date: 28/04/2019
 * Last modification: 24/05/2019
 */
public interface ProjectDao {
	//Returns all the Projects of a User
	List<Project> getProjectsByUserId(final int id);
	//Returns a Project from its id
	Project getProjectById(final int id);
	//Returns a Project from its name
	Project getProjectByName(String name);
	//Create a new project
	void createProject(ProjectCreate project);
	//Add a project to a User
	void linkProjectWithUser(final ProjectCreate project, final String role,final User user);
	//Returns all the events of a calendar from a project given.
	List<Calendar> getEventsByProjectId(int id);
	//Create a new event in calendar 
	void createEvent(CalendarCreate calendar);

}
