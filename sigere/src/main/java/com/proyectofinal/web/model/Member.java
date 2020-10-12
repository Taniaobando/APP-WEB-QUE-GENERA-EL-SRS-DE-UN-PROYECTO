package com.proyectofinal.web.model;
/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email: lauarangom@gmail.com
 * Creation date: 09/05/2019
 * Last modification: 15/05/2019
 */
public class Member {
	private final int id; //The id of the member. It is unique an given by the DB.
	private final int userId; //The id of the user from the User table.
	private final String role; //The role of the user in the project.
	private final int projectId; //The project where you add the user.
	
	
	public Member(final int id,final int userId, final String role, final int projectId) {
		this.id = id;
		this.userId = userId;
		this.role = role; 
		this.projectId = projectId;
	}
	
	public int getId() {
		return id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getRole() {
		return role;
	}
	
	public int getProjectId() {
		return projectId;
	}
}
