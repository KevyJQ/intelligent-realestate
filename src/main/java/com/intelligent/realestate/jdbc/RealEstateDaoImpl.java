package com.intelligent.realestate.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.model.Direccion;
import com.intelligent.realestate.model.RealEstate;

public class RealEstateDaoImpl implements RealEstateDao{
	Connection connection;

	public RealEstateDaoImpl(Connection conn) {
		this.connection = conn;
	}

	@Override
	public List<RealEstate> realEstate() {
		
		List<RealEstate> realestate = new ArrayList<>();
		
		PreparedStatement pstmt;
		ResultSet rs;
		
		//Por modificar para Real Estate
		final String instruccionSQL = "SELECT id_arrendatario,nombre1,nombre2,apellidoPaterno,"
				+ "apellidoMaterno,edad,correo,celular, " + "direccion1, direccion2, pais, ciudad, estado, CP "
				+ "FROM arrendatario " + "WHERE id_arrendatario = ? ";

		try {

			pstmt = connection.prepareStatement(instruccionSQL);
			//pstmt.setLong(1, arrendatarioId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				RealEstate realest = new RealEstate();
				realest.setDireccion(new Direccion());


			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return realestate;
	}
	

}
