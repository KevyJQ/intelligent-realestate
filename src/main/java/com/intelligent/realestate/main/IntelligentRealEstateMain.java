package com.intelligent.realestate.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.jdbc.ArrendadorDaoImpl;
import com.intelligent.realestate.jdbc.ArrendatarioDaoImpl;
import com.intelligent.realestate.jdbc.DbConnnection;
import com.intelligent.realestate.services.IntelligentRealEstateMenuService;
import com.intelligent.realestate.services.IntelligentRealEstateScannerService;
import com.intelligent.realestate.services.impl.IntelligentRealEstateMenuServiceImpl;
import com.intelligent.realestate.services.impl.IntelligentRealEstateScannerServiceImpl;

public class IntelligentRealEstateMain {

	public static void main(String[] args) throws SQLException {
		// System.out.println("Testing");
		Connection connection = DbConnnection.getConnection();
		ArrendadorDao arrendadorDao = new ArrendadorDaoImpl(connection);
		ArrendatarioDao arrendatarioDao = new ArrendatarioDaoImpl(connection);
		IntelligentRealEstateScannerService scannerService = new IntelligentRealEstateScannerServiceImpl();
		IntelligentRealEstateMenuService menuService = new IntelligentRealEstateMenuServiceImpl(arrendadorDao,
				arrendatarioDao, scannerService);
		menuService.mostrarMenuPrincipal();
	}
}
