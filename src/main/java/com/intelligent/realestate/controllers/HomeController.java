package com.intelligent.realestate.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private ServletContext servletContext;

	// curl -X GET localhost:8080/ -H 'Content-type:application/json'
	@RequestMapping(value = "/")
	public ModelAndView home(HttpServletResponse response) throws IOException {
	return new ModelAndView("home");
	}
}