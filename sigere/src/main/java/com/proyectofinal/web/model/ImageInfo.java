package com.proyectofinal.web.model;

import org.springframework.web.multipart.MultipartFile;

public class ImageInfo {
	
	private int idIm; //id de la Imagen
	private int idP ; //id del proyecto al que pertenece 
	private String nameIm;// Diagrama de contexto
	
	
	public ImageInfo (int idIm,int idP,String nameIm) {
		this.idIm=idIm;
		this.idP=idP;
		this.nameIm=nameIm;
	}
	
	public ImageInfo() {
		
	}
	
	public void setIdIm(int idIm) {
		this.idIm=idIm;
	}
	
	public int getIdIm() {
		return idIm;
	}
	
	public void setIdP(int idP) {
		this.idP=idP;
	}
	
	public int getIdP() {
		return idP;
	}
	
	public void setNameIm(String nameIm) {
		this.nameIm=nameIm;
	}
	
	
	public String getNameIm() {
		return nameIm;
	}

}
