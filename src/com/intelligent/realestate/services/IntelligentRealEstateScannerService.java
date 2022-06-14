package com.intelligent.realestate.services;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Direccion;

/*
 * Servicio para obtener la information de los arrendatarios, arrendadores,
 * bienes raices, etc.
 */
public interface IntelligentRealEstateScannerService {

	/*
	 * Pide un numero.
	 */
	public int pedirNumero(String msg, String errorMsg);

	public int pedirNumeroEntreRango(String msg, String errorMsg, int limiteInferiorInclusivo, int limiteSuperiorInclusivo);

	public Direccion pedirDireccion();

	public Arrendador pedirArrendador();

	public Arrendatario pedirArrendatario();
}
