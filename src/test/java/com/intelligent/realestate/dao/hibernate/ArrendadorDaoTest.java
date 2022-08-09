package com.intelligent.realestate.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.model.util.ModelUtil;

public class ArrendadorDaoTest {

	private ArrendadorDao arrendadorDao;

	@Before
	public void setup() {
		arrendadorDao = new ArrendadorDaoImpl();
	}

	@Test
	public void insert_arrendador() {
		Arrendador arrendador = ModelUtil.crearArrendador();

		assertNull(arrendador.getIdArrendador());

		arrendadorDao.insertArrendador(arrendador);

		assertNotNull(arrendador.getIdArrendador());
	}

	@Test
	public void findById() {
		Arrendador arrendador = ModelUtil.crearArrendador();
		arrendadorDao.insertArrendador(arrendador);

		Arrendador result = arrendadorDao.findById(arrendador.getIdArrendador());

		assertNotNull(result);
		assertNotNull(result.getIdArrendador());
		assertEquals(arrendador.getIdArrendador(), result.getIdArrendador());
	}

	@Test
	public void insert_realestate() {
		Arrendador arrendador = ModelUtil.crearArrendador();
		arrendadorDao.insertArrendador(arrendador);

		RealEstate re = ModelUtil.crearRealEstate(arrendador.getIdArrendador());
		assertNull(re.getIdRealEstate());

		arrendadorDao.insertRealEstate(re);

		assertNotNull(re.getIdRealEstate());

		// findById debera regresar el Arrendador con los real estate insertado.
		Arrendador result = arrendadorDao.findById(arrendador.getIdArrendador());

		assertNotNull(result);

		// Verificar que el real estate es regresado.
		assertEquals(result.getRealEstates().size(), 1);
		for (RealEstate expected : result.getRealEstates()) {
			assertEquals(expected.getIdRealEstate(), re.getIdRealEstate());
		}
	}
}
