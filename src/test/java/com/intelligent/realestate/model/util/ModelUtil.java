package com.intelligent.realestate.model.util;

import java.util.Date;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Direccion;

/*
 * ModelUtil contiene metodos para crear Model objects usados
 * en los test cases.
 */
public class ModelUtil {

	public static Direccion crearDireccion() {
		Direccion direccion = new Direccion();
		direccion.setCiudad("Test Ciudad");
		direccion.setEstado("Test Estado");
		direccion.setDireccion1("Test direccion 1");
		direccion.setDireccion2("Test direccion 2");
		direccion.setCodigoPostal("Test cp");
		direccion.setPais("Test Pais");

		return direccion;
	}

	public static Arrendador crearArrendador() {
		Arrendador arrendador = new Arrendador();
		Date date = new Date();
		arrendador.setNombre1("Test nombre1 " + date);
		arrendador.setNombre2("Test nombre2 " + date);
		arrendador.setApellidoPaterno("Test Apellido");
		arrendador.setApellidoMaterno("Test materno");
		arrendador.setEdad(23);
		arrendador.setCorreo("test@gmail.com");
		arrendador.setCelular("659 864 9454");
		arrendador.setDireccion(crearDireccion());

		return arrendador;
	}

	public static Arrendatario crearArrendatario() {
		Arrendatario arrendatario = new Arrendatario();
		Date date = new Date();
		arrendatario.setNombre1("Test nombre1 " + date);
		arrendatario.setNombre1("Test name ");
		arrendatario.setNombre2("Test nombre2 ");
		arrendatario.setApellidoPaterno("Test Apellido");
		arrendatario.setApellidoMaterno("Test materno");
		arrendatario.setEdad(23);
		arrendatario.setCorreo("test@gmail.com");
		arrendatario.setCelular("659 864 9454");
		arrendatario.setDireccion(crearDireccion());

		return arrendatario;
	}
}
