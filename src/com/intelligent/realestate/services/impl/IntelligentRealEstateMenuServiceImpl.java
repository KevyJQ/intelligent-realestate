package com.intelligent.realestate.services.impl;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Direccion;
import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.model.TypeRealEstate;
import com.intelligent.realestate.services.IntelligentRealEstateMenuService;
import com.intelligent.realestate.services.IntelligentRealEstateScannerService;

public class IntelligentRealEstateMenuServiceImpl implements IntelligentRealEstateMenuService {

	private IntelligentRealEstateScannerService scannerService;

	public IntelligentRealEstateMenuServiceImpl(IntelligentRealEstateScannerService scannerService) {
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

	@Override
	public void mostrarMenuPrincipal() {		
		System.out.println("---Bienvenido a mi sistema---");

		boolean exit = false;
		do {
			int opcion = mostrarAndObtenerOpciones();

			switch(opcion) {
			case 1:	//Propietario
				// Crear clase MenuArrendador que maneje todas las opciones del arrendador.
				System.out.println("\n\n\n\n\n\n");
				System.out.println("==================================================================");
				System.out.println("Menu Arrendador");
				System.out.println("==================================================================");

				Arrendador arrendador = new Arrendador();
				arrendador.setDireccion(new Direccion());
				arrendador.setRealEstate(new RealEstate());
				scannerService.pedirArrendador();	//Pedir los datos del arrendador
				//System.out.println(arrendador);	//Impresion del toString para hacer puebas

				menuSecundario();

				break;

			case 2:	//Inquilino
				// Crear clase MenuArrendatario que maneje todas las opciones del arrendatario.
				System.out.println("\n\n\n\n\n\n");
				System.out.println("==================================================================");
				System.out.println("Menu Arrendatario");
				System.out.println("==================================================================");

				Arrendatario arrendatario = new Arrendatario();
				arrendatario.setDireccion(new Direccion());

				scannerService.pedirArrendatario();
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














