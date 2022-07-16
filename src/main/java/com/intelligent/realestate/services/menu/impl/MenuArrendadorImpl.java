package com.intelligent.realestate.services.menu.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.TypeRealEstate;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.menu.MenuBuscarService;
import com.intelligent.realestate.services.menu.MenuService;

public class MenuArrendadorImpl implements MenuService {
	private ArrendadorDao arrendadorDao;
	private MenuBuscarService<Arrendador> menuBuscarArrendador;
	private ScannerService scannerService;

	private enum MenuType {
		BUSCAR_ARRENDADOR, CREAR_ARRENDADOR, SALIR
	};

	public MenuArrendadorImpl(ArrendadorDao arrendadorDao,
			MenuBuscarService<Arrendador> menuBuscarArrendador,
			ScannerService scannerService) {
		this.arrendadorDao = arrendadorDao;
		this.menuBuscarArrendador = menuBuscarArrendador;
		this.scannerService = scannerService;
	}

	@Override
	public void mostrarMenu() {
		while (true) {
			MenuType opcion = mostrarAndOptenerOpcion();

			switch (opcion) {
			case BUSCAR_ARRENDADOR:
				System.out.println("================================");
				Optional<Arrendador> arrendador = menuBuscarArrendador.buscarMenu();
				// TODO: verificar que no es null.
				break;
			case CREAR_ARRENDADOR:
				System.out.println("================================");
				System.out.println("Ok..Ingresemos tus datos.");
				arrendadorDao.insertArrendador(scannerService.pedirArrendador());
				break;
			case SALIR:
				return;
			}
		}
	}

	private MenuType mostrarAndOptenerOpcion() {
		int opcion;

		System.out.println("================================");
		System.out.println("        Menu Arrendador");
		System.out.println("================================");

		System.out.println("1. Arrendador existente");
		System.out.println("2. Arrendador nuevo");
		System.out.println("3. Salir de menu arrendador");
		opcion = scannerService.pedirNumeroEntreRango("Opcion: ", "Opcion no valida, ingrese nuevamente..", 1, 3);

		MenuType[] menus = MenuType.values();
		return menus[opcion - 1];
	}

	private int menuRealEstate() {

		TypeRealEstate[] type = TypeRealEstate.values(); // Crenado el arreglo que contenga las opciones que tiene el
															// enum
		System.out.println("================================");

		for (int i = 0; i < type.length; i++) {
			System.out.println((i + 1) + ") " + type[i]);
		}

		System.out.println("Que tipo de Real Estate deseas: ");
		int tipoRealEstate = scannerService.pedirNumeroEntreRango("", "Esa opcion no fue encontrada", 1, type.length);

		return tipoRealEstate;
	}

}