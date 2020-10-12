package com.proyectofinal.web.dao;
/**
 * Project:Sigere
 * Developer:Verónica Tofiño
 * Contact email: veronicatofino@gmail.com
 * Creation date: 23/04/2019
 * Last modification: 15/05/2019
 */
import com.proyectofinal.web.model.Login;
import com.proyectofinal.web.model.User;

public interface UserDao {
	//Create a new user
	void register(User user);
	//Validate that a user is in the DB
	User validateUser(Login login);
	//Validate if a user exist in th DB  
	boolean existsUser(final User user);
	//Returns the id from a user given  
	int getIdByUser(final User user);
	//Returns the User from a Id given   
	User getUserById(final int id);
	//Returns the id of a User from a email given  
	int getIdByEmail(final String email);
}
