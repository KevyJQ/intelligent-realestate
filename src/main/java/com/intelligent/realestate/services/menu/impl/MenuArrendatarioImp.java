package com.intelligent.realestate.services.menu.impl;

import java.util.Optional;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.menu.MenuBuscarService;
import com.intelligent.realestate.services.menu.MenuService;

public class MenuArrendatarioImp implements MenuService {
	private ArrendatarioDao arrendatarioDao;
	private MenuBuscarService<Arrendatario> menuBuscarArrendatarios;
	private ScannerService scannerService;

	private enum MenuType {
		BUSCAR_ARRENDATARIO, CREAR_ARRENDATARIO, SALIR
	};

	public MenuArrendatarioImp(ArrendatarioDao arrendatarioDao, MenuBuscarService<Arrendatario> menuBuscarArrendatario,
			ScannerService scannerService) {
		this.arrendatarioDao = arrendatarioDao;
		this.menuBuscarArrendatarios = menuBuscarArrendatario;
		this.scannerService = scannerService;
	}

	@Override
	public void mostrarMenu() {
		while (true) {
			Optional<Arrendatario> arrendatario;
			MenuType opcion = mostrarAndOptenerOpcion();

			switch (opcion) {
			case BUSCAR_ARRENDATARIO:
				arrendatario = menuBuscarArrendatarios.buscarMenu();
				break;

			case CREAR_ARRENDATARIO:
				System.out.println("==========================");
				System.out.println("   Ingresemos tus datos.  ");
				System.out.println("==========================");
				arrendatarioDao.insertArrendatario(scannerService.pedirArrendatario());
				break;

			case SALIR:
				return;
			}
		}

	}

	private MenuType mostrarAndOptenerOpcion() {
		int opcion;
		System.out.println("================================");
		System.out.println("       Menu Arrendatario");
		System.out.println("================================");

		System.out.println("1.Arrendatario existente");
		System.out.println("2.Arrendatario nuevo");
		System.out.println("3.Atras");
		opcion = scannerService.pedirNumeroEntreRango("Opcion: ", "Opcion no valida, ingrese nuevamente..", 1, 3);

		MenuType[] menus = MenuType.values();
		return menus[opcion - 1];
	}

}
