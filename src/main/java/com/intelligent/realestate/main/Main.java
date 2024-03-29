package com.intelligent.realestate.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.dao.ContratoDao;
import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.dao.hibernate.ArrendadorDaoImpl;
import com.intelligent.realestate.dao.hibernate.RealEstateDaoImpl;
import com.intelligent.realestate.dao.hibernate.ArrendatarioDaoImpl;
import com.intelligent.realestate.dao.jdbc.ContratoDaoImpl;
import com.intelligent.realestate.dao.jdbc.DbConnnection;
import com.intelligent.realestate.dao.jdbc.util.JdbcUtil;
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

		ArrendadorDao arrendadorDao = new ArrendadorDaoImpl();
		ArrendatarioDao arrendatarioDao = new ArrendatarioDaoImpl();
		ScannerService scannerService = new ScannerServiceImpl();
		RealEstateDao realEstateDao = new RealEstateDaoImpl();
		ContratoDao contratoDao = new ContratoDaoImpl(connection);

		MenuBuscarService<Arrendador> menuBuscarArrendador = new MenuBuscarArrendadorServiceImpl(arrendadorDao,
				scannerService);
		MenuBuscarService<Arrendatario> menuBuscarArrendatario = new MenuBuscarArrendatarioServiceImpl(arrendatarioDao,
				scannerService);
		MenuBuscarService<RealEstate> menuBuscarRealEstate = new MenuBuscarRealEstateServiceImpl(realEstateDao,
				scannerService);

		MenuService menuArrendMenuService = new MenuArrendadorImpl(arrendadorDao, realEstateDao, menuBuscarArrendador,
				scannerService);

		MenuService menuArrendatarioService = new MenuArrendatarioImp(arrendatarioDao, menuBuscarArrendatario,
				menuBuscarRealEstate, contratoDao, scannerService);

		MenuService menuPrincipalService = new MenuPrincipalServiceImpl(menuArrendMenuService, menuArrendatarioService,
				scannerService);

		menuPrincipalService.mostrarMenu();

		JdbcUtil.close(connection);
	}
}
