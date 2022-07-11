package com.intelligent.realestate.services.impl;

import java.sql.SQLException;
import java.util.Scanner;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.jdbc.ArrendadorDaoImpl;
import com.intelligent.realestate.jdbc.DbConnnection;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Direccion;
import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.model.TypeRealEstate;
import com.intelligent.realestate.services.IntelligentRealEstateMenuService;
import com.intelligent.realestate.services.IntelligentRealEstateScannerService;

public class IntelligentRealEstateMenuServiceImpl implements IntelligentRealEstateMenuService {

	private ArrendadorDao arrendadorDao;
	private ArrendatarioDao arrendatarioDao;
	private IntelligentRealEstateScannerService scannerService;

	public IntelligentRealEstateMenuServiceImpl(ArrendadorDao arrendadorDao,ArrendatarioDao arrendatarioDao, IntelligentRealEstateScannerService scannerService) {
		this.arrendadorDao = arrendadorDao;
		this.arrendatarioDao = arrendatarioDao;
		this.scannerService = scannerService;
	}

	private int mostrarAndObtenerOpciones() {
		int opcion;
		System.out.println("==================================================================");
		System.out.println("1. Menu Arrendador");
		System.out.println("2. Menu Arrendatario");
		System.out.println("3. Salir");
		System.out.print("Opcion: ");
		opcion = scannerService.pedirNumeroEntreRango("Dame el numero de opcion deseado entre 1-3", "El numero debe ser entre 1-3", 1, 3);

		return opcion;
	}

	private int menuSecundario() {	//Menu Agregar biene raices
		boolean Vali = true;
		do {
			System.out.println("==================================================================");
			System.out.println("1.Agregar nueva direccion\n2.Ver propiedades\n3.Atras\nOpcion: ");
			int opcSec = scannerService.pedirNumeroEntreRango("", "Esa opcion no existe", 1, 3);
			switch(opcSec) {
			case 1:
				boolean addRealEstate = true;
				while(addRealEstate) {
					menuRealEstate();
					scannerService.pedirDireccion();
					System.out.print("Deseas agregar otra propiedad?\n1.Si\n2.No\nOpcion: ");
					int exitAddRealEstate = scannerService.pedirNumeroEntreRango("", "Numero no valido", 1, 2);
					if(exitAddRealEstate == 2) {
						addRealEstate = false;
					}
				}
				break;
			case 2:
				System.out.println("__Que tipo de bienes raices deseas ver__");
				menuRealEstate();
				//Opcion pendiente para base de datos
				break;
			case 3:
				Vali = false;	//No quiere agregar una nueva direccion
				return 0;
			}
		}while(!Vali);

		return 0;
	}

	private int menuRealEstate() {

		TypeRealEstate[] type = TypeRealEstate.values(); 	//Crenado el arreglo que contenga las opciones que tiene el enum
		System.out.println("==================================================================");
		for(int i= 0 ; i < type.length ; i++) {
			System.out.println((i+1)+") "+type[i]);}
		System.out.println("Que tipo de Real Estate deseas: ");
		//System.out.println(type.length);
		int tipoRealEstate = scannerService.pedirNumeroEntreRango("", "Esa opcion no fue encontrada", 1, type.length);
		return tipoRealEstate;
	}

	private void menuArrendadorDao() throws SQLException {
		
		Arrendador arrendador = new Arrendador();
		
		int opcion;
		
		System.out.print("1.Arrendador existente\n2.Arrendador nuevo\nOpcion: ");
		opcion = scannerService.pedirNumeroEntreRango("", "Opcion no valida, ingrese nuevamente..", 1, 2);
		
		if(opcion == 1) {
			System.out.println("==================================================================");
			menuArrendador();
			menuSecundario();
		}else {	
			System.out.println("Ok..Ingresemos tus datos.");
			arrendadorDao.insertArrendador(scannerService.pedirArrendador());
			//			arrendador.setDireccion(new Direccion());
			//			arrendador.setRealEstate(new RealEstate());
			menuSecundario();
		}
	}

