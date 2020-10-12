package com.proyectofinal.web.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.proyectofinal.web.model.Image;
/**
 * Project:Sigere
 * Developers:Tania Obando
 * Contact emails: taniaobando1998@gmail.com
 * Creation date: 02/06/2019
 * Last modification: 02/06/2019
 */
public interface ImageDao {
	//Store the image, its name and the projectId in th DB.
	public int inserRecords(String name, MultipartFile image, int projectId);
	//Returns the Images of a project.
	public List<Image> infoImageList(int idP);
	//Returns a Photo by it id.
	public byte[] getPhotoById(int id);
	//Return a Photo by its name and projectId.
	public List<byte[]> getPhotoByNameAndProject(String name, int projectId);
	
	
}