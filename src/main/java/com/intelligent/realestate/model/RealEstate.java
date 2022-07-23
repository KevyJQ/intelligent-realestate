package com.intelligent.realestate.model;

public class RealEstate {

	private Direccion direccion;
	private TypeRealEstate realEstateType;
	private String status;
	long idRealEstate;

	public long getIdRealEstate() {
		return idRealEstate;
	}

	public void setIdRealEstate(long idRealEstate) {
		this.idRealEstate = idRealEstate;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n\t");
		sb.append(direccion);
		sb.append("\n\t");
		sb.append(realEstateType);
		sb.append("\n");
		sb.append(status);
		sb.append("\n");
		sb.append("}");

		return sb.toString();
	}
}
