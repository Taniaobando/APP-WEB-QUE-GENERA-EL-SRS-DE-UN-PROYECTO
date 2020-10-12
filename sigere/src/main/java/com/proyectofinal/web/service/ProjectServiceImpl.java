package com.proyectofinal.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyectofinal.web.dao.ProjectDao;
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
 * Last modification: 24/05/2019
 */
public class ProjectServiceImpl implements ProjectService {
	//Create a Project Dao to access to its functions.
	@Autowired
	public ProjectDao projectDao;
	//Returns a list of the projects of a user.
	@Override
	public List<Project> getProjectsByUserId(int id) {
		return projectDao.getProjectsByUserId(id);
	}
	//Returns a project by its id.
	@Override
	public Project getProjectById(int id) {
		return projectDao.getProjectById(id);
	}
	//Returns a project by its name.
	@Override
	public Project getProjectByName(String name) {
		return projectDao.getProjectByName(name);
	}
	//Create a new project.
	@Override
	public void createProject(ProjectCreate project) {
		projectDao.createProject(project);
	}
	//Add to a project an specific user.
	@Override
	public void linkProjectWithUser(ProjectCreate project, String role,User user) {
		projectDao.linkProjectWithUser(project, role,user);
	}
	//Returns a list of the events of a calendar
	@Override
	public List<Calendar> getEventsByProjectId(int id) {
		return projectDao.getEventsByProjectId(id);
	}
	//Create a new event
	@Override
	public void createEvent(CalendarCreate calendar) {
		projectDao.createEvent(calendar);
		
	}


}
