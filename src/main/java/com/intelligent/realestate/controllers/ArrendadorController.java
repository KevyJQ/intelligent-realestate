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

	@RequestMapping("/eliminarArrendador/{idArrendador}")
	public String EliminarArrendador(@PathVariable(name = "idArrendador")Long idArrendador){
		Arrendador arrendador = arrendadorDao.buscarPorId(idArrendador);
		if(arrendador != null) {
			arrendadorDao.delete(arrendador);
		}
		return "redirect:/arrendadores";
		
	}
	
	@RequestMapping("/editarArrendador/{idArrendador}")
	public ModelAndView EditarArrendador(@PathVariable(name = "idArrendador")Long idArrendador){
		ModelAndView model = new ModelAndView("actualizarArrendador");
		Arrendador arrendador = arrendadorDao.buscarPorId(idArrendador);
		model.addObject("arrendador", arrendador);
		return model;
	}
		
	@RequestMapping(value = "/guardarCambioArrendador", method = RequestMethod.POST)
	public String guardarArrendador(@ModelAttribute("arrendador") Arrendador arrendador) {
		arrendadorDao.actualizarArrendador(arrendador);
		return "redirect:/arrendadores";
	}
	
	@RequestMapping("/crearArrendador")
	public String CrearArrendador(Model model) {
		Arrendador arrendador = new Arrendador();
		model.addAttribute("arrendador", arrendador);
		return "crearArrendador";
	}
	
	@RequestMapping(value = "/guardarNuevoArrendador", method = RequestMethod.POST)
	public String guardarNuevoArrendador(@ModelAttribute("arrendador") Arrendador arrendador) {
		arrendadorDao.guardarArrendador(arrendador);
		return "redirect:/arrendadores";
	}
}
