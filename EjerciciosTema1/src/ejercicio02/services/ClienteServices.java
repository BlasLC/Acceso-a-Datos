package ejercicio02.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio01.services.OpenConnection;
import ejercicio02.dao.ClientesDao;
import ejercicio02.modelo.Clientes;

public class ClienteServices {

	public Map<String, Clientes> consultarEmail() throws ClienteServiceException {

		Connection conn = null;
		Map<String, Clientes> mapa = new HashMap<String, Clientes>();
		
		try {
			conn = new OpenConnection().abrirConexion();
			ClientesDao dao = new ClientesDao();
			List<Clientes> lista = dao.consultarClientes(conn);
			for (Clientes clientes : lista) {
				mapa.put(clientes.getEmail(), clientes);
			}

		} catch (SQLException e) {
			System.err.println("Error al consultar clientes");
			throw new ClienteServiceException("Error al consultar clientes en BBDD", e);
		}

		return mapa;

	}
}
