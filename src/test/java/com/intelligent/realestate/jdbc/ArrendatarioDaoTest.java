package com.intelligent.realestate.jdbc;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;


import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.model.Arrendatario;


public class ArrendatarioDaoTest {
	private ArrendatarioDao arrendatarioDao;

	@Before
	public void setup() throws SQLException {
		arrendatarioDao = new ArrendatarioDaoImp(DbConnnection.getConnection());
	}

	public Arrendatario crearArrendatario() {
		Arrendatario arrendatario = new Arrendatario();
		Date date = new Date();
		arrendatario.setNombre1("Test nombre1 " + date);
		arrendatario.setNombre1("Test name ");
		arrendatario.setNombre2("Test nombre2 ");
		arrendatario.setApellidoPaterno("Test Apellido");
		arrendatario.setApellidoMaterno("Test materno");
		arrendatario.setEdad(23);
		arrendatario.setCorreo("test@gmail.com");
		arrendatario.setCelular("659 864 9454");

		return arrendatario;
	}

	@Test
	public void insertarrendatario() {
		// Setup
		Arrendatario arrendatario = crearArrendatario();

		// Ejecutar test case.
		//--Pueba del metodo insertArrendatario
		//arrendatarioDao.insertArrendatario(arrendatario);
		//--Prueba del metodo findById de Arrendatario
		arrendatarioDao.findById(1);

		System.out.println("Id arrendatario: " + arrendatario.getIdArrendatario());

		// Evaluar assertions.
		//assertNotNull(arrendatario.getIdArrendatario());
	}
}
