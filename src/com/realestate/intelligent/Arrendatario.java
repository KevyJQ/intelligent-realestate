package com.realestate.intelligent;

public class Arrendatario extends Persona{

	//Constructor que herada con los datos de Persona
	public Arrendatario(String nombre1, String nombre2, String apellidoMaterno, String apellidoPaterno, String edad,
			String correo, String celular) {
		super(nombre1, nombre2, apellidoMaterno, apellidoPaterno, edad, correo, celular);
		// TODO Auto-generated constructor stub
	}

	public void Hola2() {
		System.out.println("\nHola soy Arrendatario..");
		System.out.println("Nombre: "+getNombre1()+" "+getNombre2()+" "+getApellidoPaterno()+" "+getApellidoMaterno());
		System.out.println("Edad: "+getEdad());
		System.out.println("Correo: "+getCorreo());
		System.out.println("Celular: "+getCelular());
	}
	
}

