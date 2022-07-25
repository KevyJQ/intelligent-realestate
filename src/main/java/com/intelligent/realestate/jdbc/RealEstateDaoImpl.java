package com.intelligent.realestate.jdbc;

import static com.intelligent.realestate.jdbc.util.JdbcUtil.select;
import static com.intelligent.realestate.jdbc.util.JdbcUtil.insert;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Direccion;
import com.intelligent.realestate.model.RealEstate;

public class RealEstateDaoImpl implements RealEstateDao {
	private Connection connection;

	public RealEstateDaoImpl(Connection conn) {
		this.connection = conn;
	}

	@Override
	public List<RealEstate> selectRealEstate(String pais, String ciudad, String status) {

		List<RealEstate> realestate = new ArrayList<RealEstate>();

		final String instruccionSQL = "SELECT id_realestate, id_arrendador, id_type_realestate, "
				+ "estatus, direccion1, direccion2, pais, ciudad, estado, CP " + "FROM real_estate "
				+ "WHERE pais= ? AND ciudad= ? AND estatus= ?";

		select(connection, instruccionSQL, (rs) -> {

			RealEstate realestat = new RealEstate();
			realestat.setDireccion(new Direccion());

			realestat.setIdRealEstate(rs.getLong(1));
			realestat.setArrendadadorId(rs.getLong(2));
			realestat.setId_typeRE(rs.getInt(3));
			realestat.setStatus(rs.getString(4));
			realestat.getDireccion().setDireccion1(rs.getString(5));
			realestat.getDireccion().setDireccion2(rs.getString(6));
			realestat.getDireccion().setPais(rs.getString(7));
			realestat.getDireccion().setCiudad(rs.getString(8));
			realestat.getDireccion().setEstado(rs.getString(9));
			realestat.getDireccion().setCodigoPostal(rs.getString(10));

			realestate.add(realestat);

		}, pais, ciudad, status);

		return realestate;
	}

	public void insertContrato(RealEstate realestate, Arrendatario arrendatario) {

		final String instruccionSQL = "INSERT INTO contrato " + "(id_arrendador, id_arrendatario, id_realestate)"
				+ "VALUES (?,?,?)";
		insert(connection, instruccionSQL, (pstmt) -> {
			pstmt.setLong(1, realestate.getArrendadadorId());
			pstmt.setLong(2, arrendatario.getIdArrendatario());
			pstmt.setLong(3, realestate.getIdRealEstate());
		}, (rs) -> {
			if (rs.next()) {
				arrendatario.setIdContrato(rs.getLong(1));
				System.out.println("\n\tID del Contrato: " + arrendatario.getIdContrato() + "\n");
			}
		});
	}

}
