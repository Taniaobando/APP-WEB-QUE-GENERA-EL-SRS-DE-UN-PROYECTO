package com.proyectofinal.web.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyectofinal.web.dao.UserDao;
import com.proyectofinal.web.model.Login;
import com.proyectofinal.web.model.User;
/**
 * Project:Sigere
 * Developers:Laura Arango, Verónica Tofiño
 * Contact emails:lauarangom@gmail.com, veronicatofino@gmail.com
 * Creation date: 23/04/2019
 * Last modification: 15/05/2019
 */
public class UserServiceImpl implements UserService {
	//Create a User Dao to access to its functions.
	@Autowired
	public UserDao userDao;
	//Create a new user.
	public void register(User user) {
		userDao.register(user);
	}
	//Validate that a user exist in the DB to login.
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}
	//Validate if a user exists. If not, it creates it.
	@Override
	public boolean existsUser(User user) {
		return userDao.existsUser(user);
	}
	//Returns the id of a user.  
	@Override
	public int getIdByUser(User user) {
		return userDao.getIdByUser(user);
	}
	//Returns a user by its id.  
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	//Returns a user by its email.
	@Override
	public int getIdByEmail(String email) {
		return userDao.getIdByEmail(email);
	}	 
}