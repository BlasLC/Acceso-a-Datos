package ejercicio03.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ejercicio03.modelo.Pagos;

public class PagosDao {

	public List<Pagos> consultarPagos(Connection conn, Integer id) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		List<Pagos> lista = new ArrayList<Pagos>();
		try {
			String sql = "SELECT * FROM payment WHERE payment_id = " + id + ";";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pagos p = new Pagos();
				p.setImporte(rs.getBigDecimal("amount"));
				Date date = rs.getDate("payment_date");
				LocalDate fecha = date.toLocalDate();
				p.setFecha(fecha);
				lista.add(p);
			}
		} finally {
			try {
				stmt.close();
			} catch (Exception e2) {
			}
		}
		return lista;
	}

}
