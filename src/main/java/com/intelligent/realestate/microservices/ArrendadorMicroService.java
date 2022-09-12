package com.intelligent.realestate.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;

@CrossOrigin(origins = "*")
@RestController
public class ArrendadorMicroService {

	// TODO: Inyectar Hibernate DAO class ArrendadorDaoImpl aqui.
	@Autowired
	private ArrendadorDao arrendadorDao;

	// curl -X GET localhost:8080/ -H 'Content-type:application/json'
	@RequestMapping("/")
	public String welcomeHome() {
		return "Real Estate Intelligence";
	}

	// curl -X GET localhost:8080/arrendador/12 -H 'Content-type:application/json'
	@GetMapping(value = "arrendador/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Arrendador buscarPorIdE(@PathVariable("id") String id) {
		Arrendador arrendador = arrendadorDao.buscarPorId(Long.parseLong(id));

		return arrendador;
	}
}