package com.intelligent.realestate.dao.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Direccion;
import com.intelligent.realestate.model.util.ModelUtil;

public class ArrendadorDaoTest {

	private ArrendadorDao arrendadorDao;

	@Before
	public void setup() {
		arrendadorDao = new ArrendadorDaoImpl();
	}

	@Test
	public void insert() {
		Arrendador arrendador = ModelUtil.crearArrendador();

		assertNull(arrendador.getIdArrendador());

		arrendadorDao.insertArrendador(arrendador);

		assertNotNull(arrendador.getIdArrendador());
	}
}
