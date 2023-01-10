package com.intelligent.realestate.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		ModelAndView model = new ModelAndView("arrendatarios");
		model.addObject("arrendatarios", arrendatarios);
		return model;
	}

	@RequestMapping("/eliminarArrendatario/{idArrendatario}")
	public String EliminarArrendatario(@PathVariable(name = "idArrendatario") Long idArrendatario) {
		Arrendatario arrendatario = arrendatarioDao.findById(idArrendatario);
		if (arrendatario != null) {
			arrendatarioDao.delete(arrendatario);
		}
		return "redirect:/arrendatarios";
	}

	@RequestMapping("/editarArrendatario/{idArrendatario}")
	public ModelAndView EditarArrendatario(@PathVariable(name = "idArrendatario") Long idArrendatario) {
		ModelAndView model = new ModelAndView("actualizarArrendatario");
		Arrendatario arrendatario = arrendatarioDao.findById(idArrendatario);
		model.addObject("arrendatario", arrendatario);
		return model;
	}

	@RequestMapping(value = "/guardarCambioArrendatario", method = RequestMethod.POST)
	public String guardarArrendatario(@ModelAttribute("arrendatario") Arrendatario arrendatario) {
		arrendatarioDao.actualizarArrendatario(arrendatario);
		return "redirect:/arrendatarios";
	}

	@RequestMapping("/crearArrendatario")
	public String CrearArrendatario(Model model) {
		Arrendatario arrendatario = new Arrendatario();
		model.addAttribute("arrendatario", arrendatario);
		return "crearArrendatario";
	}

	@RequestMapping(value = "/guardarNuevoArrendatario", method = RequestMethod.POST)
	public String guardarNuevoArrendatario(@ModelAttribute("arrendatario") Arrendatario arrendatario) {
		arrendatarioDao.insertArrendatario(arrendatario);
		return "redirect:/arrendatarios";
	}
}
