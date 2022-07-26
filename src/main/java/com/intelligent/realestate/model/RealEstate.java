package com.intelligent.realestate.model;

public class RealEstate {

	private Direccion direccion;
	private TypeRealEstate realEstateType;
	private String status;
	long idRealEstate;
	long arrendadadorId;
	int id_typeRE;
	long costoMin;
	long costoMax;
	long costoOfertado;

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

	public int getId_typeRE() {
		return id_typeRE;
	}

	public void setId_typeRE(int id_typeRE) {
		this.id_typeRE = id_typeRE;
	}

	public long getArrendadadorId() {
		return arrendadadorId;
	}

	public void setArrendadadorId(long arrendadadorId) {
		this.arrendadadorId = arrendadadorId;
	}

	public long getCostoMin() {
		return costoMin;
	}

	public void setCostoMin(long costoMin) {
		this.costoMin = costoMin;
	}

	public long getCostoMax() {
		return costoMax;
	}

	public void setCostoMax(long costoMax) {
		this.costoMax = costoMax;
	}

	public long getCostoOfertado() {
		return costoOfertado;
	}

	public void setCostoOfertado(long costoOfertado) {
		this.costoOfertado = costoOfertado;
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
