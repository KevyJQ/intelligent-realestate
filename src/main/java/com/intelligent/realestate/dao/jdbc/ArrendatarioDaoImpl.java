package com.intelligent.realestate.dao.jdbc;

import static com.intelligent.realestate.dao.jdbc.util.JdbcUtil.insert;
import static com.intelligent.realestate.dao.jdbc.util.JdbcUtil.select;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Direccion;

public class ArrendatarioDaoImpl implements ArrendatarioDao {

	private Connection connection;

	public ArrendatarioDaoImpl(Connection conn) {
		this.connection = conn;
	}

	public Arrendatario findById(long arrendatarioId) {
		Arrendatario arrendatario = new Arrendatario();

		final String instruccionSQL = "SELECT id_arrendatario,nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular, " + "direccion1, direccion2, pais, ciudad, estado, cp "
				+ "FROM arrendatario " + "WHERE id_arrendatario = ? ";

		int resultados = select(connection, instruccionSQL, (rs) -> {
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
		}, arrendatarioId);

		return resultados > 0 ? arrendatario : null;
	}

	public List<Arrendatario> findByNameAndLasName(String name, String apellidoPaterno, String apellidoMaterno) {
		List<Arrendatario> arrendatarios = new ArrayList<Arrendatario>();

		final String instruccionSQL = "SELECT id_arrendatario, nombre1, nombre2, apellidoPaterno, "
				+ "apellidoMaterno, edad, correo, celular, direccion1, direccion2, pais, ciudad, estado, CP "
				+ "FROM arrendatario " + "WHERE nombre1= ? AND apellidoPaterno= ? AND apellidoMaterno= ?";

		select(connection, instruccionSQL, (rs) -> {

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
		}, name, apellidoPaterno, apellidoMaterno);

		return arrendatarios;
	}

	public void insertArrendatario(Arrendatario arrendatario) {
		final String instruccionSQL = "INSERT INTO arrendatario"
				+ "(nombre1, nombre2, apellidoPaterno, apellidoMaterno, edad, correo, celular, "
				+ "direccion1, direccion2, pais, ciudad, estado, CP) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		insert(connection, instruccionSQL, (pstmt) -> {
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
		}, (rs) -> {
			if (rs.next()) {
				arrendatario.setIdArrendatario(rs.getLong(1));
				System.out.println("\n\tTu id sera: " + arrendatario.getIdArrendatario() + "\n");
			}
		});
	}

}
