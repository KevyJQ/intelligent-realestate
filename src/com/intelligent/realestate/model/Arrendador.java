package com.intelligent.realestate.model;

public class Arrendador extends Persona {
	// TODO: Add comments and the properties that is renting.
	public Arrendador() {
	}

	//Costructor con los datos que hereda de Persona
	public Arrendador(String nombre1, String nombre2, String apellidoMaterno, String apellidoPaterno, int edad,
			String correo, String celular,Direccion direccion,RealEstate realEstate) {
		super(nombre1, nombre2, apellidoMaterno, apellidoPaterno, edad, correo, celular, direccion, realEstate);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append("Propiedades: ");

		return sb.toString();
	}

}