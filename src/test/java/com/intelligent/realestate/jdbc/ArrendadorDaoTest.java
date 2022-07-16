package com.intelligent.realestate.jdbc;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.util.ModelUtil;

/**
 * Unit test for ArrendadorDao.
 */
public class ArrendadorDaoTest {
	private ArrendadorDao arrendadorDao;
	
	@Before
	public void setup() throws SQLException {
		arrendadorDao = new ArrendadorDaoImpl(DbConnnection.getConnection());
	}
	
    @Test
    public void insertArrendador() {
    	// Setup
    	Arrendador arrendador = ModelUtil.crearArrendador();

    	// Ejecutar test case.
    	arrendadorDao.insertArrendador(arrendador);
    	System.out.println("Id arrendador: " + arrendador.getIdArrendador());

    	// Evaluar assertions.
    	assertNotNull(arrendador.getIdArrendador());
    }
}
