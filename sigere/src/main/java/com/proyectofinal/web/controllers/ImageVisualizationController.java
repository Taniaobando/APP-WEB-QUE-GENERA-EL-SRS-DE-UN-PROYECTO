package com.proyectofinal.web.controllers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.proyectofinal.web.service.ImageService;
/**
 * Project:Sigere
 * Developers:Tania Obando
 * Contact emails: taniaobando1998@gmail.com
 * Creation date: 02/06/2019
 * Last modification: 02/06/2019
 */
@Controller

public class ImageVisualizationController {

		//Create a Image Service to access to it functions.
		@Autowired
		ImageService imageService;
		
		//When loads the page from other view.
		@RequestMapping(value = "/getPhoto", method= RequestMethod.GET)
		public void getPhoto(HttpServletResponse response,  @RequestParam("id") int id) throws Exception {
			response.setContentType("image/jpeg");

			byte [] bytes = imageService.getPhotoById(id);
			InputStream inputStream = new ByteArrayInputStream(bytes);
			IOUtils.copy(inputStream, response.getOutputStream());
		}
		
	}



