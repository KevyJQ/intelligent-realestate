package com.intelligent.realestate.model;

public class Direccion {

	private String direccion1;
	private String direccion2;
	private String pais;
	private String ciudad;
	private String estado;
	private String codigoPostal;

	public Direccion() {
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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Direccion) {
			Direccion dir = (Direccion) obj;
			if ((direccion1 != null && direccion1.equals(dir.getDireccion1()))
					&& (direccion2 != null && direccion2.equals(dir.getDireccion2()))
					&& (pais != null && pais.equals(dir.getPais()))
					&& (ciudad != null && ciudad.equals(dir.getCiudad()))
					&& (estado != null && estado.equals(dir.getEstado()))
					&& (codigoPostal != null && codigoPostal.equals(dir.getCodigoPostal())))

				return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		if (direccion1 != null && direccion2 != null) {
			return direccion1.hashCode() + direccion2.hashCode();
		}

		return 123;
	}
}