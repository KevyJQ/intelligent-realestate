package com.intelligent.realestate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnnection {
	
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException {
		if (conn == null) {
			String cadenaConexion = "jdbc:mariadb://localhost/intelligent_realestate";	//va la direccion de la DB y el nombre de ella
			String usuario = "root";	//Ingresamos el Usuario 
			String contraseña = "Kevy12345.";
			conn = DriverManager.getConnection(cadenaConexion, usuario, contraseña);
		}
		return conn;
	}
}
