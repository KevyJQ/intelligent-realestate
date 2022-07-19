package com.intelligent.realestate.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.jdbc.ArrendadorDaoImpl;
import com.intelligent.realestate.jdbc.ArrendatarioDaoImpl;
import com.intelligent.realestate.jdbc.DbConnnection;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.services.ImpresionService;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.impl.ImpresionServiceImpl;
import com.intelligent.realestate.services.impl.ScannerServiceImpl;
import com.intelligent.realestate.services.menu.MenuBuscarService;
import com.intelligent.realestate.services.menu.MenuService;
import com.intelligent.realestate.services.menu.impl.MenuArrendadorImpl;
import com.intelligent.realestate.services.menu.impl.MenuArrendatarioImp;
import com.intelligent.realestate.services.menu.impl.MenuBuscarArrendadorServiceImpl;
import com.intelligent.realestate.services.menu.impl.MenuBuscarArrendatarioServiceImpl;
import com.intelligent.realestate.services.menu.impl.MenuPrincipalServiceImpl;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection connection = DbConnnection.getConnection();
		ArrendadorDao arrendadorDao = new ArrendadorDaoImpl(connection);
		ArrendatarioDao arrendatarioDao = new ArrendatarioDaoImpl(connection);
		ScannerService scannerService = new ScannerServiceImpl();
		ImpresionService impresion = new ImpresionServiceImpl();
		MenuBuscarService<Arrendador> menuBuscarArrendador = new MenuBuscarArrendadorServiceImpl(arrendadorDao,
				scannerService, impresion);
		MenuBuscarService<Arrendatario> menuBuscarArrendatario = new MenuBuscarArrendatarioServiceImpl(arrendatarioDao,
				scannerService, impresion);
		MenuService menuArrendMenuService = new MenuArrendadorImpl(arrendadorDao, menuBuscarArrendador, scannerService);
		MenuService menuArrendatarioService = new MenuArrendatarioImp(arrendatarioDao, menuBuscarArrendatario,
				scannerService);
		MenuService menuPrincipalService = new MenuPrincipalServiceImpl(menuArrendMenuService, menuArrendatarioService,
				scannerService);

		menuPrincipalService.mostrarMenu();
	}
}
