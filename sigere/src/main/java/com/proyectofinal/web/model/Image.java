package com.proyectofinal.web.model;


public class Image {
	
	private int idIm; //id de la Imagen
	private int idP ; //id del proyecto al que pertenece 
	private String nameIm;// Diagrama de contexto
	
	
	public Image (int idIm,int idP,String nameIm) {
		this.idIm=idIm;
		this.idP=idP;
		this.nameIm=nameIm;
	}
	
	public Image() {
		
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
