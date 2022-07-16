package com.intelligent.realestate.services.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.TypeRealEstate;
import com.intelligent.realestate.services.MenuService;
import com.intelligent.realestate.services.ScannerService;

public class MenuArrendadorImpl implements MenuService {
	private ArrendadorDao arrendadorDao;
	private ScannerService scannerService;

	private enum MenuType {
		BUSCAR_ARRENDADOR, CREAR_ARRENDADOR, SALIR
	};

	public MenuArrendadorImpl(ArrendadorDao arrendadorDao, ScannerService scannerService) {
		this.arrendadorDao = arrendadorDao;
		this.scannerService = scannerService;
	}

	@Override
	public void mostrarMenu() {
		System.out.println("================================");
		System.out.println("Menu Arrendador");
		System.out.println("================================");

		while (true) {
			MenuType opcion = mostrarAndOptenerOpcion();

			switch (opcion) {
			case BUSCAR_ARRENDADOR:
				System.out.println("================================");
				// menuArrendador(); // Ya trae los datos guardados de arrendador
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

		System.out.println("1. Arrendador existente");
		System.out.println("2. Arrendador nuevo");
		System.out.println("3. Salir de menu arrendador");
		opcion = scannerService.pedirNumeroEntreRango("Opcion: ", "Opcion no valida, ingrese nuevamente..", 1, 3);

		MenuType[] menus = MenuType.values();
		return menus[opcion - 1];
	}

	public void menuArrendador() throws SQLException {

		System.out.print("1.Buscar por id\n2.buscar por Nombre y Apellido" + "\nOpcion: ");
		int opcion = scannerService.pedirNumeroEntreRango("", "Opcion no encontrada, ingrese nuevamente..", 1, 2);

		switch (opcion) {
		case 1:
			boolean loop = true;
			while (loop) {
				long id;
				System.out.print("Me puedes indicar cual es tu ID: ");
				id = scannerService.pedirNumero("", "Numero no valido, ingrese nuevamente..");

				if (arrendadorDao.findById(id) == null) {
					System.out.println("Usuario no encontrado..");
					System.out.print("Desea volver a intentar..\n1.Si\n2.No\nOpcion:");
					int opcion1 = scannerService.pedirNumeroEntreRango("", "Opcion no valida", 1, 2);

					if (opcion1 == 2) {
						mostrarMenu();
						loop = false;
					}
				}
				loop = false;
			}
			break;

		case 2:
			boolean loop2 = true;
			while (loop2) {

				Scanner sc = new Scanner(System.in);
				System.out.print("Cual es tu nombre o primer nombre:");
				String nombre1 = sc.nextLine();
				System.out.print("Cual es tu apellido paterno:");
				String apellidoPaterno = sc.nextLine();
				System.out.print("Cual es tu apellido materno:");
				String apellidoMaterno = sc.nextLine();

				List<Arrendador> arrendadores = arrendadorDao.findByNameAndLasName(nombre1, apellidoMaterno,
						apellidoPaterno);
				if (arrendadores.isEmpty()) {
					System.out.println("Usuario no encontrado..");
					System.out.print("Desea volver a intentar..\n1.Si\n2.No\nOpcion:");
					int opcion1 = scannerService.pedirNumeroEntreRango("", "Opcion no valida", 1, 2);

					if (opcion1 == 2) {
						mostrarMenu();
						loop2 = false;
					}
				} else {
					loop2 = false;
				}
			}
			break;
		}
	}

	private int menuSecundario() {

		boolean Vali = true;
		do {
			System.out.println("================================");
			System.out.print("1.Agregar nueva direccion\n2.Ver propiedades\n3.Atras\nOpcion: ");

			int opcSec = scannerService.pedirNumeroEntreRango("", "Esa opcion no existe", 1, 3);
			switch (opcSec) {

			case 1:
				boolean addRealEstate = true;
				while (addRealEstate) {
					int typeRE = menuRealEstate();
					// scannerService.pedirDireccion();
					arrendadorDao.insertRealEstate(typeRE);
					System.out.print("Deseas agregar otra propiedad?\n1.Si\n2.No\nOpcion: ");
					int exitAddRealEstate = scannerService.pedirNumeroEntreRango("", "Numero no valido", 1, 2);
					if (exitAddRealEstate == 2) {
						addRealEstate = false;
					}
				}
				break;

			case 2:
				System.out.println("__Que tipo de bienes raices deseas ver__");
				menuRealEstate();
				// Agredar los select
				break;

			case 3:
				Vali = false; // No quiere agregar una nueva direccion
				return 0;
			}
		} while (!Vali);
		return 0;
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