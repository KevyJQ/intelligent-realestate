package com.intelligent.realestate.dao.hibernate;

import org.junit.Before;

import com.intelligent.realestate.dao.ArrendatarioDaoBase;

public class ArendatarioDaoTest extends ArrendatarioDaoBase {

	@Before
	public void setup() {
		arrendatarioDao = new ArrendatarioDaoImpl();
	}
}
