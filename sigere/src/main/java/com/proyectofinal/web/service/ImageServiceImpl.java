package com.proyectofinal.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.proyectofinal.web.dao.ImageDao;
import com.proyectofinal.web.model.Image;

/**
 * Project:Sigere
 * Developers:Tania Obando
 * Contact emails: taniaobando1998@gmail.com
 * Creation date: 02/06/2019
 * Last modification: 02/06/2019
 */

public class ImageServiceImpl implements ImageService {
	//Create a Image Dao to access to its functions.
	@Autowired
	ImageDao imageDao;
	//Conects to the DB.
	public ImageServiceImpl() {
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException exception) {
	            throw new RuntimeException(exception);
	        }
	}
	//Store an Image and its information in the DB.
	@Override
	public int inserRecords(String name, MultipartFile image, int projectId) {
		return imageDao.inserRecords(name,image, projectId);
	}
	
	//Returns all the images of a Project.
	@Override
	
	public List<Image> infoImageList(int idP) {
		return imageDao.infoImageList(idP);
	
	}
	
	//Returns a Photo by its id.
	@Override
	public byte[] getPhotoById(int id) {
		return imageDao.getPhotoById(id);
 
	}

}
