package com.intelligent.realestate.main;

import com.intelligent.realestate.services.IntelligentRealEstateMenuService;
import com.intelligent.realestate.services.IntelligentRealEstateScannerService;
import com.intelligent.realestate.services.impl.IntelligentRealEstateMenuServiceImpl;
import com.intelligent.realestate.services.impl.IntelligentRealEstateScannerServiceImpl;

public class IntelligentRealEstateMain {

	public static void main(String[] args) {
		IntelligentRealEstateScannerService scannerService = new IntelligentRealEstateScannerServiceImpl();
		IntelligentRealEstateMenuService menuService = new IntelligentRealEstateMenuServiceImpl(scannerService);
		menuService.mostrarMenuPrincipal();
	}
}
