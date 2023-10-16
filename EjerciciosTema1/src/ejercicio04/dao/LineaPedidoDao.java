package ejercicio04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicio04.modelo.LineaPedido;

public class LineaPedidoDao {
	public Long insertarLista(Connection conn, LineaPedido linea) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"INSERT INTO pedidos_lineas(id_pedido, numero_linea, articulo, precio) VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, linea.getIdPedido());
			stmt.setInt(2, linea.getNumeroLinea());
			stmt.setString(3, linea.getArticulo());
			stmt.setBigDecimal(4, linea.getPrecio());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();

			return rs.getLong(1);
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}
	}
}
