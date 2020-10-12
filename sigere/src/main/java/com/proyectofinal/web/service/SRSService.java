package com.proyectofinal.web.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.DocumentException;
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
public interface SRSService {
	//Create the SRS of the project
	void createSRS(final ProjectCreate project);
	//Returns the SRS of a project
	SRS getSRSByProjectId(int id);
	//Edit the introduction of the SRS of the project
	void editSRSIntro(SRSEditIntro srs, String version);
	//Edit the Global Description of the SRS of the project
	void editSRSDescrGlobal(SRSEditDescrGlobal srs, String version);
	//Edit the Other Requirements of the SRS of the project
	void editSRSReqs(SRSEditReqs srs, String version);
	//Generates the PDF of the SRS
	void generateSRS(int projectId) throws DocumentException, FileNotFoundException, IOException;
	//Save the old versions in a historical.
	void saveVersionSRS(SRS srs);
}
