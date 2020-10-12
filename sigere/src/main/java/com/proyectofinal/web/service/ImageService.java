package com.proyectofinal.web.service;

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
public interface ImageService {
	//Store an Image and its information in th DB.
	public int inserRecords(String name, MultipartFile image, int projectId);
	//Returns all the images of a project.
	public List<Image> infoImageList(int idP);
	//Returns a Photo by its Id.
	public  byte[] getPhotoById(int id);
	
	
}
