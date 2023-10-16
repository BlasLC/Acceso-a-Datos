package ejercicio04.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejercicio04.dao.LineaPedidoDao;
import ejercicio04.dao.PedidosDao;
import ejercicio04.modelo.LineaPedido;
import ejercicio04.modelo.Pedido;

public class PedidosService {

	private OpenConnection con;

	public PedidosService() {
		con = new OpenConnection();
	}

	public void registrarPedido(Pedido p) throws PedidoException {
		Connection conn = null;
		PedidosDao pedidoDao = new PedidosDao();
		LineaPedidoDao lineaDao = new LineaPedidoDao();
		try {
			conn = con.abrirConexion();
			conn.setAutoCommit(false);
			pedidoDao.insertarPedido(conn, p);
			List<LineaPedido> lineas = p.getLineaPedido();
			int numLinea = 1;
			for (LineaPedido linea : lineas) {
				linea.setIdPedido(p.getIdPedido());
				linea.setNumeroLinea(numLinea);
				lineaDao.insertarLista(conn, linea);
				numLinea++;
			}
			conn.commit();
		} catch (SQLException e) {
			System.err.println("Error al registrar pedido");
			try {
				conn.rollback();
			} catch (SQLException e2) {
				System.err.println("No se puede hacer rollback");
			}
			throw new PedidoException("Error en la base de datos", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {

			}
		}

	}
}
