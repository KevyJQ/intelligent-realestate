package com.intelligent.realestate.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;

/**
 * Unit test for ArrendadorDao.
 */
public class ArrendadorDaoTest {
	private ArrendadorDao arrendadorDao;
	
	@Before
	public void setup() throws SQLException {
		arrendadorDao = new ArrendadorDaoImpl(DbConnnection.getConnection());
	}

	public Arrendador crearArrendador() {
		Arrendador arrendador = new Arrendador();
		arrendador.setNombre1("Test nombre1");
		arrendador.setNombre2("Test nombre2");
		arrendador.setApellidoPaterno("Test Apellido");
		arrendador.setApellidoMaterno("Test materno");
		arrendador.setEdad(23);
		arrendador.setCorreo("test@gmail.com");
		arrendador.setCelular("659 864 9454");

		return arrendador;
	}
	
    @Test
    public void insertArrendador() {
    	Arrendador arrendador = crearArrendador();

    	arrendadorDao.insertArrendador(arrendador);

    	assertNotNull(arrendador.getIdArrendador());
    }
}
