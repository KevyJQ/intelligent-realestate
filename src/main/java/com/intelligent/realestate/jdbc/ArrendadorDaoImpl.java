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
import com.intelligent.realestate.model.Direccion;



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
				+ "apellidoMaterno,edad,correo,celular,"
				+ "direccion1, direccion2, pais, ciudad, estado, CP "
				+ "FROM arrendador "
				+ "WHERE id_arrendador = ? ;";

		try {
			pstmt = connection.prepareStatement(instruccionSQL);
			pstmt.setLong(1, arrendadorId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				arrendador = new Arrendador();
				arrendador.setDireccion(new Direccion());
				
				arrendador.setNombre1(rs.getString(1));
				arrendador.setNombre2(rs.getString(2));
				arrendador.setApellidoPaterno(rs.getString(3));
				arrendador.setApellidoMaterno(rs.getString(4));
				arrendador.setEdad(rs.getInt(5));
				arrendador.setCorreo(rs.getString(6));
				arrendador.setCelular(rs.getString(7));
				arrendador.getDireccion().setDireccion1(rs.getString(8));
				arrendador.getDireccion().setDireccion2(rs.getString(9));
				arrendador.getDireccion().setPais(rs.getString(10));
				arrendador.getDireccion().setCiudad(rs.getString(11));
				arrendador.getDireccion().setEstado(rs.getString(12));
				arrendador.getDireccion().setCodigoPostal(rs.getString(13));

			}else {
				return null;
			}
			System.out.println("ID: "+arrendadorId+"\nNombre: "+rs.getString(1)
			+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)
			+"\nEdad: "+rs.getInt(5)+"\nCorreo: "+rs.getString(6)+"\nCelular: "
			+rs.getString(7)+"\nDireccion1: "+rs.getString(8)+"\nDireccion2: "+rs.getString(9)
			+"\nPais: "+rs.getString(10)+"\nCiudad: "+rs.getString(11)+"\nEstado: "+rs.getString(12)
			+"\nCodigo Postal: "+rs.getString(13));

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return arrendador;
	}

	public List<Arrendador> findByNameAndLasName(String name, String apellidoMaterno, String apellidoPaterno){

		List<Arrendador> arrendadores = new ArrayList<Arrendador>();
		Arrendador arrendador = new Arrendador();
		arrendador.setDireccion(new Direccion());

		PreparedStatement pstmt;
		ResultSet rs;

		int ID = 0;

		final String instruccionSQL = 
				"SELECT id_arrendador,nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular, "
				+ "direccion1, direccion2, pais, ciudad, estado, CP "
				+ "FROM arrendador "
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
				arrendador.getDireccion().setDireccion1(rs.getString(9));
				arrendador.getDireccion().setDireccion2(rs.getString(10));
				arrendador.getDireccion().setPais(rs.getNString(11));
				arrendador.getDireccion().setCiudad(rs.getString(12));
				arrendador.getDireccion().setEstado(rs.getString(13));
				arrendador.getDireccion().setCodigoPostal(rs.getString(14));
				
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
				System.out.print("\nDireccion: "+arre.getDireccion().getDireccion1());
				System.out.print(" "+arre.getDireccion().getDireccion2());
				System.out.print("\nPais: "+arre.getDireccion().getPais());
				System.out.print("\nCiudad: "+arre.getDireccion().getCiudad());
				System.out.print("\nEstado: "+arre.getDireccion().getEstado());
				System.out.print("\nCodigo Postal: "+arre.getDireccion().getCodigoPostal());
				System.out.println();
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
				+ "(nombre1, nombre2, apellidoPaterno, apellidoMaterno, edad, correo, celular"
				+ ", direccion1, direccion2, pais, ciudad, estado, CP) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {

			pstmt = connection.prepareStatement(instruccionSQL, Statement.RETURN_GENERATED_KEYS);
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

			
			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				arrendador.setIdArrendador(rs.getInt(1));
				System.out.println("\n\tTu id sera: "+arrendador.getIdArrendador()+"\n");
			} else {
				// TODO: throw an exception from here
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
