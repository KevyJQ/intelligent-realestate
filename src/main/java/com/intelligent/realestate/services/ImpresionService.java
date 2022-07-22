package com.intelligent.realestate.services;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;

public interface ImpresionService {

	public void imprimirArrendador(Arrendador arrendador);

	public void imprimirArrendatario(Arrendatario arrendatario);

	public void printMultiArrendatarios(Arrendatario arrendatario);
	
	public void printMultiArrendadores(Arrendador arrendador);
}
