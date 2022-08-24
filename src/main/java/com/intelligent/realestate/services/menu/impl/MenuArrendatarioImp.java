package com.intelligent.realestate.services.menu.impl;

import java.util.GregorianCalendar;
import java.util.Optional;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.dao.ContratoDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Contrato;
import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.model.util.ModelPrintUtil;
import com.intelligent.realestate.services.ScannerService;
import com.intelligent.realestate.services.menu.MenuBuscarService;
import com.intelligent.realestate.services.menu.MenuService;

public class MenuArrendatarioImp implements MenuService {
	private ArrendatarioDao arrendatarioDao;
	private MenuBuscarService<Arrendatario> menuBuscarArrendatarios;
	private MenuBuscarService<RealEstate> menuBuscarRealEstate;
	private ContratoDao contratoDao;
	private ScannerService scannerService;

	private enum MenuType {
		BUSCAR_ARRENDATARIO, CREAR_ARRENDATARIO, CREAR_CONTRATO, SALIR
	};

	public MenuArrendatarioImp(ArrendatarioDao arrendatarioDao, MenuBuscarService<Arrendatario> menuBuscarArrendatario,
			MenuBuscarService<RealEstate> meBuscarRealEstate, ContratoDao contratoDao, ScannerService scannerService) {
		this.arrendatarioDao = arrendatarioDao;
		this.menuBuscarArrendatarios = menuBuscarArrendatario;
		this.menuBuscarRealEstate = meBuscarRealEstate;
		this.scannerService = scannerService;
		this.contratoDao = contratoDao;
	}

	@Override
	public void mostrarMenu() {
		while (true) {
			Optional<Arrendatario> arrendatario;
			Optional<RealEstate> realestate;
			MenuType opcion = mostrarAndOptenerOpcion();

			switch (opcion) {
			case BUSCAR_ARRENDATARIO:
				arrendatario = menuBuscarArrendatarios.buscarMenu();
				break;

			case CREAR_ARRENDATARIO:
				System.out.println("==========================");
				System.out.println("   Ingresemos tus datos.  ");
				System.out.println("==========================");
				arrendatarioDao.insertArrendatario(scannerService.pedirArrendatario());
				break;

			case CREAR_CONTRATO:
				realestate = menuBuscarRealEstate.buscarMenu();
				if (realestate.isPresent()) {
					System.out.println("Real estate seleccionado: ");
					ModelPrintUtil.printMultiRealEstates(realestate.get());
					arrendatario = menuBuscarArrendatarios.buscarMenu();
					if (arrendatario.isPresent()) {
						RealEstate realest = realestate.get(); // Objeto Real Estate
						Arrendatario arrendata = arrendatario.get(); // Objeto arrendatario
						Arrendador arrendador = new Arrendador();
						arrendador.setIdArrendador(realest.getArrendadadorId());
						Contrato contrato = new Contrato();
						contrato.setArrendador(arrendador);
						contrato.setArrendatario(arrendata);
						contrato.setRealEstate(realest);
						// TODO: Pedir las fechas al usuario.
						GregorianCalendar fechaInicio = new GregorianCalendar(2022, 8, 10);
						contrato.setFechaInicio(fechaInicio.getTime());
						GregorianCalendar fechaFinal = new GregorianCalendar(2023, 8, 10);
						contrato.setFechaFinal(fechaFinal.getTime());

						if (decision(realest) == true) {
							contratoDao.guardarContrato(contrato);
							System.out.println("..Contrato generado Exitosamente..");
							System.out.println("\n\tID del Contrato: " + contrato.getIdContrato() + "\n");
						} else {
							System.out.println("Lo siento, no le es posible rentar esta propiedad");
						}
					}
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
		System.out.println("       Menu Arrendatario");
		System.out.println("================================");

		System.out.println("1.Arrendatario existente");
		System.out.println("2.Arrendatario nuevo");
		System.out.println("3.Crear contrato");
		System.out.println("4.Atras");
		opcion = scannerService.pedirNumeroEntreRango("Opcion: ", "Opcion no valida, ingrese nuevamente..", 1, 4);

		MenuType[] menus = MenuType.values();
		return menus[opcion - 1];
	}

	private boolean decision(RealEstate real) {

		while (true) {
			System.out.println("==========================");
			real.setCostoOfertado(scannerService.pedirInt("Cual es tu oferta:", "Necesito un numero.."));
			System.out.println("CostoMin: " + real.getCostoMin());
			if (real.getCostoOfertado() >= real.getCostoMin()) {
				return true;
			} else {

				int oferta = scannerService.pedirNumeroEntreRango("Deseas subir mas la oferta?\n1.Si o 2.No",
						"Necesito un numero", 1, 2);
				if (oferta == 2) {
					return false;
				}
			}
		}
	}

}
