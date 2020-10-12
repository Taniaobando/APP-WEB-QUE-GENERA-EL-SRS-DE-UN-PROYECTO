package com.proyectofinal.web.model;

public class SRSEditIntro {
	/*Components of the introduction of the document*/
	private String systemProspect; //The system Prospect is the purpose of the srs.
	private String scope; //The scope is the limitations of the document.
	private String objectives; //The objectives are goals and design restrictions.
	private String definitions; //The definitions are the dictionary of words that the audience needs to know to understand the document.
	private String referencs; //The references of the document.
	private String globalAppraisal; //The global Appraisal of the software to developed.
	private int projectId; //The id of the project where the SRS is been edited.
	
	public SRSEditIntro (final String systemProspect, final String scope, final String objectives, final String definitions,
			final String referencs, final String globalAppraisal, final int projectId) {
		this.systemProspect=systemProspect;
		this.scope=scope;
		this.objectives=objectives;
		this.definitions=definitions;
		this.referencs=referencs;
		this.globalAppraisal=globalAppraisal;
		this.projectId=projectId;
	}
	
	public SRSEditIntro() {
		
	}
	
	public void setScope(String scope) {
		this.scope=scope;
	}
	
	public String getScope() {
		return scope;
	}
	
	public void setSystemProspect(String systemProspect) {
		this.systemProspect= systemProspect;
	}
	
	public String getSystemProspect() {
		return systemProspect;
	}
	
	public void setObjectives(String objectives) {
		this.objectives= objectives;
	}
	
	public String getObjectives() {
		return objectives;
	}

	public void setDefinitions(String definitions) {
		this.definitions= definitions;
	}
	
	public String getDefinitions() {
		return definitions;
	}
	
	public void setReferencs(String referencs) {
		this.referencs= referencs;
	}
	
	public String getReferencs() {
		return referencs;
	}
	
	public void setGlobalAppraisal(String globalAppraisal) {
		this.globalAppraisal= globalAppraisal;
	}
	
	public String getGlobalAppraisal() {
		return globalAppraisal;
	}
	
	public void setProjectId(int projectId) {
		this.projectId= projectId;
	}
	
	public int getProjectId() {
		return projectId;
	}
}

