package com.intelligent.realestate.model;

public class Arrendatario extends Persona{
	// TODO: Add comments and the properties that is renting.
	
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
