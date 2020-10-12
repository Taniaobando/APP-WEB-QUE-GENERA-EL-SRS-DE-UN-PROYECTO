package com.proyectofinal.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
 * Last modification: 15/05/2019
 */
public class ProjectDaoImpl implements ProjectDao {
	/**
	 * DataSource an JbdcTemplate are classes and interfaces from sql to generate querys.
	 */
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	//Implementation of the getProjectsByUserId function definite in ProjectDao.java
	@Override
	public List<Project> getProjectsByUserId(int id) {
		String sql = "SELECT * FROM projects INNER JOIN projectsxuser ON(projectsxuser.projectId = projects.id) WHERE userId = '" + id + "'";
		return jdbcTemplate.query(sql, new ProjectMapper());
		
	}
    //Implementation of the getProjectById function definite in ProjectDao.java
	@Override
	public Project getProjectById(int id) {
		String sql = "SELECT * FROM projects WHERE id = '" + id + "'";
		return jdbcTemplate.query(sql, new ProjectMapper()).get(0);
	}
	//Implementation of the getProjectByName function definite in ProjectDao.java
	@Override
	public Project getProjectByName(String name) {
		String sql = "SELECT * FROM projects WHERE name = '" + name + "'";
		return jdbcTemplate.query(sql, new ProjectMapper()).get(0);
	}
    //Implementation of the createProject function definite in ProjectDao.java
	@Override
	public void createProject(ProjectCreate project) {
		String sql = "insert into projects(name, description,contextDiagram) values(?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { project.getName(), project.getDescription(), project.getContextDiagram()});
		
	}
    //Implementation of the linkProjectWithUser function definite in ProjectDao.java
	@Override
	public void linkProjectWithUser(ProjectCreate createdProject, String role,User user) {
		String sql = "SELECT * FROM projects WHERE name = '" + createdProject.getName() + "'";
		final Project project = jdbcTemplate.query(sql, new ProjectMapper()).get(0);
		sql = "INSERT INTO projectsxuser(userId, role,projectId) VALUES (?,?, ?)";
	    jdbcTemplate.update(sql, new Object[] { user.getId(), role,project.getId()});
	}
	//Implementation of the getEventsByProjectId function definite in ProjectDao.java
	@Override
	public List<Calendar> getEventsByProjectId(int id) {
		String sql = "SELECT * FROM calendar WHERE projectId= '"+id+"'";
		return jdbcTemplate.query(sql, new CalendarMapper());
	}
	//Implementation of the createEvent function definite in ProjectDao.java
	@Override
	public void createEvent(CalendarCreate calendar) {
		String sql = "insert into calendar(year,month,day,title, description,projectId) values(?,?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { calendar.getYear(), calendar.getMonth(), calendar.getDay(),calendar.getTitle(), calendar.getDescription(), calendar.getProjectId()});
		
	}

}

class ProjectMapper implements RowMapper<Project> {

	@Override
	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Project(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getBlob("contextDiagram"));
	}
	
}

class CalendarMapper implements RowMapper<Calendar> {

	@Override
	public Calendar mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Calendar(rs.getInt("id"), rs.getString("year"), rs.getString("month"), rs.getString("day"), rs.getString("title"),rs.getString("description"), rs.getInt("projectId"));
	}
	
}
