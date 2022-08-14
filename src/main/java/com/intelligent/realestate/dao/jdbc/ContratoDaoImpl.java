package com.intelligent.realestate.dao.jdbc;

import static com.intelligent.realestate.dao.jdbc.util.JdbcUtil.insert;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import com.intelligent.realestate.dao.ContratoDao;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Contrato;

public class ContratoDaoImpl implements ContratoDao{
	private Connection connection;
	
	public ContratoDaoImpl(Connection conn) {
		this.connection = conn;
	}
	
	@Override
	public void guardarContrato(Contrato contrato) {
		final String instruccionSQL = "INSERT INTO contrato " + "(id_arrendador, id_arrendatario, id_realestate, fecha_inicio, fecha_corte, costo)"
				+ "VALUES ( ?, ?, ?, ?, ?, ?)";
		insert(connection, instruccionSQL, (pstmt) -> {
			pstmt.setLong(1, contrato.getArrendador().getIdArrendador());
			pstmt.setLong(2, contrato.getArrendatario().getIdArrendatario());
			pstmt.setLong(3, contrato.getRealEstate().getIdRealEstate());
			pstmt.setDate(4, new Date(contrato.getFechaInicio().getTime()));
			pstmt.setDate(5, new Date(contrato.getFechaFinal().getTime()));
			pstmt.setDouble(6, contrato.getRealEstate().getCostoOfertado());
		}, (rs) -> {
			if (rs.next()) {
				contrato.setIdContrato(rs.getLong(1));
			}
		});
		
	}

	@Override
	public List<Contrato> buscarPorArrendador(Arrendador arrendador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contrato> buscarPorArrendatario(Arrendatario arrendatario) {
		// TODO Auto-generated method stub
		return null;
	}

}
