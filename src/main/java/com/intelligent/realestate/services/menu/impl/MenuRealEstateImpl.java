//package com.intelligent.realestate.services.menu.impl;
//
//import java.util.Optional;
//
//import com.intelligent.realestate.dao.RealEstateDao;
//import com.intelligent.realestate.model.RealEstate;
//import com.intelligent.realestate.services.ScannerService;
//import com.intelligent.realestate.services.menu.MenuBuscarService;
//import com.intelligent.realestate.services.menu.MenuService;
//
//public class MenuRealEstateImpl implements MenuService{
//	private MenuBuscarService<RealEstate> menuBuscarRelaEstate;
//	private RealEstateDao realEstateDao;
//	private ScannerService scannerService;
//
//	private enum MenuType {
//		BUSCAR_REAL_ESTATE, SALIR
//	};
//	
//	public MenuRealEstateImpl(RealEstateDao realEstateDao,ScannerService scannerService) {
//		this.scannerService = scannerService;
//		this.realEstateDao = realEstateDao;
//	}
//	
//	@Override
//	public void mostrarMenu() {
//		Optional<RealEstate> realestate;
//		
//		MenuType opcion = mostrarAndOptenerOpcion();
//		
//		switch (opcion) {
//		case BUSCAR_REAL_ESTATE:
//			realestate = menuBuscarRelaEstate.buscarMenu();
//			
//			break;
//		case SALIR:
//			return;
//			
//			
//		}
//	}
//
//	private MenuType mostrarAndOptenerOpcion() {
//		int opcion;
//
//		System.out.println("================================");
//		System.out.println("         Menu Real Estate       ");
//		System.out.println("================================");
//
//		System.out.println("1.Buscar por Pais y Ciudad");
//		System.out.println("6.Cancelar");
//		opcion = scannerService.pedirNumeroEntreRango("Opcion: ", "Opcion no encontrada, ingrese nuevamente..", 1, 2);
//
//		MenuType[] menus = MenuType.values();
//		return menus[opcion - 1];
//	}
//}
