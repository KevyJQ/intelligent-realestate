package com.intelligent.realestate.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.model.Arrendatario;

@Controller
public class ArrendatariosController {

	@Autowired
	private ArrendatarioDao arrendatarioDao;

	@RequestMapping("/arrendatarios")
	public ModelAndView arrendadores(HttpServletResponse response) throws IOException {

		List<Arrendatario> arrendatarios = arrendatarioDao.findAll();
		ModelAndView model = new ModelAndView("arrendadores");
		model.addObject("arrendatarios", arrendatarios);
		return model;
	}
}
