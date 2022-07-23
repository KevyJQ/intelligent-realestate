package com.intelligent.realestate.model.util;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.RealEstate;

public class ModelPrintUtil {
	public static void imprimirArrendador(Arrendador arrendador) {
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

	public static void imprimirArrendatario(Arrendatario arrendatario) {
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

	public static void printMultiArrendatarios(Arrendatario arrendatario) {
		System.out.println("ID: " + arrendatario.getIdArrendatario());
		System.out.println("Nombre: " + arrendatario.getNombre1() + " " + arrendatario.getNombre2());
		System.out.println("Apellidos: " + arrendatario.getApellidoPaterno() + " " + arrendatario.getApellidoMaterno());
		System.out.println("Edad: " + arrendatario.getEdad());
		System.out.println("Correo: " + arrendatario.getCorreo());
		System.out.println("Celular: " + arrendatario.getCelular());
	}
	
	public static  void printMultiArrendadores(Arrendador arrendador) {
		System.out.println("ID: " + arrendador.getIdArrendador());
		System.out.println("Nombre: " + arrendador.getNombre1() + " " + arrendador.getNombre2());
		System.out.println("Apellidos: " + arrendador.getApellidoPaterno() + " " + arrendador.getApellidoMaterno());
		System.out.println("Edad: " + arrendador.getEdad());
		System.out.println("Correo: " + arrendador.getCorreo());
		System.out.println("Celular: " + arrendador.getCelular());
	}
	
	public static  void printMultiRealEstates(RealEstate realestate) {
		System.out.println("ID: " + realestate.getIdRealEstate());
		System.out.println("Estatus: " + realestate.getStatus());
		System.out.println("Direccion1: " + realestate.getDireccion().getDireccion1());
		System.out.println("Direccion2: " + realestate.getDireccion().getDireccion2());
		System.out.println("Pais: " + realestate.getDireccion().getPais());
		System.out.println("Ciudad: " + realestate.getDireccion().getCiudad());
		System.out.println("Estado: " + realestate.getDireccion().getEstado());
		System.out.println("CP: " + realestate.getDireccion().getCodigoPostal());

	}
}
