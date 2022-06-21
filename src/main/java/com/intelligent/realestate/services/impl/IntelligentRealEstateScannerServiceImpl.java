package com.intelligent.realestate.services.impl;

import java.io.FilterInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Direccion;
import com.intelligent.realestate.model.Persona;
import com.intelligent.realestate.services.IntelligentRealEstateScannerService;

public class IntelligentRealEstateScannerServiceImpl implements IntelligentRealEstateScannerService {


	private Scanner scanner;

	public IntelligentRealEstateScannerServiceImpl() {
		scanner = new Scanner(new FilterInputStream(System.in) {
			public void close() {
			}
		});
	}

	@Override
	public int pedirNumero(String msg, String errorMsg) {
		int num = -1;
		boolean valid = false;

		do {
			try {
				String value = scanner.nextLine();
				num = Integer.parseInt(value);
				valid = true;
			} catch (NumberFormatException | InputMismatchException e) {
				System.out.println(errorMsg);
			}
		} while (!valid);

		return num;
	}

	@Override
	public int pedirNumeroEntreRango(String msg, String errorMsg, int limiteInferiorInclusivo,int limiteSuperiorInclusivo) {
		int num = -1;
		boolean valid = false;

		do {
			num = pedirNumero(msg, errorMsg);
			if (num >= limiteInferiorInclusivo && num <= limiteSuperiorInclusivo) {
				valid = true;
			} else {
				System.out.println(errorMsg);
			}
		} while (!valid);

		return num;
	}

	private void llenarPersona(Persona persona, boolean isDireccionMandatory) {	

		System.out.print("Dame tu primer nombre: ");
		String nombre1 = scanner.nextLine();
		persona.setNombre1(nombre1);

		System.out.print("Dame tu segundo nombre: ");
		String nombre2 = scanner.nextLine();
		persona.setNombre2(nombre2);

		System.out.print("Dame tu Apellido Paterno: ");
		String apellidoPaterno = scanner.nextLine();
		persona.setApellidoPaterno(apellidoPaterno);

		System.out.print("Dame tu Apellido Materno: ");
		String apellidoMaterno = scanner.nextLine();
		persona.setApellidoMaterno(apellidoMaterno);

		System.out.print("Dime tu edad: ");
		int edad = pedirNumeroEntreRango("", "Numero no valido", 1, 100);
		persona.setEdad(edad);

		System.out.print("Dame tu correo: ");
		String correo = scanner.nextLine();
		persona.setCorreo(correo);

		System.out.print("Dame tu celular: ");
		String celular = scanner.nextLine();
		persona.setCelular(celular);

		if (isDireccionMandatory) {
			pedirDireccion();
		}else  {
			System.out.print("Cuentas con residencia actual\n1.Si\n2.No\nOpcion: ");
			int opcion = pedirNumeroEntreRango("", "Numero no valido", 1, 2);
					if(opcion == 1) {
						pedirDireccion();
					}
		}
	}

	private void llenarDireccion(Direccion direccion) {

		System.out.print("Direccion 1: ");
		String direccion1 = scanner.nextLine();
		direccion.setDireccion1(direccion1);

		System.out.print("Direccion 2: ");
		String direccion2 = scanner.nextLine();
		direccion.setDireccion2(direccion2);

		System.out.print("Pais: ");
		String pais = scanner.nextLine();
		direccion.setPais(pais);

		System.out.print("Ciudad: ");
		String ciudad = scanner.nextLine();
		direccion.setCiudad(ciudad);

		System.out.print("Estado: ");
		String estado = scanner.nextLine();
		direccion.setEstado(estado);

		System.out.print("Codigo Postal: ");
		String codigoPostal = scanner.nextLine();
		direccion.setCodigoPostal(codigoPostal);
	}

	@Override
	public Direccion pedirDireccion() {
		Direccion direccion = new Direccion();
		llenarDireccion(direccion);
		return direccion;
	}

	@Override
	public Arrendador pedirArrendador() {
		Arrendador arrendador = new Arrendador();
		boolean isDireccionMandator = true;
		llenarPersona(arrendador, isDireccionMandator);
		return arrendador;
	}

	@Override
	public Arrendatario pedirArrendatario() {
		Arrendatario arrendatario = new Arrendatario();
		boolean isDireccionMandator = false;
		llenarPersona(arrendatario,isDireccionMandator);
		return arrendatario;
	}
}
