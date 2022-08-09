package com.intelligent.realestate.dao.jdbc;

import static com.intelligent.realestate.dao.jdbc.util.JdbcUtil.insert;
import static com.intelligent.realestate.dao.jdbc.util.JdbcUtil.select;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Direccion;

public class ArrendadorDaoImpl implements ArrendadorDao { // Clase ArrendadorDaoImpl que usara la interface
	// ArrendadorDao
	private Connection connection; // Tiene una variable de tipo Connection que es global

	public ArrendadorDaoImpl(Connection conn) { // Constructor que inicializa la conexion
		this.connection = conn;
	}

	public Arrendador findById(long arrendadorId) {
		Arrendador arrendador = new Arrendador();

		final String instruccionSQL = "SELECT id_arrendador, nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular, direccion1, direccion2, pais, ciudad, estado, cp "
				+ "FROM arrendador " + "WHERE id_arrendador = ? ;";

		select(connection, instruccionSQL, (rs) -> {
			arrendador.setDireccion(new Direccion());
			arrendador.setIdArrendador(rs.getLong(1));
			arrendador.setNombre1(rs.getString(2));
			arrendador.setNombre2(rs.getString(3));
			arrendador.setApellidoPaterno(rs.getString(4));
			arrendador.setApellidoMaterno(rs.getString(5));
			arrendador.setEdad(rs.getInt(6));
			arrendador.setCorreo(rs.getString(7));
			arrendador.setCelular(rs.getString(8));
			arrendador.getDireccion().setDireccion1(rs.getString(9));
			arrendador.getDireccion().setDireccion2(rs.getString(10));
			arrendador.getDireccion().setPais(rs.getString(11));
			arrendador.getDireccion().setCiudad(rs.getString(12));
			arrendador.getDireccion().setEstado(rs.getString(13));
			arrendador.getDireccion().setCodigoPostal(rs.getString(14));
		}, arrendadorId);

		return arrendador;
	}

	public List<Arrendador> findByNameAndLasName(String name, String apellidoMaterno, String apellidoPaterno) {
		List<Arrendador> arrendadores = new ArrayList<Arrendador>(); // Creamos un arreglo de Arrendador

		final String instruccionSQL = "SELECT id_arrendador,nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular, direccion1, direccion2, pais, ciudad, estado, CP "
				+ "FROM arrendador " + "WHERE nombre1= ? AND apellidoPaterno= ? AND apellidoMaterno= ?";

		select(connection, instruccionSQL, (rs) -> {
			Arrendador arrendador = new Arrendador(); // Creamos un nuevo objeto de tipo Arrendador
			arrendador.setDireccion(new Direccion()); // Al objeto Arrendador le creamos una nueva Direccion
			arrendador.setIdArrendador(rs.getLong(1));
			arrendador.setNombre1(rs.getString(2));
			arrendador.setNombre2(rs.getString(3));
			arrendador.setApellidoPaterno(rs.getString(4));
			arrendador.setApellidoMaterno(rs.getString(5));
			arrendador.setEdad(rs.getInt(6));
			arrendador.setCorreo(rs.getString(7));
			arrendador.setCelular(rs.getString(8));
			arrendador.getDireccion().setDireccion1(rs.getString(9));
			arrendador.getDireccion().setDireccion2(rs.getString(10));
			arrendador.getDireccion().setPais(rs.getNString(11));
			arrendador.getDireccion().setCiudad(rs.getString(12));
			arrendador.getDireccion().setEstado(rs.getString(13));
			arrendador.getDireccion().setCodigoPostal(rs.getString(14));

			arrendadores.add(arrendador);
		}, name, apellidoPaterno, apellidoMaterno);

		return arrendadores; // regresamos el arreglo lleno
	}

	public void insertArrendador(Arrendador arrendador) {
		final String instruccionSQL = "INSERT INTO arrendador"
				+ "(nombre1, nombre2, apellidoPaterno, apellidoMaterno, edad, correo, celular"
				+ ", direccion1, direccion2, pais, ciudad, estado, CP) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		insert(connection, instruccionSQL, (pstmt) -> {
			pstmt.setString(1, arrendador.getNombre1());
			pstmt.setString(2, arrendador.getNombre2());
			pstmt.setString(3, arrendador.getApellidoPaterno());
			pstmt.setString(4, arrendador.getApellidoMaterno());
			pstmt.setInt(5, arrendador.getEdad());
			pstmt.setString(6, arrendador.getCorreo());
			pstmt.setString(7, arrendador.getCelular());
			pstmt.setString(8, arrendador.getDireccion().getDireccion1());
			pstmt.setString(9, arrendador.getDireccion().getDireccion2());
			pstmt.setString(10, arrendador.getDireccion().getPais());
			pstmt.setString(11, arrendador.getDireccion().getCiudad());
			pstmt.setString(12, arrendador.getDireccion().getEstado());
			pstmt.setString(13, arrendador.getDireccion().getCodigoPostal());
		}, (rs) -> {
			if (rs.next()) {
				arrendador.setIdArrendador(rs.getLong(1)); // Asignaos el la llave retornada a el atributo IdArrendador
				System.out.println("\n\tTu id sera: " + arrendador.getIdArrendador() + "\n");
			}
		});
	}

	public void insertRealEstate(Arrendador arrendador) {

		final String instruccionSQL = "INSERT INTO real_estate"
				+ "(id_arrendador, id_type_realestate, estatus, direccion1, direccion2, "
				+ "pais, ciudad, estado, CP, costoMin, costoMax) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		insert(connection, instruccionSQL, (pstmt) -> {
			pstmt.setLong(1, arrendador.getIdArrendador());
			pstmt.setInt(2, arrendador.getRealEstate().getRealEstateType().getId());
			pstmt.setString(3, arrendador.getRealEstate().getStatus());
			pstmt.setString(4, arrendador.getRealEstate().getDireccion().getDireccion1());
			pstmt.setString(5, arrendador.getRealEstate().getDireccion().getDireccion2());
			pstmt.setString(6, arrendador.getRealEstate().getDireccion().getPais());
			pstmt.setString(7, arrendador.getRealEstate().getDireccion().getCiudad());
			pstmt.setString(8, arrendador.getRealEstate().getDireccion().getEstado());
			pstmt.setString(9, arrendador.getRealEstate().getDireccion().getCodigoPostal());
			pstmt.setLong(10, arrendador.getRealEstate().getCostoMin());
			pstmt.setLong(11, arrendador.getRealEstate().getCostoMax());
		}, (rs) -> {
			// Si tuviera un ResultSet aqui se colocaria
		});

	}
}