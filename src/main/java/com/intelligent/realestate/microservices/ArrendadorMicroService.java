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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	// curl -X GET localhost:8080/arrendador/1 -H 'Content-type:application/json'
	@GetMapping(value = "arrendador/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Arrendador buscarPorId(@PathVariable("id") String id) {
		Arrendador arrendador = arrendadorDao.buscarPorId(Long.parseLong(id));
		return arrendador;
	}

	// http://localhost:8080/arrendador/D/AP/AM
	@GetMapping(value = "arrendador/{nombre}/{apellido_paterno}/{apellido_materno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Arrendador> buscarPorNombreApellidoMaternoApellidoPaterno(@PathVariable String nombre,
			@PathVariable String apellido_paterno, @PathVariable String apellido_materno) {
		List<Arrendador> arrendador = arrendadorDao.buscarPorNombreApellidoMaternoApellidoPaterno(nombre,
				apellido_materno, apellido_paterno);
		return arrendador;
	}

	/*
	 * Metodo para guardar usamos el POST y para correrlo usamos el sig. comando
	 * 
	 * curl -i -H "Accept: application/json" -H "Content-Type:application/json" -X \
	 * POST --data \
	 * '{"nombre1":"K1","nombre2":"B1","apellidoMaterno":"Q1","apellidoPaterno":"J",
	 * "edad":29,"correo":"KD","celular":"celD","direccion":{"direccion1":"D1",
	 * "direccion2":"D2","pais":"P","ciudad":"C","estado":"E","codigoPostal":"CP"},
	 * "realEstate":null,"realEstates":[]}' http://localhost:8080/arrendador
	 */
	@PostMapping(path = "arrendador", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Arrendador> guardarArrendador(@RequestBody Arrendador arrendador) throws ServerException {
		if (arrendador == null) {
			throw new ServerException("Arrendador vacio, por favor llenalo");
		} else {
			arrendadorDao.guardarArrendador(arrendador);
			return new ResponseEntity<>(arrendador, HttpStatus.CREATED);
		}
	}

	/*
	 * Metodo para actializar
	 * 
	 * 		curl -i -H "Accept: application/json" -H "Content-Type:application/json" -X \
	 * 		PUT --data \
	 * 		'{"nombre1":"D","nombre2":"M","apellidoMaterno":"H","apellidoPaterno":"C",
	 * 		"edad":20,"correo":"DM","celular":"celDM","direccion":{"direccion1":"DM1",
	 * 		"direccion2":"DM2","pais":"PM","ciudad":"CM","estado":"EM","codigoPostal":
	 * 		"CPM"},"realEstate":null,"realEstates":[]}'
	 * 		http://localhost:8080/arrendador/1
	 * 
	 */
	@PutMapping("/arrendador/{id}")
	public ResponseEntity<Arrendador> actualizarArrendador(@PathVariable(value = "id") Long idLong,
			@RequestBody Arrendador arrendador) {
		arrendador.setIdArrendador(idLong);
		arrendadorDao.actualizarArrendador(arrendador);
		return ResponseEntity.ok(arrendador);

	}
}