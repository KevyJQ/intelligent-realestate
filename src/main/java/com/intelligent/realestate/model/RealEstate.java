package com.intelligent.realestate.model;

public class RealEstate {
	Long idRealEstate;
	Long arrendadadorId;
	double costoMin;
	double costoMax;
	double costoOfertado;
	private Direccion direccion;
	private TypeRealEstate realEstateType;
	private RealEstateEstatus estatus;

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

	public RealEstateEstatus getEstatus() {
		return estatus;
	}

	public void setEstatus(RealEstateEstatus estatus) {
		this.estatus = estatus;
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
		sb.append(estatus);
		sb.append("\n");
		sb.append("}");

		return sb.toString();
	}
}
