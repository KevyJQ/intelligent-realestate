package com.intelligent.realestate.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.util.ModelUtil;

public abstract class ArrendadorDaoBase {
	protected ArrendadorDao arrendadorDao;

	/**
	 * Crea un objeto de tipo ArrendadorDao
	 */
	public abstract void setup();

	@Test
	public void insert_arrendador() {
		Arrendador arrendador = ModelUtil.crearArrendador();

		assertNull(arrendador.getIdArrendador());

		arrendadorDao.guardarArrendador(arrendador);

		assertNotNull(arrendador.getIdArrendador());
	}

	@Test
	public void findById() {
		Arrendador arrendador = ModelUtil.crearArrendador();
		arrendadorDao.guardarArrendador(arrendador);

		Arrendador result = arrendadorDao.buscarPorId(arrendador.getIdArrendador());

		assertNotNull(result);
		assertNotNull(result.getIdArrendador());
		assertEquals(arrendador.getIdArrendador(), result.getIdArrendador());
	}

	@Test
	public void findByNameAndLasName() {
		Arrendador arrendador1 = ModelUtil.crearArrendador("Dani");
		Arrendador arrendador2 = ModelUtil.crearArrendador("Jannine");

		arrendadorDao.guardarArrendador(arrendador1);
		arrendadorDao.guardarArrendador(arrendador2);

		List<Arrendador> arrendadores;
		arrendadores = arrendadorDao.buscarPorNombreApellidoMaternoApellidoPaterno(arrendador2.getNombre1(),
				arrendador2.getApellidoMaterno(), arrendador2.getApellidoPaterno());

		assertEquals(arrendadores.size(), 1);
	}

	@Test
	public void findByNameAndLasName_empty() {
		List<Arrendador> arrendadores;

		arrendadores = arrendadorDao.buscarPorNombreApellidoMaternoApellidoPaterno("HOla", "Como", "estas");

		assertEquals(arrendadores.size(), 0);
	}

}
