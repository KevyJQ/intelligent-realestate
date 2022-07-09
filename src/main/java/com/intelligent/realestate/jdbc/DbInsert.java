package com.intelligent.realestate.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.intelligent.realestate.model.Arrendador;


public class DbInsert {

	Connection oConnection;
	String instruccionSQL;

	public DbInsert(Connection conn) {
		this.oConnection = conn;
	}

	public void insertData(Arrendador arrendador) throws SQLException {

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
			boolean res = myStmt.execute();
			
			System.out.println("Insert exitoso..");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
