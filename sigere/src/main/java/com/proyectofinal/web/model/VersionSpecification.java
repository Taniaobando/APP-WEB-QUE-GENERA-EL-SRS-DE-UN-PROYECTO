 package com.proyectofinal.web.model;
 /**
  * Project:Sigere
  * Developer: Laura Arango
  * Contact email: lauarangom@gmail.com
  * Creation date: 29/05/2019
  * Last modification: 02/06/2019
  */
import java.sql.Date;
//The specification is the explanation of a requirement given.
public class VersionSpecification{
	private final int sId;
	private final int id; //The id of the specification is unique and given by the DB.
	private final String code; //The code of the specification is given by the user. It is written in the form RF - code
	private final String name; //The name of the specification.
	private final Date date; //The creation date of the specification.
	private final String gradeOfNeed; //The Degree of Need of the requirement.
	private final String description; //The description of the requirement.
	private final String entry; //The Entries of the specification. It is all the prerequisites the execute that requirement. 
	private final String font; //The source of the specification. From which view comes.
	private final String outt; //The Outputs of the specification. To which view goes.
	private final String destiny; //The destination of the specification. For example: Data Base (DB).
	private final String restriction; //All the restrictions of the requirement.
	private final String process; //The process of the requirement. In colloquial terms how that does what it has to do.
	private final String colateralEffect; //The collateral Effects of the requirement. Unforeseen events that may occur.
	private final int requirementId; //The requirement.
	private final String version;
	
	public VersionSpecification (final int sId, final int id,final String code, final String name,final Date date, final String gradeOfNeed, final String description, final String entry,
			final String font, final String outt, final String destiny, final String restriction, final String process, final String colateralEffect, final int requirementId, final String version) {
		this.sId=sId;
		this.id=id;
		this.code=code;
		this.name=name;
		this.date=date;
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
	
	public int getSId() {
		return sId;
	}
	
	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getGradeOfNeed() {
		return gradeOfNeed;
	}

	public String getDescription() {
		return description;
	}
	
	public String getEntry() {
		return entry;
	}
	
	public String getFont() {
		return font;
	}
	
	public String getOutt() {
		return outt;
	}
	
	public String getDestiny() {
		return destiny;
	}
	
	public String getRestriction() {
		return restriction;
	}
	
	public String getProcess() {
		return process;
	}
	
	public String getColateralEffect() {
		return colateralEffect;
	}
	
	public int getRequirementId() {
		return requirementId;
	}
	
	public String getVersion() {
		return version;
	}
}


