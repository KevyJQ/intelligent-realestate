package com.intelligent.realestate.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.model.Arrendatario;

@CrossOrigin(origins = "*")
@RestController
public class ArrendatarioMicroService {
	@Autowired
	private ArrendatarioDao arrendatarioDao;

	@GetMapping(value = "arrendatario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Arrendatario findById(@PathVariable("id") String id) {
		Arrendatario arrendatario = arrendatarioDao.findById(Long.parseLong(id));
		return arrendatario;
	}
}
