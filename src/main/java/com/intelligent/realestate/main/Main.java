package com.intelligent.realestate.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.jdbc.ArrendadorDaoImpl;
import com.intelligent.realestate.jdbc.ArrendatarioDaoImpl;
import com.intelligent.realestate.jdbc.DbConnnection;
import com.intelligent.realestate.services.MenuService;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.impl.MenuPrincipalServiceImpl;
import com.intelligent.realestate.services.impl.ScannerServiceImpl;

public class Main {

	public static void main(String[] args) throws SQLException {
		// System.out.println("Testing");
		Connection connection = DbConnnection.getConnection();
		ArrendadorDao arrendadorDao = new ArrendadorDaoImpl(connection);
		ArrendatarioDao arrendatarioDao = new ArrendatarioDaoImpl(connection);
		ScannerService scannerService = new ScannerServiceImpl();
		MenuService menuService = new MenuPrincipalServiceImpl(arrendadorDao,
				arrendatarioDao, scannerService);
		menuService.mostrarMenu();
	}
}