	public void menuArrendatarioDao() throws SQLException {

		Arrendatario arrendatario = new Arrendatario();

		System.out.print("1.Arrendatario existente\n2.Arrendatario nuevo\nOpcion: ");
		int opcion = scannerService.pedirNumeroEntreRango("", "Opcion no valida, ingrese nuevamente..", 1, 2);

		if(opcion == 1) {
			menuArrendatario();	//Buscar arrendatario
		}else {
			System.out.println("Bienvenido..Ingresemos tus datos.");
			arrendatarioDao.insertArrendatario(scannerService.pedirArrendatario());//Ingresar al nuevo arrendatario
			//arrendatario.setDireccion(new Direccion());
			//insert.insertArrendatario(arrendatario);
			menuRealEstate();
		}
	}

	public void menuArrendador() {

		System.out.print("1.Buscar por id\n2.buscar por Nombre y Apellido"+ "\nOpcion: ");
		int opcion = scannerService.pedirNumeroEntreRango("", "Opcion no encontrada, ingrese nuevamente..", 1, 2);

		switch(opcion) {
		case 1:
			System.out.print("Me puedes indicar cual es tu ID: ");
			long id =  scannerService.pedirNumero("", "Numero no valido, ingrese nuevamente..");

			arrendadorDao.findById(id);
			break;

		case 2:
			Scanner sc = new Scanner(System.in);
			System.out.print("Cual es tu nombre o primer nombre:");
			String nombre1 = sc.nextLine();
			System.out.print("Cual es tu apellido paterno:");
			String apellidoPaterno = sc.nextLine();
			System.out.print("Cual es tu apellido materno:");
			String apellidoMaterno = sc.nextLine();

			arrendadorDao.findByNameAndLasName(nombre1, apellidoMaterno, apellidoPaterno);
			break;
		}
	}

	public void menuArrendatario() {

		System.out.print("1.Buscar por id\n2.buscar por Nombre y Apellido"+ "\nOpcion: ");
		int opcion = scannerService.pedirNumeroEntreRango("", "Opcion no encontrada, ingrese nuevamente..", 1, 2);

		switch(opcion) {
		case 1:
			System.out.print("Me puedes indicar cual es tu ID: ");
			long id =  scannerService.pedirNumero("", "Numero no valido, ingrese nuevamente..");

			arrendatarioDao.findById(id);
			break;

		case 2:
			Scanner sc = new Scanner(System.in);
			System.out.print("Cual es tu nombre o primer nombre:");
			String nombre1 = sc.nextLine();
			System.out.print("Cual es tu apellido paterno:");
			String apellidoPaterno = sc.nextLine();
			System.out.print("Cual es tu apellido materno:");
			String apellidoMaterno = sc.nextLine();

			arrendatarioDao.findByNameAndLasName(nombre1, apellidoPaterno, apellidoMaterno);
			break;
		}
	}

	@Override
	public void mostrarMenuPrincipal() {		
		System.out.println("---Bienvenido a mi sistema---");

		boolean exit = false;
		do {
			int opcion = mostrarAndObtenerOpciones();

			switch(opcion) {
			case 1:	//Propietario
				// Crear clase MenuArrendador que maneje todas las opciones del arrendador.
				//System.out.println("\n\n\n\n\n\n");
				System.out.println("==================================================================");
				System.out.println("Menu Arrendador");
				System.out.println("==================================================================");
				try {
					menuArrendadorDao();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			case 2:	//Inquilino
				// Crear clase MenuArrendatario que maneje todas las opciones del arrendatario.
				//System.out.println("\n\n\n\n\n\n");
				System.out.println("==================================================================");
				System.out.println("Menu Arrendatario");
				System.out.println("==================================================================");
				try {
					menuArrendatarioDao();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//				Arrendatario arrendatario = new Arrendatario();
				//				arrendatario.setDireccion(new Direccion());
				//
				//				scannerService.pedirArrendatario();
				//				menuRealEstate();
				break;

			case 3:
				System.out.println("\n\tHasta luego, tenga un lindo dia.");
				exit = true;
				break;
			}
		} while (!exit);

	}
}














