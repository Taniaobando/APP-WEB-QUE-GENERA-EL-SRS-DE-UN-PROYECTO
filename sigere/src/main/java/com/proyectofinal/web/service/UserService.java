package com.proyectofinal.web.service;

import com.proyectofinal.web.model.Login;
import com.proyectofinal.web.model.User;
/**
 * Project:Sigere
 * Developers:Laura Arango, Verónica Tofiño
 * Contact emails:lauarangom@gmail.com, veronicatofino@gmail.com
 * Creation date: 23/04/2019
 * Last modification: 15/05/2019
 */
public interface UserService {
  //Add a user to the DB.	
  void register(User user);
  //Validates the user by its username and password.
  User validateUser(Login login);
  //Validates if a user exist.
  boolean existsUser(final User user);
  //Returns the id of a user.
  int getIdByUser(final User user);
  //Returns the user by its id.
  User getUserById(final int id);
  //Returns the id of a user by its email.
  int getIdByEmail(final String email);
}
