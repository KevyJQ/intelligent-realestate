package com.intelligent.realestate.model;

public class Arrendador extends Persona {
	private Integer idArrendador;

	public Integer getIdArrendador() {
		return idArrendador;
	}

	public void setIdArrendador(Integer idArrendador) {
		this.idArrendador = idArrendador;
	}

	public Arrendador() {
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Propiedades: ");
		// Proximamente..

		return sb.toString();
	}

}