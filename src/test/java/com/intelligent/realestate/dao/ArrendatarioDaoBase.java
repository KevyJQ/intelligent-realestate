package com.intelligent.realestate.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.util.ModelUtil;

public abstract class ArrendatarioDaoBase {
	protected ArrendatarioDao arrendatarioDao;

	public abstract void setup();

	@Test
	public void findId() {
		Arrendatario arrendatario = ModelUtil.crearArrendatario();
		arrendatarioDao.insertArrendatario(arrendatario);

		Arrendatario result = arrendatarioDao.findById(arrendatario.getIdArrendatario());

		assertNotNull(result);
		assertNotNull(result.getIdArrendatario());
	}

	@Test
	public void findByNameAndLastName() {
		Arrendatario arrendatario1 = ModelUtil.crearArrendatario();
		Arrendatario arrendatario2 = ModelUtil.crearArrendatario();

		arrendatarioDao.insertArrendatario(arrendatario1);
		arrendatarioDao.insertArrendatario(arrendatario2);

		List<Arrendatario> arrendatarios;
		arrendatarios = arrendatarioDao.findByNameAndLasName(arrendatario1.getNombre1(),
				arrendatario1.getApellidoPaterno(), arrendatario1.getApellidoMaterno());

		assertEquals(arrendatarios.size(), 1);
	}

	@Test
	public void insert_arrendatario() {
		Arrendatario arrendatario = ModelUtil.crearArrendatario();
		assertNull(arrendatario.getIdArrendatario());// Tiene se estar nulo porque es valor unico

		arrendatarioDao.insertArrendatario(arrendatario);

		assertNotNull(arrendatario.getIdArrendatario());
	}

}
