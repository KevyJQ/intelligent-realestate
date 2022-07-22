package com.intelligent.realestate.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.intelligent.realestate.exceptions.Exceptions.DbException;

public class JdbcUtil {

	public static void select(Connection connection, String sql,
			ResultSetProcessor processor, Object... params) {
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			
			int cnt = 1;

			// Set the parameters for the PreparedStatement.
			for (Object param : params) {
				ps.setObject(cnt++, param);
			}

			// Procesa los resultdos en el ResultSet.
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					processor.process(rs);
				}
			} catch (SQLException ex) {
				throw new DbException(ex);
			}
		} catch (SQLException ex) {
			throw new DbException(ex);
		}
	}
}
