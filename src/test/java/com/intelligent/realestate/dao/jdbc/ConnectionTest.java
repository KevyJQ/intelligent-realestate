package com.intelligent.realestate.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ConnectionTest {

	/*
	 * Regresa una nueva Connection.
	 */
	private Connection getConnection() throws SQLException {
		String cadenaConexion = "jdbc:mariadb://localhost:3306/intelligent_realestate";
		/*
		 * va la direccion de la DB y el nombre de ella
		 */
		String usuario = "root"; // Ingresamos el Usuario
		String contraseña = "Kevy12345."; // Ingresamos la contraseña
		return DriverManager.getConnection(cadenaConexion, usuario, contraseña);
	}

	/*
	 * Prueba cuantas conexiones concurrentes MariaDB soporta:
	 *
	 * Para checar en MariDB el maximo de conexiones soportadas y el numero de
	 * conexiones concurrentes, usa:
	 *
	 * show variables like "max_connections"; show status where `variable_name` =
	 * 'Threads_connected';
	 */
	@Test
	public void testNumeroConnectionsConcurrentes() throws SQLException, InterruptedException {
		List<Connection> connections = new ArrayList<>();

		// int numConnections = 150;
		int numConnections = 10;
		
		int i = 0;

		for (i = 0; i < numConnections; i++) {
			connections.add(getConnection());
		}

		for (i = 0; i < numConnections; i++) {
			Thread.sleep(100);
			System.out.println("Closing connection " + i);
			Connection con = connections.get(i);
			con.close();
		}
	}
}
