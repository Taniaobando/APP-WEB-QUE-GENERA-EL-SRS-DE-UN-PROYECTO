package com.proyectofinal.web.model;

/**
 * Project:Sigere
 * Developer:Verónica Tofiño
 * Contact email: veronicatofino@gmail.com
 * Creation date: 24/05/2019
 * Last modification: 24/05/2019
 */
public class CalendarCreate {
	private String year; //The year of the event.
	private String month; //The month of the event.
	private String day; //The day of the event.
	private String title ; //The title of the event.
	private String description; //The description of the event.
	private int projectId; //The id of the project were the event was created.
	
	
	public CalendarCreate (String year, String month, String day, String title, String description, int projectId) {
		this.year=year;
		this.month=month;
		this.day=day;
		this.title=title;
		this.description=description;
		this.projectId=projectId;
	}
	
	public CalendarCreate() {
		
	}
	
	public void setYear(String year) {
		this.year=year;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setMonth(String month) {
		this.month=month;
	}
	
	
	public String getMonth() {
		return month;
	}
	
	public void setDay (String day) {
		this.day=day;
	}
	
	public String getDay() {
		return day;
	}

	public void setTitle(String title) {
		this.title=title;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setProjectId(int projectId) {
		this.projectId=projectId;
	}
	
	public int getProjectId() {
		return projectId;
		
	}
	
}
