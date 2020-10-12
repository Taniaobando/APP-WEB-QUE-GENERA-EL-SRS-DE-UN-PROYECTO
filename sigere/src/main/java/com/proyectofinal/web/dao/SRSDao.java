package com.proyectofinal.web.dao;

import com.proyectofinal.web.model.ProjectCreate;
import com.proyectofinal.web.model.SRS;
import com.proyectofinal.web.model.SRSEditDescrGlobal;
import com.proyectofinal.web.model.SRSEditIntro;
import com.proyectofinal.web.model.SRSEditReqs;
/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email:lauarangom@gmail.com
 * Creation date: 02/06/2019
 * Last modification: 02/06/2019
 */
public interface SRSDao {
	//Create the SRS of the project. It is created when the project is created.
	void createSRS(final ProjectCreate project);
	//Edit the introduction of the SRS of the project
	void editSRSIntro(SRSEditIntro srs, String version);
	//Returns the SRS of a project
	SRS getSRSByProjectId(int id);
	//Edit the Global Description of the SRS of the project
	void editSRSDescrGlobal(SRSEditDescrGlobal srs, String version);
	//Edit the Other Requirements of the SRS of the project
	void editSRSReqs(SRSEditReqs srs, String version);
	void saveVersionSRS(SRS srs);
}
