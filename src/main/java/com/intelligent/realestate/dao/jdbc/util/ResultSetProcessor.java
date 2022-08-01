package com.intelligent.realestate.dao.jdbc.util;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetProcessor {

	/**
	 * Procesa {@code ResultSet} objects.
	 */
	public void process(ResultSet rs) throws SQLException;
}