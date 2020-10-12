package com.proyectofinal.web.model;
/**
 * Project:Sigere
 * Developer:Verónica Tofiño
 * Contact email: veronicatofino@gmail.com
 * Creation date: 02/06/2019
 * Last modification: 02/06/2019
 */
public class SRS {
	private int id; //The id of the srs is unique and given by the DB.
	/*Components of the introduction of the document*/
	private String systemProspect; //The system Prospect is the purpose of the srs.
	private String scope; //The scope is the limitations of the document.
	private String objectives; //The objectives are goals and design restrictions.
	private String definitions; //The definitions are the dictionary of words that the audience needs to know to understand the document.
	private String referencs; //The references of the document.
	private String globalAppraisal; //The global Appraisal of the software to developed.
	/*Components of the global description of the document*/
	private String productPerspective; //The product perspective of the document.
	private String interfaces; //The interfaces or mock ups of the document.
	private String userCharacteristics; //The characteristics of the user.
	private String productFunctions; //The product Functions of the document.
	private String domainModel; //The domain Model of the document.
	private String restrictions; //The restrictions of the document.
	private String suppositions; //The suppositions of the document.
	private String dbRequirements; //The Data Base Requirements of the Project.
	private String designRestrictions; //The Design restrictions of the Project.
	private String ruleAcceptance; //The acceptance of the rules to make this Project.
	private int projectId; //The id of the project where the document is going to be created.
	private String version; //Version of the SRS.
	
	public SRS (final int id, final String systemProspect, final String scope, final String objectives, final String definitions,
			final String referencs, final String globalAppraisal, final String productPerspective, final String interfaces, final String userCharacteristics, 
			final String productFunctions, final String domainModel, final String restrictions, final String suppositions,final String dbRequirements, final String designRestrictions, final String ruleAcceptance, final int projectId, final String version) {
		this.id=id;
		this.systemProspect=systemProspect;
		this.scope=scope;
		this.objectives=objectives;
		this.definitions=definitions;
		this.referencs=referencs;
		this.globalAppraisal=globalAppraisal;
		this.productPerspective=productPerspective;
		this.interfaces=interfaces;
		this.userCharacteristics=userCharacteristics;
		this.productFunctions=productFunctions;
		this.domainModel=domainModel;
		this.restrictions=restrictions;
		this.suppositions=suppositions;
		this.dbRequirements=dbRequirements;
		this.designRestrictions=designRestrictions;
		this.ruleAcceptance=ruleAcceptance;
		this.projectId=projectId;
		this.version=version;
	}
	
	public int getId() {
		return id;
	}
	
	public String getScope() {
		return scope;
	}
	
	public String getSystemProspect() {
		return systemProspect;
	}
	
	public String getObjectives() {
		return objectives;
	}

	public String getDefinitions() {
		return definitions;
	}
	public String getReferencs() {
		return referencs;
	}
	public String getGlobalAppraisal() {
		return globalAppraisal;
	}
	public String getProductPerspective() {
		return productPerspective;
	}
	public String getInterfaces() {
		return interfaces;
	}
	public String getUserCharacteristics() {
		return userCharacteristics;
	}
	public String getProductFunctions() {
		return productFunctions;
	}
	public String getDomainModel() {
		return domainModel;
	}
	public String getRestrictions() {
		return restrictions;
	}
	public String getSuppositions() {
		return suppositions;
	}
	public String getDBRequirements() {
		return dbRequirements;
	}
	public String getDesignRestrictions() {
		return designRestrictions;
	}
	public String getRuleAcceptance() {
		return ruleAcceptance;
	}
	public int getProjectId() {
		return projectId;
	}
	public String getVersion() {
		return version;
	}
}

