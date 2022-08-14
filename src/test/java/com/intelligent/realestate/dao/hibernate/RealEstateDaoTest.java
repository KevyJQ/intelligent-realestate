package com.intelligent.realestate.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.model.util.ModelUtil;

public class RealEstateDaoTest {
	private ArrendadorDao arrendadorDao;
	private RealEstateDao realEstateDao;

	@Before
	public void setup() {
		arrendadorDao = new ArrendadorDaoImpl();
		realEstateDao = new RealEstateDaoImpl();
	}

	@Test
	public void insert_realestate() {
		Arrendador arrendador = ModelUtil.crearArrendador();
		arrendadorDao.guardarArrendador(arrendador);

		RealEstate re = ModelUtil.crearRealEstate(arrendador.getIdArrendador());
		assertNull(re.getIdRealEstate());

		realEstateDao.insertRealEstate(re);

		assertNotNull(re.getIdRealEstate());

		// findById debera regresar el Arrendador con los real estate insertado.
		Arrendador result = arrendadorDao.buscarPorId(arrendador.getIdArrendador());

		assertNotNull(result);

		// Verificar que el real estate es regresado.
		assertEquals(result.getRealEstates().size(), 1);
		for (RealEstate expected : result.getRealEstates()) {
			assertEquals(expected.getIdRealEstate(), re.getIdRealEstate());
		}
	}
}
