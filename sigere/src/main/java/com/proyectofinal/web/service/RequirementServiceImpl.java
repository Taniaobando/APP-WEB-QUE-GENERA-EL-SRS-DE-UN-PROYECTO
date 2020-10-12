package com.proyectofinal.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyectofinal.web.dao.RequirementDao;
import com.proyectofinal.web.model.ReqCreate;
import com.proyectofinal.web.model.Requirement;
import com.proyectofinal.web.model.VersionRequirement;

/**
 * Project:Sigere
 * Developers:Laura Arango, Verónica Tofiño
 * Contact emails: lauarangom@gmail.com, veronicatofino@gmail.com
 * Creation date: 25/04/2019
 * Last modification: 15/05/2019
 */
public class RequirementServiceImpl implements RequirementService {
	//Create a Requirement Dao to access to its functions.
	@Autowired
	public RequirementDao requirementDao;
	//Returns the list of Requirements associated to a project.
	@Override
	public List<Requirement> getRequirementByProjectId(int id) {
		return requirementDao.getRequirementByProjectId(id);
	}
	//Returns a requirement by its id.
	@Override
	public Requirement getRequirementById(int id) {
		return requirementDao.getRequirementById(id);
	}
	//Create a new requirement.
	@Override
	public void createRequirement(ReqCreate requirement) {
		requirementDao.createRequirement(requirement);
	}
	//Deletes a version of a Requirement.
	@Override
	public void deleteVersionRequirement(final int rId) {
		requirementDao.deleteVersionRequirement(rId);
	}
	//Deletes a requirement.
	@Override
	public void deleteRequirement(final int id) {
		requirementDao.deleteRequirement(id);
	}
	//Create a Version of a Requirement.
	@Override
	public void createRequirementVersion(Requirement requirement) {
		requirementDao.createRequirementVersion(requirement);
	}
	//Checks a Requirement Id.
	@Override
	public int checkReqId (String reqId, int projectId) {
		return requirementDao.checkReqId(reqId, projectId);
	}
	//Returns the Version of a Requirement.
	@Override
	public List<VersionRequirement> getVersionsByReqId(String reqId, int projectId) {
		return requirementDao.getVersionsByReqId(reqId, projectId);
	}
	//Updates the Requirement from a Requirement.
	@Override
	public void updateRequirementFromReq(int id, ReqCreate requirement) {
		requirementDao.updateRequirementFromReq(id, requirement);
	}
	//Updates the Requirement from a Specification.
	@Override
	public void updateRequirementFromSpec(int id, String version) {
		requirementDao.updateRequirementFromSpec(id, version);
	}
	//Returns the last version of a Requirement.
	@Override
	public 	VersionRequirement getLastVersionReq(final String reqId,final int projectId) {
		return requirementDao.getLastVersionReq(reqId, projectId);
	}
	//Restores the last version of a Requirement.
	@Override
	public void enableVersionReq(VersionRequirement versionRequirement) {
		requirementDao.enableVersionReq(versionRequirement);
	}



	

}