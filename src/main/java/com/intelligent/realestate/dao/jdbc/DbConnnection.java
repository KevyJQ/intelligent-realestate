package com.intelligent.realestate.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.intelligent.realestate.exceptions.Exceptions.DbException;

public class DbConnnection {

	private static Connection conn;

	/*
	 * @return Una Connection. Si el Connection ya existe, regresa el que ya existe,
	 * de otra manera, crea uno. Implementa el patro Singleton.
	 */
	public static Connection getConnection() {
		if (conn == null) {
			String cadenaConexion = "jdbc:mariadb://localhost:3306/intelligent_realestate";
			/*
			 * va la direccion de la DB y el nombre de ella
			 */
			String usuario = "root"; // Ingresamos el Usuario
			String contraseña = "Kevy12345."; // Ingresamos la contraseña
			try {
				conn = DriverManager.getConnection(cadenaConexion, usuario, contraseña);
			} catch (SQLException ex) {
				throw new DbException(ex);
			}
		}

		return conn;
	}
}
