package com.intelligent.realestate.microservices;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.model.Arrendador;
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
	
	@PostMapping(path = "arrendatario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Arrendatario> guardarArrendatario(@RequestBody Arrendatario arrendatario) throws ServerException {
		if (arrendatario == null) {
			throw new ServerException("Arrendador vacio, por favor llenalo");
		} else {
			arrendatarioDao.insertArrendatario(arrendatario);
			return new ResponseEntity<>(arrendatario, HttpStatus.CREATED);
		}
	}
}
