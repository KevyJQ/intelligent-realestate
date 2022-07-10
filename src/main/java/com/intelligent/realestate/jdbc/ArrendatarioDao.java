package com.intelligent.realestate.jdbc;

import java.sql.Connection;
import java.util.Scanner;

import com.intelligent.realestate.model.Arrendatario;

public class ArrendatarioDao {

	Scanner scanner = new Scanner(System.in);
	Connection oConnection;
	String instruccionSQL;

	public ArrendatarioDao(Connection conn) {
		this.oConnection = conn;
	}
	
	public void guardarArrendatario(Arrendatario arrendatario){
		
		System.out.print("Primer nombre:");
		arrendatario.setNombre1(scanner.nextLine());
		System.out.print("Segundo nombre:");
		arrendatario.setNombre2(scanner.nextLine());
		System.out.print("Apellido Paterno:");
		arrendatario.setApellidoPaterno(scanner.nextLine());
		System.out.print("Apellido Materno:");
		arrendatario.setApellidoMaterno(scanner.nextLine());
		System.out.print("Edad: :");
		arrendatario.setEdad(Integer.parseInt(scanner.nextLine()));
		System.out.print("Correo:");
		arrendatario.setCorreo(scanner.nextLine());
		System.out.print("Celular:");
		arrendatario.setCelular(scanner.nextLine());
		
	}
}
