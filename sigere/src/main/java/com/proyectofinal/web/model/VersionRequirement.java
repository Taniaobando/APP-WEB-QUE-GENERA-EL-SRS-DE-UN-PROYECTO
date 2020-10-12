package com.proyectofinal.web.model;
/**
 * Project:Sigere
 * Developer: Laura Arango
 * Contact email: lauarangom@gmail.com
 * Creation date: 25/05/2019
 * Last modification: 01/05/2019
 */
public class VersionRequirement{
	private final int rId;
	private final int id; //The id of the requirement it's unique and given by the DB.
	private final String reqId; //The requirement Id is given by the user. It's unique.
	private final String type; //The type of the requirement. It can be: Functional requirement or Non functional requirement.
	private final String name; //The name of the requirement.
	private final String version; //The actual version of the requirement.
	private final String description; //The description of the requirement.
	private final String status; //The actual state of the requirement.
	private final int projectId; //The project Id where the requirement is.
	
	public VersionRequirement (final int rId, final int id,final String reqId,final String type, final String name, final String version,final String description, final String status, final int projectId) {
		this.rId=rId;
		this.id=id;
		this.reqId=reqId;
		this.type=type;
		this.name=name;
		this.version=version;
		this.description=description;
		this.status=status;
		this.projectId=projectId;
	}
	
	public int getRId() {
		return rId;
	}

	public int getId() {
		return id;
	}

	public String getReqId() {
		return reqId;
	}
	public String getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getProjectId() {
		return projectId;
	}
}


