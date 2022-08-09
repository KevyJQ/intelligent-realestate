package com.intelligent.realestate.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.intelligent.realestate.model.util.ModelUtil;

public class DireccionTest {

	@Test
	public void test_equals() {
		Direccion dir1 = ModelUtil.crearDireccion();
		Direccion dir2 = ModelUtil.crearDireccion();

		assertEquals(dir1, dir1);
		assertEquals(dir1, dir2);
	}

	@Test
	public void test_set_all_equal() {
		Direccion dir1 = ModelUtil.crearDireccion();
		Direccion dir2 = ModelUtil.crearDireccion();
		Direccion dir3 = dir1;
		Direccion dir4 = dir2;

		Set<Direccion> direcciones = new HashSet<>();
		direcciones.add(dir1);
		direcciones.add(dir2);
		direcciones.add(dir3);
		direcciones.add(dir4);

		assertEquals(direcciones.size(), 1);
	}

	@Test
	public void test_set_not_all_equal() {
		Direccion dir1 = ModelUtil.crearDireccion();
		Direccion dir2 = ModelUtil.crearDireccion();
		dir2.setCiudad("Ciudad de Mexico");
		Direccion dir3 = dir1;
		Direccion dir4 = dir2;

		Set<Direccion> direcciones = new HashSet<>();
		direcciones.add(dir1);
		direcciones.add(dir2);
		direcciones.add(dir3);
		direcciones.add(dir4);

		assertEquals(direcciones.size(), 2);
	}

	@Test
	public void test_list_() {
		Direccion dir1 = ModelUtil.crearDireccion();
		Direccion dir2 = ModelUtil.crearDireccion();
		dir2.setCiudad("Ciudad de Mexico");
		Direccion dir3 = dir1;
		Direccion dir4 = dir2;

		List<Direccion> direcciones = new ArrayList<>();
		direcciones.add(dir1);
		direcciones.add(dir2);
		direcciones.add(dir3);
		direcciones.add(dir4);

		assertEquals(direcciones.size(), 4);
	}
}
