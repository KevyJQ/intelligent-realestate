package com.intelligent.realestate.services.impl;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.services.ImpresionService;

public class ImpresionServiceImpl implements ImpresionService {

	public void imprimirArrendador(Arrendador arrendador) {

		System.out.println("================================");
		System.out.println("              Datos             ");
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

}
