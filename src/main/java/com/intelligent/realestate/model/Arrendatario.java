package com.intelligent.realestate.model;

public class Arrendatario extends Persona {
	private Long idArrendatario;

	public Arrendatario() { // Constructor
	}

	public Long getIdArrendatario() {
		return idArrendatario;
	}

	public void setIdArrendatario(Long idArrendatario) {
		this.idArrendatario = idArrendatario;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Propiedades: ");

		return sb.toString();
	}
}
