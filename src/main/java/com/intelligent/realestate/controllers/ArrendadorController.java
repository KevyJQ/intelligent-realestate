package com.intelligent.realestate.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;

@Controller
public class ArrendadorController {

	@Autowired
	private ArrendadorDao arrendadorDao;

	@RequestMapping("/arrendadores")
	public ModelAndView arrendadores(HttpServletResponse response) throws IOException {

		List<Arrendador> arrendadores = arrendadorDao.findAll();
		ModelAndView model = new ModelAndView("arrendadores");
		model.addObject("arrendadores", arrendadores);
		return model;
	}

}
