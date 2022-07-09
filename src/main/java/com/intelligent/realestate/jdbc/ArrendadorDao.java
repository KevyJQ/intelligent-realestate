package com.intelligent.realestate.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.intelligent.realestate.model.Arrendador;


public class ArrendadorDao {

	Scanner scanner = new Scanner(System.in);
	Connection oConnection;
	String instruccionSQL;

	public ArrendadorDao(Connection conn) {
		this.oConnection = conn;
	}

	public Arrendador findById(long arrendadorId) {
		instruccionSQL = "SELECT nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular FROM arrendador "
				+ "WHERE id_arrendador = ? ;";
		Arrendador arrendador = null;
		try {
			PreparedStatement myStmt;
			myStmt = oConnection.prepareStatement(instruccionSQL);
			myStmt.setLong(1, arrendadorId);
			ResultSet myRs = myStmt.executeQuery();

			if (myRs.next()) {
				arrendador = new Arrendador();
				arrendador.setNombre1(myRs.getString(1));
				arrendador.setNombre2(myRs.getString(2));
				arrendador.setApellidoPaterno(myRs.getString(3));
				arrendador.setApellidoMaterno(myRs.getString(4));
				arrendador.setEdad(myRs.getInt(5));
				arrendador.setCorreo(myRs.getString(6));
				arrendador.setCelular(myRs.getString(7));

			}
			System.out.println("ID: "+arrendadorId+"\nNombre: "+myRs.getString(1)
			+" "+myRs.getString(2)+" "+myRs.getString(3)+" "+myRs.getString(4)
			+"\nEdad: "+myRs.getInt(5)+"\nCorreo: "+myRs.getString(6)+"\nCelular: "
			+myRs.getString(7));

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return arrendador;
	}

	public List<Arrendador> findByNameAndLasName(String name, String apelledoMaterno
			,String apellidoPaterno){

		List<Arrendador> arrendadores = new ArrayList<Arrendador>();

		instruccionSQL = "SELECT id_arrendador,nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular FROM arrendador "
				+ "WHERE nombre1= ? AND apellidoPaterno= ? AND apellidoMaterno= ?";

		try {
			PreparedStatement myStmt;
			myStmt = oConnection.prepareStatement(instruccionSQL);
			myStmt.setString(1,name);
			myStmt.setString(2,apellidoPaterno);
			myStmt.setString(3,apelledoMaterno);
			ResultSet myRs = myStmt.executeQuery();
			Arrendador arrendador = new Arrendador();
			int ID = 0;
			while (myRs.next()) {
				ID = myRs.getInt(1);
				arrendador.setNombre1(myRs.getString(2));
				arrendador.setNombre2(myRs.getString(3));
				arrendador.setApellidoPaterno(myRs.getString(4));
				arrendador.setApellidoMaterno(myRs.getString(5));
				arrendador.setEdad(myRs.getInt(6));
				arrendador.setCorreo(myRs.getString(7));
				arrendador.setCelular(myRs.getString(8));
				arrendadores.add(arrendador);
			}

			//System.out.println("SIZE " + arrendadores.size());
			for(Arrendador arre : arrendadores) {
				System.out.print("ID: "+ID);
				System.out.print("\nNombre: "+arre.getNombre1());
				System.out.print(" "+arre.getNombre2());
				System.out.print(" "+arre.getApellidoPaterno());
				System.out.print(" "+arre.getApellidoMaterno());
				System.out.print("\nEdad: "+arre.getEdad());
				System.out.print("\nCorreo: "+arre.getCorreo());
				System.out.print("\nCelular: "+arre.getCelular());
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return arrendadores;
	}

	public void guardarArrendador(Arrendador arrendador){
		
		System.out.print("Primer nombre:");
		arrendador.setNombre1(scanner.nextLine());
		System.out.print("Segundo nombre:");
		arrendador.setNombre2(scanner.nextLine());
		System.out.print("Apellido Paterno:");
		arrendador.setApellidoPaterno(scanner.nextLine());
		System.out.print("Apellido Materno:");
		arrendador.setApellidoMaterno(scanner.nextLine());
		System.out.print("Edad: :");
		arrendador.setEdad(Integer.parseInt(scanner.nextLine()));
		System.out.print("Correo:");
		arrendador.setCorreo(scanner.nextLine());
		System.out.print("Celular:");
		arrendador.setCelular(scanner.nextLine());
		
	}


}
