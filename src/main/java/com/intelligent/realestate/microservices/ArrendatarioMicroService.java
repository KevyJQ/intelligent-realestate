package com.intelligent.realestate.microservices;

import java.util.List;

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
	
	@GetMapping(value = "arrendatario/{nombre}/{apellido_paterno}/{apellido_materno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Arrendatario> findByNameAndLasName(@PathVariable String nombre,@PathVariable String apellido_paterno,@PathVariable String apellido_materno) {
		List<Arrendatario> arrendatario = arrendatarioDao.findByNameAndLasName(nombre,apellido_materno,apellido_paterno);
		return arrendatario;
	}
}
