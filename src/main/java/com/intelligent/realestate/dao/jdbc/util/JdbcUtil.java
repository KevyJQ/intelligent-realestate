package com.intelligent.realestate.dao.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.intelligent.realestate.exceptions.Exceptions.DbException;

public class JdbcUtil {

	public static int select(Connection conn, String sql, ResultSetProcessor processor, Object... params) {
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			int cnt = 1;

			// Set the parameters for the PreparedStatement.
			for (Object param : params) {
				ps.setObject(cnt++, param);
			}

			// Procesa los resultdos en el ResultSet.
			try (ResultSet rs = ps.executeQuery()) {
				int resultados = 0;
				while (rs.next()) {
					processor.process(rs);
					resultados++;
				}
				return resultados;
			} catch (SQLException ex) {
				throw new DbException(ex);
			}
		} catch (SQLException ex) {
			throw new DbException(ex);
		}
	}

	/*
	 * Inserta una fila en la base de datos. La llave primaria es generada por la
	 * base de datos.
	 */
	public static int insert(Connection conn, String sql, PreparedStatementParamProcessor paramProcessor,
			ResultSetProcessor processorGeneratedKeys) {
		int numInserts = 0;
		try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			// Sets los parametros.
			paramProcessor.process(ps);

			numInserts = ps.executeUpdate();

			// Obtiene las llaves primarias generadas.
			try (ResultSet rs = ps.getGeneratedKeys()) {
				processorGeneratedKeys.process(rs);
			} catch (SQLException ex) {
				throw new DbException(ex);
			}
		} catch (SQLException ex) {
			throw new DbException(ex);
		}

		return numInserts;
	}

	public static int update(Connection conn, String sql, PreparedStatementParamProcessor paramProcessor) {
		int numUpdates = 0;
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			// Sets los parametros.
			paramProcessor.process(ps);
			numUpdates = ps.executeUpdate();

		} catch (SQLException ex) {
			throw new DbException(ex);
		}

		return numUpdates;
	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException ex) {
			throw new DbException(ex);
		}
	}
}
