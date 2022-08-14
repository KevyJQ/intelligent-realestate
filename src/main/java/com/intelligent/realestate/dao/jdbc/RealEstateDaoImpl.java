package com.intelligent.realestate.dao.jdbc;

import static com.intelligent.realestate.dao.jdbc.util.JdbcUtil.insert;
import static com.intelligent.realestate.dao.jdbc.util.JdbcUtil.select;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.model.Direccion;
import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.model.TypeRealEstate;

public class RealEstateDaoImpl implements RealEstateDao {
	private Connection connection;

	public RealEstateDaoImpl(Connection conn) {
		this.connection = conn;
	}

	@Override
	public List<RealEstate> selectRealEstate(String pais, String ciudad, String status) {

		List<RealEstate> realestate = new ArrayList<RealEstate>();

		final String instruccionSQL = "SELECT id_realestate, id_arrendador, id_type_realestate, "
				+ "estatus, direccion1, direccion2, pais, ciudad, estado, cp , costo_min, costo_max " + "FROM real_estate "
				+ "WHERE pais= ? AND ciudad= ? AND estatus= ?";

		select(connection, instruccionSQL, (rs) -> {

			RealEstate realestat = new RealEstate();
			realestat.setDireccion(new Direccion());

			realestat.setIdRealEstate(rs.getLong(1));
			realestat.setArrendadadorId(rs.getLong(2));
			TypeRealEstate typeRealEstate[] = TypeRealEstate.values(); 
			realestat.setRealEstateType(typeRealEstate[rs.getInt(3)]);
			realestat.setStatus(rs.getString(4));
			realestat.getDireccion().setDireccion1(rs.getString(5));
			realestat.getDireccion().setDireccion2(rs.getString(6));
			realestat.getDireccion().setPais(rs.getString(7));
			realestat.getDireccion().setCiudad(rs.getString(8));
			realestat.getDireccion().setEstado(rs.getString(9));
			realestat.getDireccion().setCodigoPostal(rs.getString(10));
			realestat.setCostoMin(rs.getDouble(11));
			realestat.setCostoMax(rs.getDouble(12));


			realestate.add(realestat);

		}, pais, ciudad, status);

		return realestate;
	}

	public void insertRealEstate(RealEstate realEstate) {

		final String instruccionSQL = "INSERT INTO real_estate"
				+ "(id_arrendador, id_type_realestate, estatus, direccion1, direccion2, "
				+ "pais, ciudad, estado, cp, costo_min, costo_max) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		insert(connection, instruccionSQL, (pstmt) -> {
			pstmt.setLong(1, realEstate.getArrendadadorId());
			pstmt.setInt(2, realEstate.getRealEstateType().getId());
			pstmt.setString(3, realEstate.getStatus());
			pstmt.setString(4, realEstate.getDireccion().getDireccion1());
			pstmt.setString(5, realEstate.getDireccion().getDireccion2());
			pstmt.setString(6, realEstate.getDireccion().getPais());
			pstmt.setString(7, realEstate.getDireccion().getCiudad());
			pstmt.setString(8, realEstate.getDireccion().getEstado());
			pstmt.setString(9, realEstate.getDireccion().getCodigoPostal());
			pstmt.setDouble(10, realEstate.getCostoMin());
			pstmt.setDouble(11, realEstate.getCostoMax());
		}, (rs) -> {
			if (rs.next()) {
				// Asignar la llave generad a el atributo IdRealEstate.
				realEstate.setIdRealEstate(rs.getLong(1));
			}
		});
	}
}
