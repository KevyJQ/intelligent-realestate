package com.intelligent.realestate.dao;

import java.util.List;

import com.intelligent.realestate.model.Arrendatario;

public interface ArrendatarioDao {

	public Arrendatario findById(long arrendatarioId);

	public List<Arrendatario> findByNameAndLasName(String name, String apellidoPaterno, String apellidoMaterno);

	public void insertArrendatario(Arrendatario arrendatario);
}
