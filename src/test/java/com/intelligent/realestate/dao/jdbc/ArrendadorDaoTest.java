package com.intelligent.realestate.dao.jdbc;

import org.junit.Before;

import com.intelligent.realestate.dao.ArrendadorDaoBase;

/**
 * Unit test for ArrendadorDao.
 */
public class ArrendadorDaoTest extends ArrendadorDaoBase {

	@Before
	public void setup() {
		arrendadorDao = new ArrendadorDaoImpl(DbConnnection.getConnection());
	}
}
