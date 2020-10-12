package com.proyectofinal.web.model;
/**
 * Project:Sigere
 * Developer:Verónica Tofiño
 * Contact email: veronicatofino@gmail.com
 * Creation date: 22/04/2019
 * Last modification: 15/05/2019
 */

public class Login {

  private String username; //The username is given by the user to identify itself.
  private String password; //The password is given by the user to identify itself.

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
}
