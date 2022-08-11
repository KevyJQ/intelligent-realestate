package com.intelligent.realestate.model;

import java.sql.Date;

public class Contrato {
	private Long idContrato;
	private Arrendador arrendador;
	private Arrendatario arrendatario;
	private RealEstate realEstate;
	private Date fechaInicio;
	private Date fechaFinal;

	public Long getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}
	public Arrendador getArrendador() {
		return arrendador;
	}
	public void setArrendador(Arrendador arrendador) {
		this.arrendador = arrendador;
	}
	public Arrendatario getArrendatario() {
		return arrendatario;
	}
	public void setArrendatario(Arrendatario arrendatario) {
		this.arrendatario = arrendatario;
	}
	public RealEstate getRealEstate() {
		return realEstate;
	}
	public void setRealEstate(RealEstate realEstate) {
		this.realEstate = realEstate;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
}
