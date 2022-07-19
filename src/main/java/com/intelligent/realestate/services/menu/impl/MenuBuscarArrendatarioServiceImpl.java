package com.intelligent.realestate.services.menu.impl;

import java.util.List;
import java.util.Optional;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.services.ImpresionService;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.menu.MenuBuscarService;

public class MenuBuscarArrendatarioServiceImpl implements MenuBuscarService<Arrendatario> {
	private ArrendatarioDao arrendatarioDao;
	private ScannerService scannerService;
	private ImpresionService impresionArrendatario;

	private enum MenuType {
		BUSCAR_POR_ID, BUSCAR_POR_NOMBRE_Y_APELLIDOS, CANCELAR
	};

	public MenuBuscarArrendatarioServiceImpl(ArrendatarioDao arrendatarioDao, ScannerService scannerService,
			ImpresionService impresionArrendatario) {
		this.arrendatarioDao = arrendatarioDao;
		this.scannerService = scannerService;
		this.impresionArrendatario = impresionArrendatario;
	}

	@Override
	public Optional<Arrendatario> buscarMenu() {
		Optional<Arrendatario> arrendatario = Optional.empty();

		while (true) {
			MenuType opcion = mostrarAndOptenerOpcion();

			switch (opcion) {
			case BUSCAR_POR_ID:
				arrendatario = buscarPorId();
				Arrendatario arrendata = arrendatario.get();
				impresionArrendatario.imprimirArrendatario(arrendata);
				break;
			case BUSCAR_POR_NOMBRE_Y_APELLIDOS:
				arrendatario = buscarPorNombreAndApellido();
				Arrendatario arrendata1 = arrendatario.get();
				impresionArrendatario.imprimirArrendatario(arrendata1);
				break;
			case CANCELAR:
				return Optional.empty();
			}
			if (arrendatario.isPresent()) {
				return arrendatario;
			} else {
				System.out.println("Arrendatario no encontrado!!");
			}
		}
	}

	private Optional<Arrendatario> buscarPorId() {
		long id = scannerService.pedirNumero("Me puedes indicar cual es tu ID: ",
				"Numero no valido, ingrese nuevamente..");
		return Optional.ofNullable(arrendatarioDao.findById(id));
	}

	private Optional<Arrendatario> buscarPorNombreAndApellido() {
		String nombre1 = scannerService.pedirString("Cual es tu primer nombre: ", "Proporcional el nombre por favor");
		String apellidoPaterno = scannerService.pedirString("Cual es tu primer nombre: ",
				"Proporcional el Apellido Paterno por favor");
		String apellidoMaterno = scannerService.pedirString("Cual es tu primer nombre: ",
				"Proporcional el Apellido Materno por favor");

		List<Arrendatario> arrendatarios = arrendatarioDao.findByNameAndLasName(nombre1, apellidoMaterno,
				apellidoPaterno);
		if (arrendatarios.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(arrendatarios.get(0));
	}

	private MenuType mostrarAndOptenerOpcion() {
		int opcion;

		System.out.println("================================");
		System.out.println("       Menu Arrendatario");
		System.out.println("================================");

		System.out.println("1.Buscar por ID");
		System.out.println("2.buscar por Nombre y Apellidos");
		System.out.println("3.Cancelar");
		opcion = scannerService.pedirNumeroEntreRango("Opcion: ", "Opcion no encontrada, ingrese nuevamente..", 1, 3);

		MenuType[] menus = MenuType.values();
		return menus[opcion - 1];
	}

//	private int menuRealEstate() {
//
//		TypeRealEstate[] type = TypeRealEstate.values(); // Crenado el arreglo que contenga las opciones que tiene el
//		// enum
//		System.out.println("================================");
//
//		for (int i = 0; i < type.length; i++) {
//			System.out.println((i + 1) + ") " + type[i]);
//		}
//
//		System.out.println("Que tipo de Real Estate deseas: ");
//		int tipoRealEstate = scannerService.pedirNumeroEntreRango("", "Esa opcion no fue encontrada", 1, type.length);
//
//		return tipoRealEstate;
//	}

}
