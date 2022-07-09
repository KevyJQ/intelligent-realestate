package com.intelligent.realestate.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.intelligent.realestate.model.Arrendador;

public class ArrendadorDao {

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
				arrendador.setCelular(7);

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

		instruccionSQL = "SELECT nombre1,nombres2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular FROM arrendador "
				+ "WHERE name = '?' AND apellidoPaterno = '?' AND apellidoMaterno = '?' ;";
		//Arrendador arrendador = null;
		try {
			PreparedStatement myStmt;
			myStmt = oConnection.prepareStatement(instruccionSQL);
			myStmt.setString(1,name);
			myStmt.setString(2,apellidoPaterno);
			myStmt.setString(3,apelledoMaterno);
			ResultSet myRs = myStmt.executeQuery();
			while (myRs.next()) {
				Arrendador arrendador = new Arrendador();

				arrendador.setNombre1(myRs.getString(1));
				arrendador.setNombre2(myRs.getString(2));
				arrendador.setApellidoPaterno(myRs.getString(3));
				arrendador.setApellidoMaterno(myRs.getString(4));
				arrendador.setEdad(myRs.getInt(5));
				arrendador.setCorreo(myRs.getString(6));
				arrendador.setCelular(7);

				arrendadores.add(arrendador);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return arrendadores;
	}

	public List<Arrendador> findByRealEstate(long arrendadorId){
		return null;
	}
}
