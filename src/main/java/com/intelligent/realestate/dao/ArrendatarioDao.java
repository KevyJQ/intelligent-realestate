package com.intelligent.realestate.dao;

import java.util.List;

import com.intelligent.realestate.model.Arrendatario;

public interface ArrendatarioDao { // Interface ArrendatarioDao que nos permitira usar los siguientes metodos

	public List<Arrendatario> findAll();
	
	public Arrendatario findById(long arrendatarioId);

	public List<Arrendatario> findByNameAndLasName(String name, String apellidoPaterno, String apellidoMaterno);

	public void insertArrendatario(Arrendatario arrendatario);
}
