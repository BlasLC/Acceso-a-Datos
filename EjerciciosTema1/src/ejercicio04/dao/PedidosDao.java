package ejercicio04.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import ejercicio04.modelo.Pedido;

public class PedidosDao {
	public void insertarPedido(Connection conn, Pedido pedido) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO pedidos(id_pedido, fechaPedido, fechaEntrega, cliente) VALUES(?,?,?,?,?)");
		stmt.setLong(1, pedido.getIdPedido());
		LocalDate fechaPedidoLocal = pedido.getFechaPedido();
		Date fechaPedidoDate = Date.valueOf(fechaPedidoLocal);
		stmt.setDate(2, fechaPedidoDate);
		LocalDate fechaEntregaLocal = pedido.getFechaEntrega();
		Date fechaEntregaDate = Date.valueOf(fechaEntregaLocal);
		stmt.setDate(3, fechaEntregaDate);
		stmt.setString(4, pedido.getCliente());
		stmt.execute();
		System.out.println("Se ha insertado");
	}
}
