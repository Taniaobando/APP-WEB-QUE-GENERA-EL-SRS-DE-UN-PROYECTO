package com.proyectofinal.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.proyectofinal.web.model.User;
import com.proyectofinal.web.service.UserService;
/**
 * Project:Sigere
 * Developer:Verónica Tofiño
 * Contact email: veronicatofino@gmail.com
 * Creation date: 10/04/2019
 * Last modification: 14/05/2019
 */
@Controller
public class PasswordRecoveryController {
  //Create a User Service to access to it functions.
  @Autowired
  public UserService userService;
 //When loads the page from other view.
  @RequestMapping(value = "/recuperarContraseña", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("recoverPassword");
    mav.addObject("user", new User());
    return mav; 
   
  }
}