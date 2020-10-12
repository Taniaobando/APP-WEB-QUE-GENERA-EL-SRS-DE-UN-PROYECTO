package com.proyectofinal.web.dao;

import java.util.List;
import com.proyectofinal.web.model.SpecificationCreate;
import com.proyectofinal.web.model.Specification;
import com.proyectofinal.web.model.VersionSpecification;
import java.sql.Timestamp;

/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email: lauarangom@gmail.com
 * Creation date: 14/05/2019
 * Last modification: 01/06/2019
 */
public interface SpecificationDao {
	//Create a new Specification.
	void createSpecification(SpecificationCreate specification);
    //Returns the specifications of a requirement.
	List <Specification> getSpecificationByRequirementId(final int id);
	//Returns a specification from it Id.
	Specification getSpecificationById(final int id);
	//Creates a new version of the specification.
	void createSpecificationVersion(final Specification specification);
	//Updates the Specification.
	void updateSpecificationFromReq(final Specification specification, Timestamp ts, String version);
	//Updates the Specification.
	void updateSpecificationFromSpec(final int id, final SpecificationCreate specification, Timestamp ts);
	//Returns the last version of the Specification.
	VersionSpecification getLastVersionSpe(final int id);
	//Returns the last version of the Specification of the Historial.
	void enableVersionSpec(final VersionSpecification versionSpecification);
	//Deletes a version of the Specification
	void deleteVersionSpecification(final int sId);
	//Deletes the specification
	void deleteSpecification(final int id);
	//Returns the Specification Versions.
	List<VersionSpecification> getSpecificationVersions(final int requirementId);
	
}