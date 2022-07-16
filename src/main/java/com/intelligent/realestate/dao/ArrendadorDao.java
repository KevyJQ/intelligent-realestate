package com.intelligent.realestate.dao;

import java.util.List;

import com.intelligent.realestate.model.Arrendador;

public interface ArrendadorDao {

	public Arrendador findById(long arrendadorId);

	public List<Arrendador> findByNameAndLasName(String name, String apelledoMaterno, String apellidoPaterno);

	public void insertArrendador(Arrendador arrendador);

	public void insertRealEstate(Arrendador arrendador);
}
