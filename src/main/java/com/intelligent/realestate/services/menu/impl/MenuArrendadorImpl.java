package com.intelligent.realestate.services.menu.impl;

import java.util.Optional;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Direccion;
import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.model.TypeRealEstate;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.menu.MenuBuscarService;
import com.intelligent.realestate.services.menu.MenuService;

public class MenuArrendadorImpl implements MenuService {
	private ArrendadorDao arrendadorDao;
	private MenuBuscarService<Arrendador> menuBuscarArrendador;
	private ScannerService scannerService;

	private enum MenuType {
		BUSCAR_ARRENDADOR, CREAR_ARRENDADOR, AGREGAR_REAL_ESTATE, SALIR
	};

	public MenuArrendadorImpl(ArrendadorDao arrendadorDao, MenuBuscarService<Arrendador> menuBuscarArrendador,
			ScannerService scannerService) {
		this.arrendadorDao = arrendadorDao;
		this.menuBuscarArrendador = menuBuscarArrendador;
		this.scannerService = scannerService;
	}

	@Override
	public void mostrarMenu() {
		while (true) {
			Optional<Arrendador> arrendador;
			MenuType opcion = mostrarAndOptenerOpcion();

			switch (opcion) {
			case BUSCAR_ARRENDADOR:
				System.out.println("================================");
				arrendador = menuBuscarArrendador.buscarMenu();
				if (arrendador.isPresent()) {
					// TODO create una clase PrintModels que va a tener el metodo printArredador(Arrendador);
					System.out.println("Arrendador : " + arrendador);
				}
				break;
			case CREAR_ARRENDADOR:
				System.out.println("================================");
				System.out.println("Ok..Ingresemos tus datos.");
				arrendadorDao.insertArrendador(scannerService.pedirArrendador());
				break;
			case AGREGAR_REAL_ESTATE:
				arrendador = menuBuscarArrendador.buscarMenu();
				if (arrendador.isPresent()) {
					// TODO crear metodo para llenar real estate
					Arrendador arr = arrendador.get();
					RealEstate re = new RealEstate();

					Direccion direccion = new Direccion();
					direccion.setCiudad("Rentar Ciudad");
					direccion.setEstado("Rentar Estado");
					direccion.setDireccion1("Rentar direccion 1");
					direccion.setDireccion2("Rentar direccion 2");
					direccion.setCodigoPostal("Rentar cp");
					direccion.setPais("Rentar Pais");
					
					re.setDireccion(direccion);
					re.setRealEstateType(TypeRealEstate.DEPARTAMENTO);
					
					arr.setRealEstate(re);
					
					System.out.println("Arrendador : " + arrendador);
					System.out.println("Insertando real estate..");
					arrendadorDao.insertRealEstate(arr);
				}
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

		System.out.println("1. Buscar Arrendador");
		System.out.println("2. Arrendador nuevo");
		System.out.println("3. Agregar real estate a arrendador");
		System.out.println("4. Salir de menu arrendador");
		opcion = scannerService.pedirNumeroEntreRango("Opcion: ", "Opcion no valida, ingrese nuevamente..", 1, 4);

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