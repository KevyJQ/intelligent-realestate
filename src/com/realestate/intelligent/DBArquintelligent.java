package com.realestate.intelligent;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FilterInputStream;

public class DBArquintelligent {

	public static void main(String[] args) {

		System.out.println("---Bienvenido a mi sistema---");

		boolean Vali = true;
		while(Vali) {
			System.out.print("Eres:\n1.Arrendador\n2.Arrendatario\n3.Salir\nQue dato deseas checar?: ");
			int opc = validacion();

			switch(opc) {
			case 1:
				System.out.println("Entre a la opcion 1");
				Arrendador arrendador = new Arrendador(null, null, null, null, null, null, null, null);
				arrendador.setDireccion(new Direccion());
				pedirDatosUsuario(arrendador);
				int opcSecu = menuSecundario();
				if(opcSecu == 1) {
					pedirDatosDireccion(arrendador);
				}

				//arrendador.Hola();	//Pueba de inpresion
				break;
			case 2:
				System.out.println("Entre a la opcion 2");
				Arrendatario arrendatario = new Arrendatario(null, null, null, null, null, null, null, null);
				pedirDatosUsuario(arrendatario);
				arrendatario.setDireccion(new Direccion());
				int opcSecu2 = menuSecundario();
				if(opcSecu2 == 1) {
					pedirDatosDireccion(arrendatario);
				}
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
	public static void pedirDatosUsuario (Persona p) {	//Metodo generico de tipo Persona

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

	public static void pedirDatosDireccion (Persona d) {	//Metodo generico de tipo Direccion

		Scanner direc = new Scanner(new FilterInputStream(System.in){public void close(){}});

		System.out.print("Direccion 1: ");
		String direccion1 = direc.nextLine();
		d.direccion.setDireccion1(direccion1);

		System.out.print("Direccion 2: ");
		String direccion2 = direc.nextLine();
		d.direccion.setDireccion2(direccion2);

		System.out.print("Pais: ");
		String pais = direc.nextLine();
		d.direccion.setPais(pais);

		System.out.print("Ciudad: ");
		String ciudad = direc.nextLine();
		d.direccion.setCiudad(ciudad);

		System.out.print("Estado: ");
		String estado = direc.nextLine();
		d.direccion.setEstado(estado);

		System.out.print("Codigo Postal: ");
		String codigoPostal = direc.nextLine();
		d.direccion.setCodigoPostal(codigoPostal);

	}

	public static int menuSecundario() {

		boolean Vali = true;
		while(Vali) {
			System.out.print("Deseas agregar una nueva direccion\n1.Si\n2.No\nOpcion: ");
			int opcSec = validacion();
			switch(opcSec) {
			case 1:
				//Si quiere agregar una nueva direccion
				return 1;
			case 2:
				//No quiere agregar una nueva direccion
				Vali = false;
				return 0;
			default:
				System.out.println("Esa opcion no existe..");
			}
		}

		return 0;
	}
}

