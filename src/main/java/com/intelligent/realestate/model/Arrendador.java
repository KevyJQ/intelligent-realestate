package com.intelligent.realestate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Arrendador extends Persona {

	private Long idArrendador;
	private Set<RealEstate> realEstates = new HashSet<>();

	public Arrendador() {
	}

	public Long getIdArrendador() {
		return idArrendador;
	}

	public void setIdArrendador(Long idArrendador) {
		this.idArrendador = idArrendador;
	}

	public Set<RealEstate> getRealEstates() {
		return realEstates;
	}

	public void setRealEstates(Set<RealEstate> realEstates) {
		this.realEstates = realEstates;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Propiedades: ");
		sb.append("idArrendador: ");
		sb.append(idArrendador);
		sb.append(", nombre: ");
		sb.append(getNombre1());

		return sb.toString();
	}

}