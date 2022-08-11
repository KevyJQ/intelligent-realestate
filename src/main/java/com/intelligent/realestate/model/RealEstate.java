package com.intelligent.realestate.model;

public class RealEstate {
	Long idRealEstate;
	Long arrendadadorId;
	int id_typeRE;
	double costoMin;
	double costoMax;
	double costoOfertado;
	private Direccion direccion;
	private TypeRealEstate realEstateType;
	private String status;

	public Long getIdRealEstate() {
		return idRealEstate;
	}

	public void setIdRealEstate(Long idRealEstate) {
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
	
	public Long getArrendadadorId() {
		return arrendadadorId;
	}
	
	public void setArrendadadorId(Long arrendadadorId) {
		this.arrendadadorId = arrendadadorId;
	}
	
	public double getCostoMin() {
		return costoMin;
	}
	
	public void setCostoMin(double costoMin) {
		this.costoMin = costoMin;
	}
	
	public double getCostoMax() {
		return costoMax;
	}
	
	public void setCostoMax(double costoMax) {
		this.costoMax = costoMax;
	}
	
	public double getCostoOfertado() {
		return costoOfertado;
	}
	
	public void setCostoOfertado(double costoOfertado) {
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
