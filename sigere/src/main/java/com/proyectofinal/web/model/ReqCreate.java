package com.proyectofinal.web.model;
/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email: lauarangom@gmail.com
 * Creation date: 30/04/2019
 * Last modification: 15/05/2019
 */
public class ReqCreate {
	
	private String reqId; //The requirement Id. It is unique in each project and is given by the user.
	private String type; //The type of the requirement. Can be: Functional requirement or Non functional requirement.
	private String name; //The name of the requirement.
	private String version; //The actual version of the requirement.
	private String description; //The description of the requirement.
	private String status; //The actual state of the requirement.
	private int projectId; //The Project id where the Requirement is created.
	
	public ReqCreate(final String reqId,final String type, final String name, final String version, final String description,final String status, final int projectId) {
		this.reqId=reqId;
		this.type = type;
		this.name = name;
		this.version=version;
		this.description = description;
		this.status = status;
		this.projectId=projectId;
	}
	
	
	public ReqCreate() {
		
	}
	
	public void setReqId(final String reqId) {
		this.reqId=reqId;
	}
	
	public String getReqId() {
		return reqId;
	}
	
	public void setType(final String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setVersion(final String version) {
		this.version=version;
	}
	
	public String getVersion() {
		return version;
	}
	public void setDescription(final String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setStatus(final String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	
	
	public void setProjectId( final int projectId) {
		this.projectId=projectId;
	}
	
	public int getProjectId() {
		return projectId;
	}
}
