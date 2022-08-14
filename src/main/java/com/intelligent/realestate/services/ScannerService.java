package com.intelligent.realestate.services;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Direccion;

/*
 * Servicio para obtener la information de los arrendatarios, arrendadores,
 * bienes raices, etc.
 */
public interface ScannerService {

	/*
	 * Pide un numero {@code int}
	 */
	public int pedirInt(String msg, String errorMsg);

	public double pedirDouble(String msg, String errorMsg);

	public int pedirNumeroEntreRango(String msg, String errorMsg, int limiteInferiorInclusivo,
			int limiteSuperiorInclusivo);

	public String pedirString(String msg, String errorMsg);

	public Direccion pedirDireccion();

	public Arrendador pedirArrendador();

	public Arrendatario pedirArrendatario();
}
