package com.intelligent.realestate.dao;

import java.util.List;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.RealEstate;

public interface ArrendadorDao { // Interface ArrendadorDao que nos permitira usar los siguientes metodos

	public Arrendador findById(long arrendadorId);

	public List<Arrendador> findByNameAndLasName(String name, String apelledoMaterno, String apellidoPaterno);

	public void insertArrendador(Arrendador arrendador);

	public void insertRealEstate(RealEstate realEstate);
}
