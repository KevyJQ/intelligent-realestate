package com.intelligent.realestate.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;


public class ArrendadorDaoImpl implements ArrendadorDao {

	Scanner scanner = new Scanner(System.in);
	Connection connection;
	String instruccionSQL;

	public ArrendadorDaoImpl(Connection conn) {
		this.connection = conn;
	}

	public Arrendador findById(long arrendadorId) {
		instruccionSQL = "SELECT nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular FROM arrendador "
				+ "WHERE id_arrendador = ? ;";
		Arrendador arrendador = null;
		try {
			PreparedStatement myStmt;
			myStmt = connection.prepareStatement(instruccionSQL);
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

	public List<Arrendador> findByNameAndLasName(String name, String apelledoMaterno, String apellidoPaterno){

		List<Arrendador> arrendadores = new ArrayList<Arrendador>();

		instruccionSQL = "SELECT id_arrendador,nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular FROM arrendador "
				+ "WHERE nombre1= ? AND apellidoPaterno= ? AND apellidoMaterno= ?";

		try {
			PreparedStatement myStmt;
			myStmt = connection.prepareStatement(instruccionSQL);
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

	public void insertArrendador(Arrendador arrendador) {

		instruccionSQL = "INSERT INTO arrendador(nombre1,nombre2,apellidoPaterno,apellidoMaterno,"
				+ "edad,correo,celular) VALUE (?,?,?,?,?,?,?)";
		try {
			PreparedStatement myStmt;
			myStmt = connection.prepareStatement(instruccionSQL);
			myStmt.setString(1, arrendador.getNombre1());
			myStmt.setString(2, arrendador.getNombre2());
			myStmt.setString(3, arrendador.getApellidoPaterno());
			myStmt.setString(4, arrendador.getApellidoMaterno());
			myStmt.setInt(5, arrendador.getEdad());
			myStmt.setString(6, arrendador.getCorreo());
			myStmt.setString(7, arrendador.getCelular());
			myStmt.execute();

			PreparedStatement rs = connection.prepareStatement("SELECT id_arrendador FROM arrendador WHERE nombre1= ? AND apellidoPaterno = ? AND apellidoMaterno= ?");
			rs.setString(1, arrendador.getNombre1());
			rs.setString(2, arrendador.getApellidoPaterno());
			rs.setString(3, arrendador.getApellidoMaterno());
			ResultSet rst = rs.executeQuery();
			long id= 0;
			while(rst.next()){
				id = rst.getLong(1);
			}
			System.out.println("\n\t\tTu ID sera: "+id);
			System.out.println("\nInsert exitoso..");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
