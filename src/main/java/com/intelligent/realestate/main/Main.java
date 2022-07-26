package com.intelligent.realestate.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.jdbc.ArrendadorDaoImpl;
import com.intelligent.realestate.jdbc.ArrendatarioDaoImpl;
import com.intelligent.realestate.jdbc.DbConnnection;
import com.intelligent.realestate.jdbc.RealEstateDaoImpl;
import com.intelligent.realestate.jdbc.util.JdbcUtil;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.impl.ScannerServiceImpl;
import com.intelligent.realestate.services.menu.MenuBuscarService;
import com.intelligent.realestate.services.menu.MenuService;
import com.intelligent.realestate.services.menu.impl.MenuArrendadorImpl;
import com.intelligent.realestate.services.menu.impl.MenuArrendatarioImp;
import com.intelligent.realestate.services.menu.impl.MenuBuscarArrendadorServiceImpl;
import com.intelligent.realestate.services.menu.impl.MenuBuscarArrendatarioServiceImpl;
import com.intelligent.realestate.services.menu.impl.MenuBuscarRealEstateServiceImpl;
import com.intelligent.realestate.services.menu.impl.MenuPrincipalServiceImpl;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection connection = DbConnnection.getConnection();
		ArrendadorDao arrendadorDao = new ArrendadorDaoImpl(connection);
		ArrendatarioDao arrendatarioDao = new ArrendatarioDaoImpl(connection);
		ScannerService scannerService = new ScannerServiceImpl();
		RealEstateDao realEstate = new RealEstateDaoImpl(connection);

		MenuBuscarService<Arrendador> menuBuscarArrendador = new MenuBuscarArrendadorServiceImpl(arrendadorDao,
				scannerService);
		MenuBuscarService<Arrendatario> menuBuscarArrendatario = new MenuBuscarArrendatarioServiceImpl(arrendatarioDao,
				scannerService);
		MenuBuscarService<RealEstate> menuBuscarRealEstate = new MenuBuscarRealEstateServiceImpl(realEstate,
				scannerService);

		MenuService menuArrendMenuService = new MenuArrendadorImpl(arrendadorDao, menuBuscarArrendador, scannerService);

		MenuService menuArrendatarioService = new MenuArrendatarioImp(arrendatarioDao, menuBuscarArrendatario,
				menuBuscarRealEstate, realEstate, scannerService);

		MenuService menuPrincipalService = new MenuPrincipalServiceImpl(menuArrendMenuService, menuArrendatarioService,
				scannerService);

		menuPrincipalService.mostrarMenu();

		JdbcUtil.close(connection);
	}
}
