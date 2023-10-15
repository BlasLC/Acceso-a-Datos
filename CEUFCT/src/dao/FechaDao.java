package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Fecha;

public class FechaDao {

	/**
	 * Método para consultar fechas de la tabla Fechas filtrando por el año y la
	 * evaluación, las devuelve en una lista
	 * 
	 * @param conn
	 * @param año
	 * @param eva
	 * @return List<Fecha>
	 * @throws SQLException
	 */

	public List<Fecha> consultarFechas(Connection conn, Integer año, Integer eva) throws SQLException {
		ResultSet rs = null;
		Statement stmt = null;

		List<Fecha> listaFecha = new ArrayList<Fecha>();
		String sql = "SELECT * FROM fechas WHERE año = " + año + " AND evaluación = " + eva;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Fecha fecha = new Fecha();
				fecha.setFecha(rs.getDate("fecha").toLocalDate());
				fecha.setAño(rs.getInt("año"));
				fecha.setEvaluación(rs.getInt("evaluacion"));
				fecha.setDisponibilidad(rs.getBoolean("disponibilidad"));
				listaFecha.add(fecha);
			}
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}

		return listaFecha;
	}

}
