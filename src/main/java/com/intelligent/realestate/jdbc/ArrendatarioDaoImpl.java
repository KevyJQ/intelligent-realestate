package com.intelligent.realestate.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Direccion;

public class ArrendatarioDaoImpl implements ArrendatarioDao {

	Connection connection;

	public ArrendatarioDaoImpl(Connection conn) {
		this.connection = conn;
	}

	public Arrendatario findById(long arrendatarioId) {

		Arrendatario arrendatario = null;
		PreparedStatement pstmt;
		ResultSet rs;

		final String instruccionSQL = "SELECT id_arrendatario,nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular, " + "direccion1, direccion2, pais, ciudad, estado, CP "
				+ "FROM arrendatario " + "WHERE id_arrendatario = ? ";

		try {

			pstmt = connection.prepareStatement(instruccionSQL);
			pstmt.setLong(1, arrendatarioId);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				arrendatario = new Arrendatario();
				arrendatario.setDireccion(new Direccion());
				arrendatario.setIdArrendatario(rs.getLong(1));
				arrendatario.setNombre1(rs.getString(2));
				arrendatario.setNombre2(rs.getString(3));
				arrendatario.setApellidoPaterno(rs.getString(4));
				arrendatario.setApellidoMaterno(rs.getString(5));
				arrendatario.setEdad(rs.getInt(6));
				arrendatario.setCorreo(rs.getString(7));
				arrendatario.setCelular(rs.getString(8));
				arrendatario.getDireccion().setDireccion1(rs.getString(9));
				arrendatario.getDireccion().setDireccion2(rs.getString(10));
				arrendatario.getDireccion().setPais(rs.getString(11));
				arrendatario.getDireccion().setCiudad(rs.getString(12));
				arrendatario.getDireccion().setEstado(rs.getString(13));
				arrendatario.getDireccion().setCodigoPostal(rs.getString(14));

			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrendatario;

	}

	public List<Arrendatario> findByNameAndLasName(String name, String apellidoPaterno, String apellidoMaterno) {

		List<Arrendatario> arrendatarios = new ArrayList<Arrendatario>();
		PreparedStatement pstmt;
		ResultSet rs;

		final String instruccionSQL = "SELECT id_arrendatario, nombre1, nombre2, apellidoPaterno, "
				+ "apellidoMaterno, edad, correo, celular, direccion1, direccion2, pais, ciudad, estado, CP "
				+ "FROM arrendatario " + "WHERE nombre1= ? AND apellidoPaterno= ? AND apellidoMaterno= ?";

		try {
			pstmt = connection.prepareStatement(instruccionSQL);
			pstmt.setString(1, name);
			pstmt.setString(2, apellidoPaterno);
			pstmt.setString(3, apellidoMaterno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Arrendatario arrendatario = new Arrendatario();
				arrendatario.setDireccion(new Direccion());

				arrendatario.setIdArrendatario(rs.getLong(1));
				arrendatario.setNombre1(rs.getString(2));
				arrendatario.setNombre2(rs.getString(3));
				arrendatario.setApellidoPaterno(rs.getString(4));
				arrendatario.setApellidoMaterno(rs.getString(5));
				arrendatario.setEdad(rs.getInt(6));
				arrendatario.setCorreo(rs.getString(7));
				arrendatario.setCelular(rs.getString(8));
				arrendatario.getDireccion().setDireccion1(rs.getString(9));
				arrendatario.getDireccion().setDireccion1(rs.getString(10));
				arrendatario.getDireccion().setPais(rs.getString(11));
				arrendatario.getDireccion().setCiudad(rs.getString(12));
				arrendatario.getDireccion().setEstado(rs.getString(13));
				arrendatario.getDireccion().setCodigoPostal(rs.getString(14));

				arrendatarios.add(arrendatario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrendatarios;
	}

	public void insertArrendatario(Arrendatario arrendatario) {

		PreparedStatement pstmt;
		ResultSet rs;

		final String instruccionSQL = "INSERT INTO arrendatario"
				+ "(nombre1, nombre2, apellidoPaterno, apellidoMaterno, edad, correo, celular, "
				+ "direccion1, direccion2, pais, ciudad, estado, CP) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {

			pstmt = connection.prepareStatement(instruccionSQL, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, arrendatario.getNombre1());
			pstmt.setString(2, arrendatario.getNombre2());
			pstmt.setString(3, arrendatario.getApellidoPaterno());
			pstmt.setString(4, arrendatario.getApellidoMaterno());
			pstmt.setInt(5, arrendatario.getEdad());
			pstmt.setString(6, arrendatario.getCorreo());
			pstmt.setString(7, arrendatario.getCelular());
			pstmt.setString(8, arrendatario.getDireccion().getDireccion1());
			pstmt.setString(9, arrendatario.getDireccion().getDireccion2());
			pstmt.setString(10, arrendatario.getDireccion().getPais());
			pstmt.setString(11, arrendatario.getDireccion().getCiudad());
			pstmt.setString(12, arrendatario.getDireccion().getEstado());
			pstmt.setString(13, arrendatario.getDireccion().getCodigoPostal());

			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				arrendatario.setIdArrendatario(rs.getLong(1));
				System.out.println("\n\tTu id sera: " + arrendatario.getIdArrendatario() + "\n");
			} else {
				// TODO: throw an exception from here
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	public void findRE() {
//		PreparedStatement pstmt;
//		
//		final String intruccionSQL = "";
//	}

}
