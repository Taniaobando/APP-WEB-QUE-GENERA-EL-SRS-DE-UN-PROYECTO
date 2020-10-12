package com.proyectofinal.web.model;
/**
 * Project:Sigere
 * Developer:Verónica Tofiño
 * Contact email: veronicatofino@gmail.com
 * Creation date: 23/04/2019
 * Last modification: 15/05/2019
 */

public class User {

	  private int id; //The id of the user is unique and given by the DB.
	  private String username; //The username of the user.
	  private String password; //The password of the user.
	  private String firstname; //The firstname of the user.
	  private String lastname; //The lastname of the user.
	  private String email; //The email of the user.
	  
	  public int getId() {
		  return id;
	  }
	  
	  public void setId(final int id) {
		  this.id = id;
	  }

	  public String getUsername() {
	    return username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	  public String getPassword() {
	    return password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	  public String getFirstname() {
	    return firstname;
	  }

	  public void setFirstname(String firstname) {
	    this.firstname = firstname;
	  }

	  public String getLastname() {
	    return lastname;
	  }

	  public void setLastname(String lastname) {
	    this.lastname = lastname;
	  }

	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	}