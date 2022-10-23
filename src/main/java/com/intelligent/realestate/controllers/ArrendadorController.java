package com.intelligent.realestate.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArrendadorController {

	@RequestMapping("/arrendadores")
	public ModelAndView arrendadores(HttpServletResponse response) throws IOException {
		return new ModelAndView("arrendadores");
	}
}
