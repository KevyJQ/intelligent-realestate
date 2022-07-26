package com.intelligent.realestate.services.menu.impl;

import java.util.List;
import java.util.Optional;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.util.ModelPrintUtil;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.menu.MenuBuscarService;

public class MenuBuscarArrendatarioServiceImpl implements MenuBuscarService<Arrendatario> {
	private ArrendatarioDao arrendatarioDao;
	private ScannerService scannerService;

	private enum MenuType {
		BUSCAR_POR_ID, BUSCAR_POR_NOMBRE_Y_APELLIDOS, CANCELAR
	};

	public MenuBuscarArrendatarioServiceImpl(ArrendatarioDao arrendatarioDao, ScannerService scannerService) {
		this.arrendatarioDao = arrendatarioDao;
		this.scannerService = scannerService;
	}

	@Override
	public Optional<Arrendatario> buscarMenu() {
		Optional<Arrendatario> arrendatario = Optional.empty();

		while (true) {
			MenuType opcion = mostrarAndOptenerOpcion();

			switch (opcion) {
			case BUSCAR_POR_ID:
				arrendatario = buscarPorId();
				if (arrendatario.isPresent()) {
					Arrendatario arrendata = arrendatario.get();
					ModelPrintUtil.imprimirArrendatario(arrendata);
				}
				break;

			case BUSCAR_POR_NOMBRE_Y_APELLIDOS:
				arrendatario = buscarPorNombreAndApellido();
				if (arrendatario.isPresent()) {
					Arrendatario arrendata1 = arrendatario.get();
					ModelPrintUtil.imprimirArrendatario(arrendata1);
				}
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

	private Optional<Arrendatario> buscarPorNombreAndApellido() {
		int ID;

		String nombre1 = scannerService.pedirString("Cual es tu primer nombre: ", "Proporcional el nombre por favor");
		String apellidoPaterno = scannerService.pedirString("Cual es tu apellido Paterno: ",
				"Proporcional el Apellido Paterno por favor");
		String apellidoMaterno = scannerService.pedirString("Cual es tu apellido Materno: ",
				"Proporcional el Apellido Materno por favor");

		List<Arrendatario> arrendatarios = arrendatarioDao.findByNameAndLasName(nombre1, apellidoMaterno,
				apellidoPaterno);
		if (arrendatarios.isEmpty()) {
			return Optional.empty();

		} else if (arrendatarios.size() > 1) {
			ID = Selectrrendatario(arrendatarios);
			Arrendatario arrendata1 = arrendatarios.get(ID);
			return Optional.of(arrendata1);
		}
		return Optional.of(arrendatarios.get(0));
	}

	private int Selectrrendatario(List<Arrendatario> arrendatarios) {
		int ID = 0;

		System.out.println("================================");
		System.out.println("      Que Arrendatario eres     ");
		System.out.println("================================");

		for (int i = 0; i < arrendatarios.size(); i++) {
			System.out.println("---- Arrendatario " + (i + 1) + " ----");
			ModelPrintUtil.printMultiArrendatarios(arrendatarios.get(i));
		}
		ID = scannerService.pedirNumeroEntreRango("Que arrendatario eres:", "Arrendatario no valido..", 1,
				arrendatarios.size());
		return ID - 1;

	}
}
