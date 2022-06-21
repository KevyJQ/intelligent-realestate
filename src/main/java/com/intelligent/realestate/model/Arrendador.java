package com.intelligent.realestate.model;

public class Arrendador extends Persona {
	// TODO: Add comments and the properties that is renting.
	
	public Arrendador() {
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append("Propiedades: ");
		//Proximamente..

		return sb.toString();
	}

}