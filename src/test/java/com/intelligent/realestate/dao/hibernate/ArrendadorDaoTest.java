package com.intelligent.realestate.dao.hibernate;

import org.junit.Before;

import com.intelligent.realestate.dao.ArrendadorDaoBase;

public class ArrendadorDaoTest extends ArrendadorDaoBase{

	@Before
	public void setup() {
		arrendadorDao = new ArrendadorDaoImpl();
	}
}
