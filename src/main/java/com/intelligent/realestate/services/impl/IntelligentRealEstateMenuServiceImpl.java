package com.intelligent.realestate.services.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.ArrendatarioDao;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.TypeRealEstate;
import com.intelligent.realestate.services.IntelligentRealEstateMenuService;
import com.intelligent.realestate.services.IntelligentRealEstateScannerService;

public class IntelligentRealEstateMenuServiceImpl implements IntelligentRealEstateMenuService {

	private ArrendadorDao arrendadorDao;
	private ArrendatarioDao arrendatarioDao;
	private IntelligentRealEstateScannerService scannerService;

	public IntelligentRealEstateMenuServiceImpl(ArrendadorDao arrendadorDao, ArrendatarioDao arrendatarioDao,
			IntelligentRealEstateScannerService scannerService) {
		this.arrendadorDao = arrendadorDao;
		this.arrendatarioDao = arrendatarioDao;
		this.scannerService = scannerService;
	}

	private int mostrarAndObtenerOpciones() {
		int opcion;
		System.out.println("================================");
		System.out.println("1. Menu Arrendador");
		System.out.println("2. Menu Arrendatario");
		System.out.println("3. Salir");
		System.out.print("Opcion: ");
		opcion = scannerService.pedirNumeroEntreRango("Dame el numero de opcion deseado entre 1-3",
				"El numero debe ser entre 1-3", 1, 3);

		return opcion;
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

	private int menuArrendadorDao() throws SQLException {

		int opcion;

		System.out.print("1.Arrendador existente\n2.Arrendador nuevo\n3.Atras\nOpcion: ");
		opcion = scannerService.pedirNumeroEntreRango("", "Opcion no valida, ingrese nuevamente..", 1, 3);

		if (opcion == 1) {
			System.out.println("================================");
			menuArrendador(); // Ya trae los datos guardados de arrendador
			menuSecundario();
		} else if (opcion == 2) {
			System.out.println("================================");
			System.out.println("Ok..Ingresemos tus datos.");
			arrendadorDao.insertArrendador(scannerService.pedirArrendador());
			menuSecundario();
		} else {
			mostrarMenuPrincipal();
		}
		return opcion;
	}

	public void menuArrendatarioDao() throws SQLException {

		System.out.print("1.Arrendatario existente\n2.Arrendatario nuevo\n3.Atras\nOpcion: ");
		int opcion = scannerService.pedirNumeroEntreRango("", "Opcion no valida, ingrese nuevamente..", 1, 3);

		if (opcion == 1) {
			System.out.println("================================");
			menuArrendatario(); // Buscar arrendatario
		} else if (opcion == 2) {
			System.out.println("================================");
			System.out.println("Bienvenido..Ingresemos tus datos.");
			arrendatarioDao.insertArrendatario(scannerService.pedirArrendatario());// Ingresar al nuevo arrendatario
			// insert.insertArrendatario(arrendatario);
			menuRealEstate();
		} else {
			mostrarMenuPrincipal();
		}
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
						mostrarMenuPrincipal();
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
						mostrarMenuPrincipal();
						loop2 = false;
					}
				} else {
					loop2 = false;
				}
			}
			break;
		}
	}

	public void menuArrendatario() throws SQLException {

		System.out.print("1.Buscar por id\n2.buscar por Nombre y Apellido" + "\nOpcion: ");
		int opcion = scannerService.pedirNumeroEntreRango("", "Opcion no encontrada, ingrese nuevamente..", 1, 2);

		switch (opcion) {
		case 1:
			boolean loop = true;
			while (loop) {
				System.out.print("Me puedes indicar cual es tu ID: ");
				long id = scannerService.pedirNumero("", "Numero no valido, ingrese nuevamente..");

				if (arrendatarioDao.findById(id) == null) {
					System.out.println("Usuario no encontrado..");
					System.out.print("Desea volver a intentar..\n1.Si\n2.No\nOpcion:");
					int opcion1 = scannerService.pedirNumeroEntreRango("", "Opcion no valida", 1, 2);

					if (opcion1 == 2) {
						menuArrendatarioDao();
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

				List<Arrendatario> arrendatarios = arrendatarioDao.findByNameAndLasName(nombre1, apellidoMaterno,
						apellidoPaterno);
				if (arrendatarios.isEmpty()) {
					System.out.println("Arrendatario no encontrado..");
					System.out.print("Desea volver a intentar..\n1.Si\n2.No\nOpcion:");
					int opcion1 = scannerService.pedirNumeroEntreRango("", "Opcion no valida", 1, 2);
					if (opcion1 == 2) {
						menuArrendatarioDao();
						loop2 = false;
					}
				} else {
					loop2 = false;
				}
			}
			break;
		}
	}

	@Override
	public void mostrarMenuPrincipal() throws SQLException {
		System.out.println("================================");
		System.out.println("---Bienvenido a mi sistema---");

		boolean exit = false;
		do {
			int opcion = mostrarAndObtenerOpciones(); // Nos regresara la opcion que deseamos

			switch (opcion) {
			case 1: // Propietario

				// Arrendador arrendador = new Arrendador(); //--------------Creacion del objeto
				// Arrendador

				System.out.println("================================");
				System.out.println("Menu Arrendador");
				System.out.println("================================");

				menuArrendadorDao();

				break;

			case 2: // Inquilino
				// Crear clase MenuArrendatario que maneje todas las opciones del arrendatario.
				System.out.println("================================");
				System.out.println("Menu Arrendatario");
				System.out.println("================================");
				try {
					menuArrendatarioDao();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				// scannerService.pedirArrendatario();
				menuRealEstate();
				break;

			case 3:
				System.out.println("\n\tHasta luego, tenga un lindo dia.");
				exit = true;
				break;
			}
		} while (!exit);

	}
}
