package com.realestate.intelligent;

public class Arrendador extends Persona {
	
	//Costructor con los datos que hereda de Persona
	public Arrendador(String nombre1, String nombre2, String apellidoMaterno, String apellidoPaterno, String edad,
			String correo, String celular) {
		super(nombre1, nombre2, apellidoMaterno, apellidoPaterno, edad, correo, celular);
		// TODO Auto-generated constructor stub
	}

	public void Hola() {
		System.out.println("\nHola soy Arrendor..");
		System.out.println("Nombre: "+getNombre1()+" "+getNombre2()+" "+getApellidoPaterno()+" "+getApellidoMaterno());
		System.out.println("Edad: "+getEdad());
		System.out.println("Correo: "+getCorreo());
		System.out.println("Celular: "+getCelular());
		
	}

}

