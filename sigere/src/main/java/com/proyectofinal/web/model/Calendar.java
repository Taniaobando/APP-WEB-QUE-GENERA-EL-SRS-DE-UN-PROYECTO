package com.proyectofinal.web.model;


/**
 * Project:Sigere
 * Developer:Verónica Tofiño
 * Contact email: veronicatofino@gmail.com
 * Creation date: 24/05/2019
 * Last modification: 24/05/2019
 */
public class Calendar {
	private final int id; //id of the event of the calendar. Given by default from the DB.
	private final String year; //The year of the event.
	private final String month; //The month of the event.
	private final String day; //The day of the event.
	private final String title ; //The title of the event.
	private final String description; //The description of the event.
	private final int projectId; //The id of the project were the event was created.
	
	
	public Calendar (int id, String year, String month, String day, String title, String description, int projectId) {
		this.id=id;
		this.year=year;
		this.month=month;
		this.day=day;
		this.title=title;
		this.description=description;
		this.projectId=projectId;
	}
	
	public int getId() {
		return id;
	}
	
	public String getYear() {
		return year;
	}
	
	public String getMonth() {
		return month;
	}
	
	public String getDay() {
		return day;
	}

	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getProjectId() {
		return projectId;
		
	}
	
}
