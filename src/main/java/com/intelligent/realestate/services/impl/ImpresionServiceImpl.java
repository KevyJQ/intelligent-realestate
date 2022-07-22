package com.intelligent.realestate.services.impl;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.services.ImpresionService;

public class ImpresionServiceImpl implements ImpresionService {

	public void imprimirArrendador(Arrendador arrendador) {
		System.out.println("================================");
		System.out.println("      Datos del Arrendador      ");
		System.out.println("================================");

		System.out.println("ID: " + arrendador.getIdArrendador());
		System.out.println("Nombre: " + arrendador.getNombre1() + " " + arrendador.getNombre2());
		System.out.println("Apellidos: " + arrendador.getApellidoPaterno() + " " + arrendador.getApellidoMaterno());
		System.out.println("Edad: " + arrendador.getEdad());
		System.out.println("Correo: " + arrendador.getCorreo());
		System.out.println("Celular: " + arrendador.getCelular());
		System.out.println("Direccion1: " + arrendador.getDireccion().getDireccion1());
		System.out.println("Direccion2: " + arrendador.getDireccion().getDireccion2());
		System.out.println("Pais: " + arrendador.getDireccion().getPais());
		System.out.println("Ciudad: " + arrendador.getDireccion().getCiudad());
		System.out.println("Estado: " + arrendador.getDireccion().getEstado());
		System.out.println("CP: " + arrendador.getDireccion().getCodigoPostal());

	}

	@Override
	public void imprimirArrendatario(Arrendatario arrendatario) {
		System.out.println("================================");
		System.out.println("      Datos del Arrendatario      ");
		System.out.println("================================");

		System.out.println("ID: " + arrendatario.getIdArrendatario());
		System.out.println("Nombre: " + arrendatario.getNombre1() + " " + arrendatario.getNombre2());
		System.out.println("Apellidos: " + arrendatario.getApellidoPaterno() + " " + arrendatario.getApellidoMaterno());
		System.out.println("Edad: " + arrendatario.getEdad());
		System.out.println("Correo: " + arrendatario.getCorreo());
		System.out.println("Celular: " + arrendatario.getCelular());
		System.out.println("Direccion1: " + arrendatario.getDireccion().getDireccion1());
		System.out.println("Direccion2: " + arrendatario.getDireccion().getDireccion2());
		System.out.println("Pais: " + arrendatario.getDireccion().getPais());
		System.out.println("Ciudad: " + arrendatario.getDireccion().getCiudad());
		System.out.println("Estado: " + arrendatario.getDireccion().getEstado());
		System.out.println("CP: " + arrendatario.getDireccion().getCodigoPostal());

	}

	public void printMultiArrendatarios(Arrendatario arrendatario) {
		System.out.println("ID: " + arrendatario.getIdArrendatario());
		System.out.println("Nombre: " + arrendatario.getNombre1() + " " + arrendatario.getNombre2());
		System.out.println("Apellidos: " + arrendatario.getApellidoPaterno() + " " + arrendatario.getApellidoMaterno());
		System.out.println("Edad: " + arrendatario.getEdad());
		System.out.println("Correo: " + arrendatario.getCorreo());
		System.out.println("Celular: " + arrendatario.getCelular());
	}
	
	public void printMultiArrendadores(Arrendador arrendador) {
		System.out.println("ID: " + arrendador.getIdArrendador());
		System.out.println("Nombre: " + arrendador.getNombre1() + " " + arrendador.getNombre2());
		System.out.println("Apellidos: " + arrendador.getApellidoPaterno() + " " + arrendador.getApellidoMaterno());
		System.out.println("Edad: " + arrendador.getEdad());
		System.out.println("Correo: " + arrendador.getCorreo());
		System.out.println("Celular: " + arrendador.getCelular());
	}

}
