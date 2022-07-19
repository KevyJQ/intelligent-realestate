package com.intelligent.realestate.services.menu.impl;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.menu.MenuService;

public class MenuPrincipalServiceImpl implements MenuService {
	private ArrendadorDao arrendadorDao;
	private ArrendatarioDao arrendatarioDao;
	private MenuService menuArrendadorService;
	private MenuService menuArrendatarioService;
	private ScannerService scannerService;

	private enum MenuType {
		ARRENDADOR, ARRENDATARIO, SALIR
	};

	public MenuPrincipalServiceImpl(ArrendadorDao arrendadorDao, ArrendatarioDao arrendatarioDao,
			MenuService menuArrendadorService, MenuService menuArrendatarioService, ScannerService scannerService) {
		this.arrendadorDao = arrendadorDao;
		this.arrendatarioDao = arrendatarioDao;
		this.menuArrendadorService = menuArrendadorService;
		this.menuArrendatarioService = menuArrendatarioService;
		this.scannerService = scannerService;
	}

	@Override
	public void mostrarMenu() {
		System.out.println("==========================================");
		System.out.println("--- Bienvenido Intelligent Real Estate ---");

		while (true) {
			MenuType opcion = mostrarAndObtenerOpciones(); // Nos regresara la opcion que deseamos

			switch (opcion) {
			case ARRENDADOR:
				menuArrendadorService.mostrarMenu();
				break;

			case ARRENDATARIO:
				menuArrendatarioService.mostrarMenu();
				break;

			case SALIR:
				System.out.println("\n\tHasta luego, tenga un lindo dia.");
				return;
			}
		}
	}

	private MenuType mostrarAndObtenerOpciones() {
		int opcion;

		System.out.println("================================");
		System.out.println("        Menu Principal");
		System.out.println("================================");

		System.out.println("1. Menu Arrendador");
		System.out.println("2. Menu Arrendatario");
		System.out.println("3. Salir");
		opcion = scannerService.pedirNumeroEntreRango("Opcion: ", "El numero debe ser entre 1-3", 1, 3);

		MenuType[] menus = MenuType.values();
		return menus[opcion - 1];
	}

}
