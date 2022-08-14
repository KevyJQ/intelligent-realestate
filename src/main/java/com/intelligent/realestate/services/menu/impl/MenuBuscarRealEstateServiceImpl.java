package com.intelligent.realestate.services.menu.impl;

import java.util.List;
import java.util.Optional;

import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.model.RealEstateEstatus;
import com.intelligent.realestate.model.RealEstate;
//import com.intelligent.realestate.model.TypeRealEstate;
import com.intelligent.realestate.model.util.ModelPrintUtil;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.menu.MenuBuscarService;

public class MenuBuscarRealEstateServiceImpl implements MenuBuscarService<RealEstate> {

	private RealEstateDao realEstateDao;
	private ScannerService scannerService;

	private enum MenuType {
		BUSCAR_POR_PAIS_CIUDAD, CANCELAR
	};

	public MenuBuscarRealEstateServiceImpl(RealEstateDao realEstateDao, ScannerService scannerService) {
		this.realEstateDao = realEstateDao;
		this.scannerService = scannerService;
	}

	@Override
	public Optional<RealEstate> buscarMenu() {
		Optional<RealEstate> realestate = Optional.empty();

		while (true) {

			MenuType opcion = mostrarAndOptenerOpcion();

			switch (opcion) {
			case BUSCAR_POR_PAIS_CIUDAD:
				realestate = buscarPorPaisAndCiudad();
				break;

			case CANCELAR:
				return Optional.empty();
			}

			if (realestate.isPresent()) {
				return realestate;
			} else {
				System.out.println("\nNo se encontraron real estates con el criterio seleccionado.\n");
			}
		}

	}

	private Optional<RealEstate> buscarPorPaisAndCiudad() {
		int id;
		String pais = scannerService.pedirString("Dame el Pais: ", "Error, ingrese nuevamente..");
		String ciudad = scannerService.pedirString("Dame la ciudad: ", "Error ingrese nuevamente..");
		String status = selecionarEstatus().name();
//		TypeRealEstate typeRE = typeRealEstate();
//		System.out.println("typeRE: " + typeRE);

		List<RealEstate> realest = realEstateDao.selectRealEstate(pais, ciudad, status);

		if (realest.isEmpty()) {
			return Optional.empty();
		} else if (realest.size() > 1) {
			id = selectRealEstate(realest);
			RealEstate realE = realest.get(id);

			return Optional.of(realE);
		}

		return Optional.of(realest.get(0));
	}

	private int selectRealEstate(List<RealEstate> realestate) {
		int id = 0;

		System.out.println("================================");
		System.out.println("      Lista de Real estates     ");
		System.out.println("================================");

		for (int i = 0; i < realestate.size(); i++) {
			System.out.println("---- Real Estate " + (i + 1) + " ----");
			ModelPrintUtil.printMultiRealEstates(realestate.get(i));
		}
		id = scannerService.pedirNumeroEntreRango("Que Real Estate deseas rentar:", "Real Estate no valido..", 1,
				realestate.size());
		return id - 1;
	}

	private MenuType mostrarAndOptenerOpcion() {
		int opcion;

		System.out.println("================================");
		System.out.println("        Menu Real Estate        ");
		System.out.println("================================");

		System.out.println("1.Buscar por Pais y Ciudad");
		System.out.println("2.Cancelar");
		opcion = scannerService.pedirNumeroEntreRango("Opcion: ", "Opcion no encontrada, ingrese nuevamente..", 1, 2);

		MenuType[] menus = MenuType.values();
		return menus[opcion - 1];
	}

//	private TypeRealEstate typeRealEstate() {
//		int opcion;
//
//		System.out.println("================================");
//		System.out.println("       Tipos de Real Estate     ");
//		System.out.println("================================");
//
//		System.out.println("1. Casa");
//		System.out.println("2. Departamento");
//		System.out.println("3. Terreno");
//		System.out.println("4. Oficina");
//		opcion = scannerService.pedirNumeroEntreRango("Opcion: ", "Opcion no valida, ingrese nuevamente..", 1, 4);
//
//		TypeRealEstate[] tyRE = TypeRealEstate.values();
//		return tyRE[opcion - 1];
//	}

	private RealEstateEstatus selecionarEstatus() {
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
