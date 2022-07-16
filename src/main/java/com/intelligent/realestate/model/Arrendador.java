package com.intelligent.realestate.model;

public class Arrendador extends Persona {
	private Long idArrendador;

	public Long getIdArrendador() {
		return idArrendador;
	}

	public void setIdArrendador(Long idArrendador) {
		this.idArrendador = idArrendador;
	}

	public Arrendador() {
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