package ejercicio03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio03.modelo.Clientes;

public class ClientesDao {
	public List<Clientes> consultarClientes(Connection conn) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;

		try {
			List<Clientes> lista = new ArrayList<Clientes>();
			String sql = "SELECT * FROM customer";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Clientes c = new Clientes();
				c.setId(rs.getInt("customer_id"));
				c.setFirstName(rs.getString("first_name"));
				c.setLastName(rs.getString("last_name"));
				c.setEmail(rs.getString("email"));
				c.setActivo(rs.getBoolean("active"));
				lista.add(c);
			}
			return lista;

		} finally {
			try {
				stmt.close();
			} catch (Exception e2) {
			}
		}

	}
}
