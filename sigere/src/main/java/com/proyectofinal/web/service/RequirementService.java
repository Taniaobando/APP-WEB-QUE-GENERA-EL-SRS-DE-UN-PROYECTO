package com.proyectofinal.web.service;

import java.util.List;

import com.proyectofinal.web.model.Requirement;
import com.proyectofinal.web.model.ReqCreate;
import com.proyectofinal.web.model.VersionRequirement;

/**
 * Project:Sigere
 * Developers:Laura Arango, Verónica Tofiño
 * Contact emails: lauarangom@gmail.com, veronicatofino@gmail.com
 * Creation date: 25/04/2019
 * Last modification: 15/05/2019
 */
public interface RequirementService{
	//Returns the Requirements of a Project.
	List<Requirement> getRequirementByProjectId(final int id);
	//Returns the requirement by its id.
	Requirement getRequirementById(final int id);
	//Creates a new requirement.
	void createRequirement(ReqCreate requirement);
	//Deletes a Version of the Requirement.
	void deleteVersionRequirement(final int rId);
	//Deletes a Requirement.
	void deleteRequirement(final int id);
	//Creates a new version of a Requirement.
	void createRequirementVersion(Requirement requirement);
	//Checks a Requirement Id.
	int checkReqId(final String reqId, final int projectId);
	//Returns the Versions of a Requirement.
	List<VersionRequirement> getVersionsByReqId(final String reqId, final int projectId);
	//Updates the Requirement from a Requirement.
	void updateRequirementFromReq(final int id, final ReqCreate requirement);
	//Updates the Requirement from a Specification.
	void updateRequirementFromSpec(final int id, final String version);
	//Returns the last version of a Requirement.
	VersionRequirement getLastVersionReq(final String reqId,final int ptojectId);
	//Restore the last version of a Requirement.
	void enableVersionReq (final VersionRequirement versionRequirement);
	
	
}
