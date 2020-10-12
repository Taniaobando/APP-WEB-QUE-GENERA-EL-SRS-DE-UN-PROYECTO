 package com.proyectofinal.web.model;
 /**
  * Project:Sigere
  * Developer:Laura Arango
  * Contact email: lauarangom@gmail.com
  * Creation date: 14/05/2019
  * Last modification: 01/06/2019
  */
public class SpecificationCreate{
	private  String code; //The code of the specification is given by the user. It is written in the form RF - code
	private  String name; //The name of the specification.
	//private  Date date; //The creation date of the specification.
	private  String gradeOfNeed; //The degree of need of the requirement from 1 to 5.
	private  String description; //The description of the requirement.
	private  String entry; //The Entries of the specification. It is all the prerequisites the execute that requirement. 
	private  String font; //The source of the specification. From which view comes.
	private  String outt; //The Outputs of the specification. To which view goes.
	private  String destiny; //The destination of the specification. For example: Data Base (DB).
	private  String restriction; //All the restrictions of the requirement.
	private  String process; //The process of the requirement. In colloquial terms how that does what it has to do.
	private  String colateralEffect; //The collateral Effects of the requirement. Unforeseen events that may occur.
	private  int requirementId; //The requirement.
	private  String version; //The version of the specification.

	
	public SpecificationCreate (final String code, final String name, final String gradeOfNeed, final String description, final String entry,
			final String font, final String outt, final String destiny, final String restriction, final String process, final String colateralEffect, 
			final int requirementId, final String version) {
		this.code=code;
		this.name=name;
		//this.date=date;
		this.gradeOfNeed=gradeOfNeed;
		this.description=description;
		this.entry=entry;
		this.font=font;
		this.outt=outt;
		this.destiny=destiny;
		this.restriction=restriction;
		this.process=process;
		this.colateralEffect=colateralEffect;
		this.requirementId=requirementId;
		this.version=version;
	}
	
	public SpecificationCreate() {
		
	}
	
	public void setCode(String code) {
		this.code=code;
	}

	public String getCode() {
		return code;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	
	public void setGradeOfNeed(String gradeOfNeed) {
		this.gradeOfNeed=gradeOfNeed;
	}
	
	public String getGradeOfNeed() {
		return gradeOfNeed;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}

	public String getDescription() {
		return description;
	}
	
	public void setEntry(String entry) {
		this.entry=entry;
	}
	
	public String getEntry() {
		return entry;
	}
	
	public void setFont(String font) {
		this.font=font;
	}
	public String getFont() {
		return font;
	}
	
	public void setOutt(String outt) {
		this.outt=outt;
	}
	public String getOutt() {
		return outt;
	}
	
	public void setDestiny(String destiny) {
		this.destiny=destiny;
	}
	
	public String getDestiny() {
		return destiny;
	}
	
	public void setRestriction(String restriction) {
		this.restriction=restriction;
	}
	
	public String getRestriction() {
		return restriction;
	}
	
	public void setProcess(String process) {
		this.process=process;
	}
	
	public String getProcess() {
		return process;
	}
	
	public void setColateralEffect(String colateralEffect) {
		this.colateralEffect=colateralEffect;
	}
	
	public String getColateralEffect() {
		return colateralEffect;
	}
	
	public void setRequirementId(String requirementId) {
		System.out.println("Req: "+requirementId);
		this.requirementId=Integer.parseInt(requirementId);
	}
	
	public int getRequirementId() {
		return requirementId;
	}
	
	public void setVersion(String version) {
		System.out.println("Version: "+version);
		this.version=version;
	}
	
	public String getVersion() {
		return version;
	}
}


