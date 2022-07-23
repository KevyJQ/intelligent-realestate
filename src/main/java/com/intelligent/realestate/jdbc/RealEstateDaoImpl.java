package com.intelligent.realestate.jdbc;

import static com.intelligent.realestate.jdbc.util.JdbcUtil.select;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Direccion;
import com.intelligent.realestate.model.RealEstate;

public class RealEstateDaoImpl implements RealEstateDao{
	private Connection connection;

	public RealEstateDaoImpl(Connection conn) {
		this.connection = conn;
	}

	@Override
	public List<RealEstate> selectRealEstate(String pais, String ciudad, String status) {
		
		List<RealEstate> realestate = new ArrayList<RealEstate>();
		
		final String instruccionSQL = "SELECT id_realestate, estatus, "
				+ "direccion1, direccion2, pais, ciudad, estado, CP "
				+ "FROM real_estate "
				+ "WHERE pais= ? AND ciudad= ? AND estatus= ?";

		select(connection, instruccionSQL, (rs)->{
			
			RealEstate realestat = new RealEstate();
			realestat.setDireccion(new Direccion());
			
			realestat.setIdRealEstate(rs.getLong(1));
			realestat.setStatus(rs.getString(2));
			realestat.getDireccion().setDireccion1(rs.getString(3));
			realestat.getDireccion().setDireccion2(rs.getString(4));
			realestat.getDireccion().setPais(rs.getString(5));
			realestat.getDireccion().setCiudad(rs.getString(6));
			realestat.getDireccion().setEstado(rs.getString(7));
			realestat.getDireccion().setCodigoPostal(rs.getString(8));

			realestate.add(realestat);
			
		}, pais,ciudad,status);
		
		return realestate;
	}

	

}
