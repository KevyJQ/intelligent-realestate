package com.intelligent.realestate.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.model.Arrendatario;

public class ArrendatarioDaoImpl implements ArrendatarioDao {

	Connection connection;

	public ArrendatarioDaoImpl(Connection conn) {
		this.connection = conn;
	}

	public Arrendatario findById(long arrendatarioId) {

		PreparedStatement pstmt;
		ResultSet rs;

		final String instruccionSQL = "SELECT nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular FROM arrendatario "
				+ "WHERE id_arrendatario = ? ;";

		Arrendatario arrendatario = null;
		try {

			pstmt = connection.prepareStatement(instruccionSQL);
			pstmt.setLong(1, arrendatarioId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				arrendatario = new Arrendatario();
				arrendatario.setNombre1(rs.getString(1));
				arrendatario.setNombre2(rs.getString(2));
				arrendatario.setApellidoPaterno(rs.getString(3));
				arrendatario.setApellidoMaterno(rs.getString(4));
				arrendatario.setEdad(rs.getInt(5));
				arrendatario.setCorreo(rs.getString(6));
				arrendatario.setCelular(rs.getString(7));

			}
			System.out.println("ID: "+arrendatarioId+"\nNombre: "+rs.getString(1)
			+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)
			+"\nEdad: "+rs.getInt(5)+"\nCorreo: "+rs.getString(6)+"\nCelular: "
			+rs.getString(7));

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return arrendatario;

	}

	public List<Arrendatario> findByNameAndLasName(String name,String apellidoPaterno,String apellidoMaterno){

		List<Arrendatario> arrendatarios = new ArrayList<Arrendatario>();
		Arrendatario arrendatario = new Arrendatario();

		PreparedStatement pstmt;
		ResultSet rs;

		int ID = 0;

		final String instruccionSQL = "SELECT id_arrendatario,nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular FROM arrendatario "
				+ "WHERE nombre1= ? AND apellidoPaterno= ? AND apellidoMaterno= ?";

		try {
			pstmt = connection.prepareStatement(instruccionSQL);
			pstmt.setString(1,name);
			pstmt.setString(2,apellidoPaterno);
			pstmt.setString(3,apellidoMaterno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ID = rs.getInt(1);
				arrendatario.setNombre1(rs.getString(2));
				arrendatario.setNombre2(rs.getString(3));
				arrendatario.setApellidoPaterno(rs.getString(4));
				arrendatario.setApellidoMaterno(rs.getString(5));
				arrendatario.setEdad(rs.getInt(6));
				arrendatario.setCorreo(rs.getString(7));
				arrendatario.setCelular(rs.getString(8));
				arrendatarios.add(arrendatario);
			}

			for(Arrendatario arre : arrendatarios) {
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

		return arrendatarios;
	}

	public void insertArrendatario(Arrendatario arrendatario) {

		PreparedStatement pstmt;
		ResultSet rs;

		final String instruccionSQL = "INSERT INTO arrendatario"
				+ "(nombre1, nombre2, apellidoPaterno, apellidoMaterno, edad, correo, celular) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {

			pstmt = connection.prepareStatement(instruccionSQL, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, arrendatario.getNombre1());
			pstmt.setString(2, arrendatario.getNombre2());
			pstmt.setString(3, arrendatario.getApellidoPaterno());
			pstmt.setString(4, arrendatario.getApellidoMaterno());
			pstmt.setInt(5, arrendatario.getEdad());
			pstmt.setString(6, arrendatario.getCorreo());
			pstmt.setString(7, arrendatario.getCelular());
			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				arrendatario.setIdArrendatario(rs.getInt(1));
			} else {
				// TODO: throw an exception from here
			}

			System.out.println("\nInsert exitoso..");
		}catch(SQLException e){
			e.printStackTrace();
		}

	}
}
