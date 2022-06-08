package com.realestate.intelligent;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FilterInputStream;

public class DBArquintelligent {

	public static void main(String[] args) {

		int opc = 0;
	

		//Arrendador Arren = new Arrendador();
		//Arrendatario Arrenda = new Arrendatario();

		System.out.println("---Bienvenido a mi sistema---");

		boolean Vali = true;
		while(Vali) {
			System.out.print("Eres:\n1.Arrendador\n2.Arrendatario\n3.Salir\nQue dato deseas checar?: ");
			opc = validacion();

			switch(opc) {
			case 1:
				System.out.println("Entre a la opcion 1");
				Arrendador arrendador = new Arrendador(null, null, null, null, null, null, null);
				pedirDatos(arrendador);
				//arrendador.Hola();	//Pueba de inpresion
				break;
			case 2:
				System.out.println("Entre a la opcion 2");
				Arrendatario arrendatario = new Arrendatario(null, null, null, null, null, null, null);
				pedirDatos(arrendatario);
				//arrendatario.Hola2();//Prueba de impresion
				break;
			case 3:
				System.out.println("\n\tHasta luego, tenga un lindo dia.");
				Vali = false;
				break;
			default:
				System.out.println("Por favor intente nuevamente");
				break;
			}
		}
	}

	//Metodo validacion 
	public static int validacion() {

		int opc = 0;
		Scanner sc = new Scanner(new FilterInputStream(System.in){public void close(){}});

		try {

			String val = sc.nextLine();
			opc = Integer.parseInt(val);
			validMiExcep(opc);

		}catch(NumberFormatException | InputMismatchException e) {
			System.out.println("Necesito un numero..");

		}catch(MiExcepcion e) {
			System.out.println("Numeros negativos no permitidos..");

		}catch(NoSuchElementException e) {
			System.out.println(".............");
		}
		return opc;
	}

	//Metodo de mi propio Excepction 
	public static int validMiExcep (int numero) throws MiExcepcion {
		if(numero < 0) {
			throw new MiExcepcion("Numero negativo no permitido");
		}
		return (numero);
	}

	//Metodo para pedir los datos
	public static void pedirDatos (Persona p) {
		
		Scanner date = new Scanner(new FilterInputStream(System.in){public void close(){}});
		
		System.out.print("Dame tu primer nombre: ");
		String nombre1 = date.nextLine();
		p.setNombre1(nombre1);
		
		System.out.print("Dame tu segundo nombre: ");
		String nombre2 = date.nextLine();
		p.setNombre2(nombre2);
		
		System.out.print("Dame tu Apellido Paterno: ");
		String apellidoPaterno = date.nextLine();
		p.setApellidoPaterno(apellidoPaterno);
		
		System.out.print("Dame tu Apellido Materno: ");
		String apellidoMaterno = date.nextLine();
		p.setApellidoMaterno(apellidoMaterno);
		
		System.out.print("Dime tu edad: ");
		String edad = date.nextLine();
		p.setEdad(edad);
		
		System.out.print("Dame tu correo: ");
		String correo = date.nextLine();
		p.setCorreo(correo);
		
		System.out.print("Dame tu celular: ");
		String celular = date.nextLine();
		p.setCelular(celular);
		
	}
}

