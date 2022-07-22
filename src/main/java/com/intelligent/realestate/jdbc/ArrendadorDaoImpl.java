package com.intelligent.realestate.jdbc;

import static com.intelligent.realestate.jdbc.util.JdbcUtil.select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Direccion;

public class ArrendadorDaoImpl implements ArrendadorDao { // Clase ArrendadorDaoImpl que usara la interface
															// ArrendadorDao
	Connection connection; // Tiene una variable de tipo Connection que es global

	public ArrendadorDaoImpl(Connection conn) { // Constructor que inicializa la conexion
		this.connection = conn;

	}

	public Arrendador findById(long arrendadorId) { // Metodo buscar por ID que recibe un ID
		Arrendador arrendador = null; // Inicializamos la Arrendador con null
		PreparedStatement pstmt;
		/*
		 * La interfas PreparedStatement representa una delcaracion de SQL pre-copilada
		 * lo que nos permitira es mandar una instruccion parametrizada que le podemos
		 * pasar 0 o mas parametros
		 * 
		 */

		ResultSet rs;
		/*
		 * Es el ResulSet es un objeto que que representa un conjunto de resultados de
		 * la base de datos que generalmente se genera al ejecutar una declaracion de
		 * consulta a la base de datos
		 * 
		 */

		final String instruccionSQL = "SELECT id_arrendador, nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular," + "direccion1, direccion2, pais, ciudad, estado, CP "
				+ "FROM arrendador " + "WHERE id_arrendador = ? ;";
		/*
		 * Mandamos la instrucionSQL que queremos que se ejecute en nustra base de
		 * datos, en este caso es una busqueda usando un SELECT
		 * 
		 */

		try {
			/*
			 * La funcion Try ejecutara una sentencia de bloque que si ocurre un error tiene
			 * un bloque llamado Exception que se ejecutara si el Try falla
			 * 
			 */
			pstmt = connection.prepareStatement(instruccionSQL);
			/*
			 * Se realiza la conexion a la base de datos, usamos el prepareStatement para
			 * despues mandarle cuales son los paramatros que queremos que filtre y al final
			 * le mandamos la instruccionSQL(Query)
			 */
			pstmt.setLong(1, arrendadorId);
			/*
			 * Como podemos ver, aqui es donde le mandamos los parametros del
			 * prepareStatement, donde el numero 1 indica que en el primer signo "?"
			 * queremos que lo cambie por el numero que trae arrendadorId
			 */
			rs = pstmt.executeQuery(); // Indicamos que el reultado de ejecutar la Query se asigne al ResulSet

			if (rs.next()) { // En esta seccion asignamos los valores que regreso despues de haber consultado
								// la base de datos
				arrendador = new Arrendador();
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
			}

		} catch (SQLException e) { // La Exception del Try
			e.printStackTrace(); // En dado caso que el Try falle, nos mostrara en pantalla le Exception del
									// error
		}

		return arrendador; // Regresamos el objeto arrendador con todos los datos guardados
	}

	public List<Arrendador> findByNameAndLasName(
			String name, String apellidoMaterno, String apellidoPaterno) {
		List<Arrendador> arrendadores = new ArrayList<Arrendador>(); // Creamos un arreglo de Arrendador

		final String instruccionSQL = "SELECT id_arrendador,nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular, direccion1, direccion2, pais, ciudad, estado, CP "
				+ "FROM arrendador "
				+ "WHERE nombre1= ? AND apellidoPaterno= ? AND apellidoMaterno= ?";

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

			arrendadores.add(arrendador); // Guardamos el objeto arrendador en el arreglo previamente declarado
		}, name, apellidoPaterno, apellidoMaterno);

		return arrendadores; // regresamos el arreglo lleno
	}

	public void insertArrendador(Arrendador arrendador) {
		PreparedStatement pstmt;
		ResultSet rs;

		final String instruccionSQL = "INSERT INTO arrendador"
				+ "(nombre1, nombre2, apellidoPaterno, apellidoMaterno, edad, correo, celular"
				+ ", direccion1, direccion2, pais, ciudad, estado, CP) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {

			pstmt = connection.prepareStatement(instruccionSQL, Statement.RETURN_GENERATED_KEYS);
			/*
			 * A diferencia de las pasadas ahora aumentamos la sentencia
			 * Statement.RETURN_GENERATED_KEYS que nos permitira regresar el ID generado
			 * automaticamente por la base de datos
			 */
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

			pstmt.executeUpdate(); // Le decimos que nos devuelva un entero del numero de registro que afecto con
									// la operacion(Query)
			rs = pstmt.getGeneratedKeys(); // Retorna el valor de la columna modificada

			if (rs.next()) {
				arrendador.setIdArrendador(rs.getLong(1)); // Asignaos el la llave retornada a el atributo IdArrendador
				System.out.println("\n\tTu id sera: " + arrendador.getIdArrendador() + "\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertRealEstate(Arrendador arrendador) {
		PreparedStatement pstmt;

		final String instruccionSQL = "INSERT INTO real_estate"
				+ "(id_arrendador, id_type_realestate, estatus, direccion1, direccion2, pais, ciudad, estado, CP) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = connection.prepareStatement(instruccionSQL);
			pstmt.setLong(1, arrendador.getIdArrendador());
			pstmt.setInt(2, arrendador.getRealEstate().getRealEstateType().getId());
			pstmt.setString(3, arrendador.getRealEstate().getStatus());
			pstmt.setString(4, arrendador.getRealEstate().getDireccion().getDireccion1());
			pstmt.setString(5, arrendador.getRealEstate().getDireccion().getDireccion2());
			pstmt.setString(6, arrendador.getRealEstate().getDireccion().getPais());
			pstmt.setString(7, arrendador.getRealEstate().getDireccion().getCiudad());
			pstmt.setString(8, arrendador.getRealEstate().getDireccion().getEstado());
			pstmt.setString(9, arrendador.getRealEstate().getDireccion().getCodigoPostal());

			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
