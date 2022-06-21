package com.intelligent.realestate.model;

public class RealEstate {
	// TODO: Add comments and the properties that is renting. Implement toString().
	private Direccion direccion;
	private TypeRealEstate realEstateType;
	
	public RealEstate() {
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public TypeRealEstate getRealEstateType() {
		return realEstateType;
	}

	public void setRealEstateType(TypeRealEstate realEstateType) {
		this.realEstateType = realEstateType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n\t");
		sb.append(direccion);
		sb.append("\n\t");
		sb.append(realEstateType);
		sb.append("\n");
		sb.append("}");
		
		return sb.toString();
	}
}
