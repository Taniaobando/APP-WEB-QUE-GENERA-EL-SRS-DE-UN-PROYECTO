package com.proyectofinal.web.model;

public class SRSEditReqs {
	/*Components of the Requirements of the document*/
	private String dbRequirements; //The Data Base Requirements of the Project.
	private String designRestrictions; //The Design restrictions of the Project.
	private String ruleAcceptance; //The acceptance of the rules to make this Project.
	private int projectId; //The id of the project where the SRS is been edited.
	
	public SRSEditReqs (final String dbRequirements, final String designRestrictions, final String ruleAcceptance, final int projectId) {
		this.dbRequirements=dbRequirements;
		this.designRestrictions=designRestrictions;
		this.ruleAcceptance=ruleAcceptance;
		this.projectId=projectId;
	}
	
	public SRSEditReqs() {
		
	}
	
	public void setDbRequirements(String dbRequirements) {
		this.dbRequirements = dbRequirements;
	}
	
	public String getDbRequirements() {
		return dbRequirements;
	}
	public void setDesignRestrictions(String designRestrictions) {
		this.designRestrictions = designRestrictions;
	}
	
	public String getDesignRestrictions() {
		return designRestrictions;
	}
	public void setRuleAcceptance(String ruleAcceptance) {
		this.ruleAcceptance = ruleAcceptance;
	}
	
	public String getRuleAcceptance() {
		return ruleAcceptance;
	}
	
	public void setProjectId(int projectId) {
		this.projectId= projectId;
	}
	
	public int getProjectId() {
		return projectId;
	}
}