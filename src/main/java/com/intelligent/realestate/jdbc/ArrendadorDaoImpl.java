package com.intelligent.realestate.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;


public class ArrendadorDaoImpl implements ArrendadorDao {
	Connection connection;

	public ArrendadorDaoImpl(Connection conn) {
		this.connection = conn;
	}

	public Arrendador findById(long arrendadorId) {

		Arrendador arrendador = null;
		PreparedStatement pstmt;
		ResultSet rs;

		final String instruccionSQL = "SELECT nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular FROM arrendador "
				+ "WHERE id_arrendador = ? ;";

		try {
			pstmt = connection.prepareStatement(instruccionSQL);
			pstmt.setLong(1, arrendadorId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				arrendador = new Arrendador();
				arrendador.setNombre1(rs.getString(1));
				arrendador.setNombre2(rs.getString(2));
				arrendador.setApellidoPaterno(rs.getString(3));
				arrendador.setApellidoMaterno(rs.getString(4));
				arrendador.setEdad(rs.getInt(5));
				arrendador.setCorreo(rs.getString(6));
				arrendador.setCelular(rs.getString(7));

			}
			System.out.println("ID: "+arrendadorId+"\nNombre: "+rs.getString(1)
			+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)
			+"\nEdad: "+rs.getInt(5)+"\nCorreo: "+rs.getString(6)+"\nCelular: "
			+rs.getString(7));

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return arrendador;
	}

	public List<Arrendador> findByNameAndLasName(String name, String apellidoMaterno, String apellidoPaterno){

		List<Arrendador> arrendadores = new ArrayList<Arrendador>();
		Arrendador arrendador = new Arrendador();

		PreparedStatement pstmt;
		ResultSet rs;

		int ID = 0;

		final String instruccionSQL = "SELECT id_arrendador,nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular FROM arrendador "
				+ "WHERE nombre1= ? AND apellidoPaterno= ? AND apellidoMaterno= ?";

		try {			
			pstmt = connection.prepareStatement(instruccionSQL);
			pstmt.setString(1,name);
			pstmt.setString(2,apellidoPaterno);
			pstmt.setString(3,apellidoMaterno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ID = rs.getInt(1);
				arrendador.setNombre1(rs.getString(2));
				arrendador.setNombre2(rs.getString(3));
				arrendador.setApellidoPaterno(rs.getString(4));
				arrendador.setApellidoMaterno(rs.getString(5));
				arrendador.setEdad(rs.getInt(6));
				arrendador.setCorreo(rs.getString(7));
				arrendador.setCelular(rs.getString(8));
				arrendadores.add(arrendador);
			}

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

		PreparedStatement pstmt;
		ResultSet rs;

		final String instruccionSQL = "INSERT INTO arrendador"
				+ "(nombre1, nombre2, apellidoPaterno, apellidoMaterno, edad, correo, celular) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {

			pstmt = connection.prepareStatement(instruccionSQL, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, arrendador.getNombre1());
			pstmt.setString(2, arrendador.getNombre2());
			pstmt.setString(3, arrendador.getApellidoPaterno());
			pstmt.setString(4, arrendador.getApellidoMaterno());
			pstmt.setInt(5, arrendador.getEdad());
			pstmt.setString(6, arrendador.getCorreo());
			pstmt.setString(7, arrendador.getCelular());
			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				arrendador.setIdArrendador(rs.getInt(1));
			} else {
				// TODO: throw an exception from here
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
