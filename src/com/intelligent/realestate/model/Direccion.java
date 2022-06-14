package com.intelligent.realestate.model;

public class Direccion {
	// TODO: Add comments
	private String direccion1;
	private String direccion2;
	private String pais;
	private String ciudad;
	private String estado;
	private String codigoPostal;

	public Direccion() {
	}

	public Direccion(String direccion1, String direccion2,
			String pais, String ciudad, String estado, String codigoPostal) {
		super();
		this.direccion1 = direccion1;
		this.direccion2 = direccion2;
		this.pais = pais;
		this.ciudad = ciudad;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
		
	}

	public String getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public String getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n\t");
		sb.append(direccion1);
		sb.append("\n\t");
		sb.append(direccion2);
		sb.append("\n\t");
		sb.append(pais);
		sb.append("\n");
		sb.append(ciudad);
		sb.append("\n");
		sb.append(estado);
		sb.append("\n");
		sb.append(codigoPostal);
		sb.append("}");
		
		return sb.toString();
	}
}