package com.proyectofinal.web.model;

public class SRSEditDescrGlobal {
	/*Components of the global description of the document*/
	private String productPerspective; //The product perspective of the document.
	private String interfaces; //The interfaces or mock ups of the document.
	private String userCharacteristics; //The characteristics of the user.
	private String productFunctions; //The product Functions of the document.
	private String domainModel; //The domain Model of the document.
	private String restrictions; //The restrictions of the document.
	private String suppositions; //The suppositions of the document.
	private int projectId; //The id of the project where the document is going to be created.
	
	public SRSEditDescrGlobal (final String productPerspective, final String interfaces, final String userCharacteristics, 
			final String productFunctions, final String domainModel, final String restrictions, final String suppositions, final int projectId) {
		this.productPerspective=productPerspective;
		this.interfaces=interfaces;
		this.userCharacteristics=userCharacteristics;
		this.productFunctions=productFunctions;
		this.domainModel=domainModel;
		this.restrictions=restrictions;
		this.suppositions=suppositions;
		this.projectId=projectId;
	}
	
	public SRSEditDescrGlobal() {
		
	}
	
	public void setProductPerspective(String productPerspective) {
		this.productPerspective= productPerspective;
	}
	
	public String getProductPerspective() {
		return productPerspective;
	}
	
	public void setInterfaces(String interfaces) {
		this.interfaces= interfaces;
	}
	
	public String getInterfaces() {
		return interfaces;
	}
	
	public void setUserCharacteristics(String userCharacteristics) {
		this.userCharacteristics= userCharacteristics;
	}
	
	public String getUserCharacteristics() {
		return userCharacteristics;
	}
	
	public void setProductFunctions(String productFunctions) {
		this.productFunctions= productFunctions;
	}
	
	public String getProductFunctions() {
		return productFunctions;
	}
	
	public void setDomainModel(String domainModel) {
		this.domainModel= domainModel;
	}
	
	public String getDomainModel() {
		return domainModel;
	}
	
	public void setRestrictions(String restrictions) {
		this.restrictions= restrictions;
	}
	
	public String getRestrictions() {
		return restrictions;
	}
	
	public void setSuppositions(String suppositions) {
		this.suppositions= suppositions;
	}
	
	public String getSuppositions() {
		return suppositions;
	}
	
	public void setProjectId(int projectId) {
		this.projectId= projectId;
	}
	
	public int getProjectId() {
		return projectId;
	}
}

