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
import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.model.RealEstateEstatus;
import com.intelligent.realestate.model.TypeRealEstate;

@Controller
public class RealEstateController {

	@Autowired
	private RealEstateDao realEstateDao;
	@Autowired
	private ArrendadorDao arrendadorDao;

	// Muestra todos los real Estates
	@RequestMapping("/realEstates")
	public ModelAndView RealEstate(HttpServletResponse response) throws IOException{

		List<RealEstate> realEstates = realEstateDao.findAll();
		ModelAndView model = new ModelAndView("realEstates");
		model.addObject("realEstates", realEstates);
		return model;
	}

	// Crea un Real Estate
	@RequestMapping("/crearRealEstate/{idArrendador}")
	public String crearRealEstate(@PathVariable(name = "idArrendador") Long idArrendador, Model model) {
		RealEstate realEstate = new RealEstate();
		realEstate.setArrendadadorId(idArrendador);
		model.addAttribute("realEstate", realEstate);

		return "crearRealEstate";
	}

	// Elimina un Real Estate
	@RequestMapping("/eliminarRealEstate/{idRealEstate}")
	public String eliminarRealEstate(@PathVariable(name = "idRealEstate") Long idRealEstate) {
		RealEstate realEstate = realEstateDao.findById(idRealEstate);
		if (realEstate != null) {
			realEstateDao.delete(realEstate);
		}
		return "redirect:/realEstates";
	}

	// Edita un Real Estate
	@RequestMapping(value = "/editarRealEstate/{idRealEstate}")
	public ModelAndView editarRealEstate(@PathVariable(name = "idRealEstate") Long idRealEstate) {
		ModelAndView model = new ModelAndView("actualizarRealEstate");
		RealEstate realEstate = realEstateDao.findById(idRealEstate);
		model.addObject("realEstates", realEstate);
		return model;
	}

	// Guarda el Real Estate existente
	@RequestMapping(value = "/guardarCambioRealEstate", method = RequestMethod.POST)
	public String guardarRealEstate(@ModelAttribute("realestate") RealEstate realEstate) {
		realEstateDao.actualizarRealEstate(realEstate);
		return "redirect:/realEstates";
	}

	// Guarda un Real Estate Nuevo
	@RequestMapping(value = "/guardarNuevoRealEstate", method = RequestMethod.POST)
	public String guardarNuevoRealEstate(@ModelAttribute("realEstate") RealEstate realEstate) {
		System.out.println("RealEstateController.guardarNuevoRealEstate() -> " + realEstate);
		// TODO: use combo box instead for Estatus y RealEstateType.
		realEstate.setEstatus(RealEstateEstatus.DISPONIBLE);
		realEstate.setRealEstateType(TypeRealEstate.CASA);
		Arrendador arrendador = arrendadorDao.buscarPorId(realEstate.getArrendadadorId());
		if (arrendador != null) {
			realEstateDao.insertRealEstate(realEstate);
		}
		return "redirect:/realEstates";
	}

//	@RequestMapping(value = "/guardarNuevoRealEstatee/{idArrendador}", method = RequestMethod.POST)
//	public String guardarRealEstateN(@PathVariable(name = "idArrendador") Long idArrendador, Model model) {
//		Arrendador arrendador = arrendadorDao.buscarPorId(idArrendador);
//		if (arrendador != null) {
//			RealEstate realEstate = new RealEstate();
//			model.addAttribute("realEstate", realEstate);
//			return "crearRealEstate";
//		}
//		return "redirect:/realEstates";
//	}

}
