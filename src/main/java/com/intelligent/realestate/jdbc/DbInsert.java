package com.intelligent.realestate.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;


public class DbInsert {

	Connection oConnection;
	String instruccionSQL;

	public DbInsert(Connection conn) {
		this.oConnection = conn;
	}

	public void insertArrendador(Arrendador arrendador) throws SQLException {

		instruccionSQL = "INSERT INTO arrendador(nombre1,nombre2,apellidoPaterno,apellidoMaterno,"
				+ "edad,correo,celular) VALUE (?,?,?,?,?,?,?)";

		ArrendadorDao arrendadordao = new ArrendadorDao(DbConnnection.getConnection());
		try {
			PreparedStatement myStmt;
			myStmt = oConnection.prepareStatement(instruccionSQL);
			arrendadordao.guardarArrendador(arrendador);
			myStmt.setString(1, arrendador.getNombre1());
			myStmt.setString(2, arrendador.getNombre2());
			myStmt.setString(3, arrendador.getApellidoPaterno());
			myStmt.setString(4, arrendador.getApellidoMaterno());
			myStmt.setInt(5, arrendador.getEdad());
			myStmt.setString(6, arrendador.getCorreo());
			myStmt.setString(7, arrendador.getCelular());
			myStmt.execute();

			PreparedStatement rs = oConnection.prepareStatement("SELECT id_arrendador FROM arrendador WHERE nombre1= ? AND apellidoPaterno = ? AND apellidoMaterno= ?");
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
	
	public void insertArrendatario(Arrendatario arrendatario) throws SQLException {
		
		instruccionSQL = "INSERT INTO arrendatario(nombre1,nombre2,apellidoPaterno,apellidoMaterno,"
				+ "edad,correo,celular) VALUE (?,?,?,?,?,?,?)";
		
		ArrendatarioDao arrendatariodao = new ArrendatarioDao(DbConnnection.getConnection());
		
		try {
			PreparedStatement myStmt;
			myStmt = oConnection.prepareStatement(instruccionSQL);
			arrendatariodao.guardarArrendador(arrendatario);
			myStmt.setString(1, arrendatario.getNombre1());
			myStmt.setString(2, arrendatario.getNombre2());
			myStmt.setString(3, arrendatario.getApellidoPaterno());
			myStmt.setString(4, arrendatario.getApellidoMaterno());
			myStmt.setInt(5, arrendatario.getEdad());
			myStmt.setString(6, arrendatario.getCorreo());
			myStmt.setString(7, arrendatario.getCelular());
			myStmt.execute();

			PreparedStatement rs = oConnection.prepareStatement("SELECT id_arrendatario FROM arrendatario WHERE nombre1= ? AND apellidoPaterno = ? AND apellidoMaterno= ?");
			rs.setString(1, arrendatario.getNombre1());
			rs.setString(2, arrendatario.getApellidoPaterno());
			rs.setString(3, arrendatario.getApellidoMaterno());
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
