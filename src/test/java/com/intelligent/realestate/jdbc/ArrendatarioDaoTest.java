package com.intelligent.realestate.jdbc;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.dao.jdbc.ArrendatarioDaoImpl;
import com.intelligent.realestate.dao.jdbc.DbConnnection;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Direccion;
import com.intelligent.realestate.model.util.ModelUtil;

public class ArrendatarioDaoTest {
	private ArrendatarioDao arrendatarioDao;

	@Before
	public void setup() throws SQLException {
		arrendatarioDao = new ArrendatarioDaoImpl(DbConnnection.getConnection());
	}

	@Test
	public void insertarrendatario() {
		// Setup
		Arrendatario arrendatario = ModelUtil.crearArrendatario();

		// Ejecutar test case.
		// --Pueba del metodo insertArrendatario
		arrendatarioDao.insertArrendatario(arrendatario);
		// --Prueba del metodo findById de Arrendatario
		// arrendatarioDao.findById(1);

		System.out.println("Id arrendatario: " + arrendatario.getIdArrendatario());

		// Evaluar assertions.
		assertNotNull(arrendatario.getIdArrendatario());
	}
}
