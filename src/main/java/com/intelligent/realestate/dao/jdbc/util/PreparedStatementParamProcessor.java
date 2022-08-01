package com.intelligent.realestate.dao.jdbc.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementParamProcessor {

	/*
	 * Hace el setting de los parametros en el {@code PreparedStatement}.
	 */
	public void process(PreparedStatement ps) throws SQLException;
}
