package com.proyectofinal.web.dao;

import java.util.List;

import com.proyectofinal.web.model.Requirement;
import com.proyectofinal.web.model.ReqCreate;
import com.proyectofinal.web.model.VersionRequirement;

/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email: lauarangom@gmail.com
 * Creation date: 30/04/2019
 * Last modification: 15/05/2019
 */
public interface RequirementDao {
	//Returns the requirements from a Project.
	List<Requirement> getRequirementByProjectId(final int id);
	//Return a requirement by it id.
	Requirement getRequirementById(final int id);
	//Creates a new requirement.
	void createRequirement(ReqCreate requirement);
	//Deletes the Version of the Requirement
	void deleteVersionRequirement(int rId);
	//Deletes the requirement.
	void deleteRequirement(int id);
	//Creates a new version of the Requirement
	void createRequirementVersion(Requirement requirement);
	//Checks the Id of the requirement of a project.
	int checkReqId(final String reqId, final int projectId);
	//Returns the Requirements versions of a project.
	List<VersionRequirement> getVersionsByReqId (final String reqId, final int projectId);
	//Updates the Requirement from a requirement id previous.
	void updateRequirementFromReq(final int id, final ReqCreate requirement);
	//Updates the Requirement from a change in its specification.
	void updateRequirementFromSpec(final int id, final String Version);
	//Returns the last version of the requirement.
	VersionRequirement getLastVersionReq(final String reqId, final int projectId); 
	//Brings the last version of the historial.
	void enableVersionReq(final VersionRequirement versionRequirement);
	
	
}