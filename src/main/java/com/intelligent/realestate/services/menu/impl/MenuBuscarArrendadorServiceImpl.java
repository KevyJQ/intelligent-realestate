package com.intelligent.realestate.services.menu.impl;

import java.util.List;
import java.util.Optional;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.services.ImpresionService;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.menu.MenuBuscarService;

public class MenuBuscarArrendadorServiceImpl implements MenuBuscarService<Arrendador> {
	private ArrendadorDao arrendadorDao;
	private ScannerService scannerService;
	private ImpresionService impresionArrendador;

	private enum MenuType {
		BUSCAR_POR_ID, BUSCAR_POR_NOMBRE_Y_APELLIDO, CANCELAR
	};

	public MenuBuscarArrendadorServiceImpl(ArrendadorDao arrendadorDao, ScannerService scannerService,
			ImpresionService impresionArrendador) {
		this.arrendadorDao = arrendadorDao;
		this.scannerService = scannerService;
		this.impresionArrendador = impresionArrendador;
	}

	@Override
	public Optional<Arrendador> buscarMenu() {
		Optional<Arrendador> arrendador = Optional.empty();

		while (true) {
			MenuType opcion = mostrarAndOptenerOpcion();

			switch (opcion) {
			case BUSCAR_POR_ID:
				arrendador = buscarPorId();
				Arrendador arren = arrendador.get();
				impresionArrendador.imprimirArrendador(arren);
				break;

			case BUSCAR_POR_NOMBRE_Y_APELLIDO:
				arrendador = buscarPorNombreAndApellido();
				Arrendador arren1 = arrendador.get();
				impresionArrendador.imprimirArrendador(arren1);
				break;

			case CANCELAR:
				return Optional.empty();
			}

			if (arrendador.isPresent()) {
				return arrendador;
			} else {
				System.out.println("Arrendador no encontrado!!");
			}
		}
	}

	// --Buscara por ID al Arrendador
	private Optional<Arrendador> buscarPorId() {
		long id = scannerService.pedirNumero("Me puedes indicar cual es tu ID: ",
				"Numero no valido, ingrese nuevamente..");

		return Optional.ofNullable(arrendadorDao.findById(id));
	}

	// Buscara por Su primero nombre y Apellidos
	private Optional<Arrendador> buscarPorNombreAndApellido() {
		int ID;
		String nombre1 = scannerService.pedirString("Cual es tu nombre o primer nombre:",
				"Proporciona el nombre por favor");
		String apellidoPaterno = scannerService.pedirString("Cual es tu apellido paterno:",
				"Proporciona apellido paterno por favor");
		String apellidoMaterno = scannerService.pedirString("Cual es tu apellido materno:",
				"Proporciona apellido materno por favor");

		List<Arrendador> arrendadores = arrendadorDao.findByNameAndLasName(nombre1, apellidoMaterno, apellidoPaterno);

		if (arrendadores.isEmpty()) {
			return Optional.empty();

		}else if(arrendadores.size() > 1) {
			ID = Selectrrendador(arrendadores);
			Arrendador arrenda = arrendadores.get(ID);
			return Optional.of(arrenda);
		}

		return Optional.of(arrendadores.get(0));
	}

	private MenuType mostrarAndOptenerOpcion() {
		int opcion;

		System.out.println("================================");
		System.out.println("        Buscar Arrendador");
		System.out.println("================================");

		System.out.println("1. Buscar por ID");
		System.out.println("2. Buscar por Nombre y Apellido");
		System.out.println("3. Cancelar");
		opcion = scannerService.pedirNumeroEntreRango("Opcion", "Opcion no encontrada, ingrese nuevamente..", 1, 3);

		MenuType[] menus = MenuType.values();
		return menus[opcion - 1];
	}

	private int Selectrrendador(List<Arrendador> arrendador) {
		int ID = 0;

		System.out.println("================================");
		System.out.println("      Que Arrendador eres     ");
		System.out.println("================================");

		for (int i = 0; i < arrendador.size(); i++) {
			System.out.println("---- Arrendador " + (i + 1) + " ----");
			impresionArrendador.printMultiArrendadores(arrendador.get(i));
		}
		System.out.println("Si no eres ninguno de los anteriores teclear 0");
		ID = scannerService.pedirNumeroEntreRango("Que arrendador eres:", "Arrendatario no valido..", 1,
				arrendador.size());

		return ID - 1;

	}
}
