package com.proyectofinal.web.service;

import java.util.List;
import com.proyectofinal.web.model.SpecificationCreate;
import com.proyectofinal.web.model.VersionSpecification;
import com.proyectofinal.web.model.Specification;
import java.sql.Timestamp;

/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email:lauarangom@gmail.com
 * Creation date: 26/04/2019
 * Last modification: 15/05/2019
 */
public interface SpecificationService{
	//Create a new specification
	void createSpecification (SpecificationCreate specification);
	//Returns the specification of a requirement.
	List <Specification> getSpecificationByRequirementId(final int id);
	//Returns a specification by its id. 
	Specification getSpecificationById(final int id);	
	//Create a new Specification version.
	void createSpecificationVersion(Specification specification);
	//Updates the Specification from the Requirement.
	void updateSpecificationFromReq(Specification specification,Timestamp ts,String version);
	//Updates the Specification from the Specification.
	void updateSpecificationFromSpec(int id,SpecificationCreate specification, Timestamp ts);
	//Returns the last version of the Specification.
	VersionSpecification getLastVersionSpe(final int id);
	//Brings the last Version of the Specification store in the Historical.
	void enableVersionSpec(VersionSpecification versionSpecification);
	//Deletes a version of the Specification.
	void deleteVersionSpecification(final int sId);
	//Deletes a Specification.
	void deleteSpecification(final int id);
	//Returns the Versions of a Specification.
	List<VersionSpecification> getSpecificationVersions(final int requirementId);

}