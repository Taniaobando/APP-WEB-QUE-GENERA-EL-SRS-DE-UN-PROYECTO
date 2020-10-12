package com.proyectofinal.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyectofinal.web.dao.SpecificationDao;
import com.proyectofinal.web.model.Specification;
import com.proyectofinal.web.model.SpecificationCreate;
import com.proyectofinal.web.model.VersionSpecification;

import java.sql.Timestamp;

/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email:lauarangom@gmail.com
 * Creation date: 26/04/2019
 * Last modification: 15/05/2019
 */
public class SpecificationServiceImpl implements SpecificationService {
	//Create a Specification Dao to access to its functions.
	@Autowired
	public SpecificationDao specificationDao;
	//Create a new Specification.
	@Override
	public void createSpecification (SpecificationCreate specification) {
		specificationDao.createSpecification(specification);
	}
	//Returns a list with the Specifications associated to a Requirement.
	@Override
	public List <Specification> getSpecificationByRequirementId(int id) {
		return specificationDao.getSpecificationByRequirementId(id);
	}
	//Returns a specification by its Id.
	@Override
	public Specification getSpecificationById(int id) {
		return specificationDao.getSpecificationById(id);
	}
	//Creates a Version of the Specification.
	@Override
	public void createSpecificationVersion(Specification specification) {
		specificationDao.createSpecificationVersion(specification);
	} 
	//Updates the Specification when the User changes the Requirement.
	@Override
	public void updateSpecificationFromReq(Specification specification,Timestamp ts,String version) {
		specificationDao.updateSpecificationFromReq(specification, ts, version);

	}
	//Updates the Specification when the user changes the Specification.
	@Override
	public 	void updateSpecificationFromSpec(int id,SpecificationCreate specification, Timestamp ts) {
		specificationDao.updateSpecificationFromSpec(id, specification, ts);
	}
	//Returns the last version of a Specification.
	@Override
	public VersionSpecification getLastVersionSpe(final int id) {
		return specificationDao.getLastVersionSpe(id);
	}
	//Restore the last version of a Specification of the Historical.
	@Override
	public void enableVersionSpec(VersionSpecification versionSpecification) {
		specificationDao.enableVersionSpec(versionSpecification);
	}
	//Deletes a Version of a Specification.
	@Override
	public void deleteVersionSpecification(int sId) {
		specificationDao.deleteVersionSpecification(sId);

	}
	//Deletes a Specification.
	@Override
	public void deleteSpecification(int id) {
		specificationDao.deleteSpecification(id);
	}
	//Returns the Versions of a Specification
	@Override
	public List<VersionSpecification> getSpecificationVersions(int requirementId) {
		return specificationDao.getSpecificationVersions(requirementId);
	}


}