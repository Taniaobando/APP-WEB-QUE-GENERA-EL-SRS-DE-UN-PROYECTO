package com.proyectofinal.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.proyectofinal.web.model.Login;
import com.proyectofinal.web.model.User;
import com.proyectofinal.web.service.UserService;
/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email: lauarangom@gmail.com
 * Creation date: 20/04/2019
 * Last modification: 15/05/2019
 */
@Controller
public class LoginController {
   //Create a User Service to access to it functions.
  @Autowired
  UserService userService;
//When something is sent from the view to the controller. 
  @RequestMapping(value = "/procesoInicio", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("login") Login login) {
    ModelAndView mav = null;
    User user = userService.validateUser(login);
  //Verify that a user has logged in. If not, it is redirected to the home page
    if (user != null) {
      mav = new ModelAndView("redirect:/bienvenido");
      mav.addObject("firstname", user.getFirstname());
      request.getSession().setAttribute("user", user);
    } else {
      mav = new ModelAndView("Home");
      mav.addObject("message", "Username or Password is wrong!!");
    }
    return mav;
  }

}