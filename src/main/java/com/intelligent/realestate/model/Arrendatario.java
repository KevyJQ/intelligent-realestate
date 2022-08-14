package com.intelligent.realestate.model;

public class Arrendatario extends Persona {
	private Long idArrendatario;
	private long idContrato;

	public Long getIdArrendatario() {
		return idArrendatario;
	}

	public void setIdArrendatario(Long idArrendatario) {
		this.idArrendatario = idArrendatario;
	}

	public Arrendatario() { // Constructor
	}

	public long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(long idContrato) {
		this.idContrato = idContrato;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Propiedades: ");

		return sb.toString();
	}
}
