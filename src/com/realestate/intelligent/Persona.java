package com.realestate.intelligent;

public class Persona {

	//Codigo en espera

	private String nombre1;
	private String nombre2;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String edad;
	private String correo;
	private String celular;
	protected Direccion direccion;

	public Persona() {
	}

	public Persona(String nombre1, String nombre2, String apellidoMaterno, String apellidoPaterno, String edad,
			String correo, String celular, Direccion direccion) {
		super();
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellidoMaterno = apellidoMaterno;
		this.apellidoPaterno = apellidoPaterno;
		this.edad = edad;
		this.correo = correo;
		this.celular = celular;
		this.direccion = direccion;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		try {
			if(Integer.parseInt(this.edad) > 0 && Integer.parseInt(this.edad) < 100) {
				this.edad = edad;
			}
		}catch(NumberFormatException e) {
			System.out.println("Edad erronea..");
		}
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {

		this.celular = celular;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}

