package com.intelligent.realestate.model;

public class Arrendatario extends Persona{
	// TODO: Add comments and the properties that is renting.
	
	private Integer idArrendatario;
	
	public Integer getIdArrendatario() {
		return idArrendatario;
	}

	public void setIdArrendatario(Integer idArrendatario) {
		this.idArrendatario = idArrendatario;
	}

	public Arrendatario() {	//Constructor
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append("Propiedades: ");

		return sb.toString();
	}
}
