package com.intelligent.realestate.services.menu.impl;

import java.util.Optional;
import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.RealEstateEstatus;
import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.model.TypeRealEstate;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.menu.MenuBuscarService;
import com.intelligent.realestate.services.menu.MenuService;

public class MenuArrendadorImpl implements MenuService {
	private ArrendadorDao arrendadorDao;
	private MenuBuscarService<Arrendador> menuBuscarArrendador;
	private ScannerService scannerService;
	private RealEstateDao realEstateDao;

	private enum MenuType {
		BUSCAR_ARRENDADOR, CREAR_ARRENDADOR, AGREGAR_REAL_ESTATE, SALIR
	};

	public MenuArrendadorImpl(ArrendadorDao arrendadorDao, RealEstateDao realEstateDao,
			MenuBuscarService<Arrendador> menuBuscarArrendador, ScannerService scannerService) {
		this.arrendadorDao = arrendadorDao;
		this.realEstateDao = realEstateDao;
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
				arrendador = menuBuscarArrendador.buscarMenu();
				break;

			case CREAR_ARRENDADOR:
				System.out.println("==========================");
				System.out.println("   Ingresemos tus datos.  ");
				System.out.println("==========================");
				arrendadorDao.guardarArrendador(scannerService.pedirArrendador());
				break;

			case AGREGAR_REAL_ESTATE:
				arrendador = menuBuscarArrendador.buscarMenu();
				if (arrendador.isPresent()) {

					Arrendador arrendado = arrendador.get();
					RealEstate realestate = new RealEstate();

					realestate.setArrendadadorId(arrendado.getIdArrendador());
					realestate.setRealEstateType(typeRealEstate());
					realestate.setEstatus(seleccionaEstatus());
					realestate.setDireccion(scannerService.pedirDireccion());

					realestate.setCostoMin(scannerService.pedirDouble("Precio Minimo:", "Necesito un numero.."));
					realestate.setCostoMax(scannerService.pedirDouble("Precio Maximo:", "Necesito un numero.."));

					arrendado.setRealEstate(realestate);
					realEstateDao.insertRealEstate(realestate);
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

	private TypeRealEstate typeRealEstate() {
		int opcion;

		System.out.println("================================");
		System.out.println("       Tipos de Real Estate     ");
		System.out.println("================================");

		System.out.println("1. Casa");
		System.out.println("2. Departamento");
		System.out.println("3. Terreno");
		System.out.println("4. Oficina");
		opcion = scannerService.pedirNumeroEntreRango("Opcion: ", "Opcion no valida, ingrese nuevamente..", 1, 4);

		TypeRealEstate[] tyRE = TypeRealEstate.values();
		return tyRE[opcion - 1];
	}

	private RealEstateEstatus seleccionaEstatus() {
		int opcion;

		System.out.println("================================");
		System.out.println("             Estatus            ");
		System.out.println("================================");

		System.out.println("1. Disponible");
		System.out.println("2. En renta");
		System.out.println("3. No disponible");
		opcion = scannerService.pedirNumeroEntreRango("Opcion: ", "Opcion no valida, ingrese nuevamente..", 1, 4);

		RealEstateEstatus[] statu = RealEstateEstatus.values();
		return statu[opcion - 1];
	}

}