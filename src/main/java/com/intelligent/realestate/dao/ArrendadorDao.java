package com.intelligent.realestate.dao;

import java.util.List;

import com.intelligent.realestate.model.Arrendador;

public interface ArrendadorDao { // Interface ArrendadorDao que nos permitira usar los siguientes metodos

	public List<Arrendador> findAll();
	
	public void delete(Arrendador arrendador);
	
	public Arrendador buscarPorId(long arrendadorId);

	public List<Arrendador> buscarPorNombreApellidoMaternoApellidoPaterno(String nombre, String apelledoMaterno,
			String apellidoPaterno);

	public void guardarArrendador(Arrendador arrendador);
	
	public void actualizarArrendador(Arrendador arrendador);
}
