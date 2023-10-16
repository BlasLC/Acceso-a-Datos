package ejercicio03.services;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio03.dao.ClientesDao;
import ejercicio03.modelo.Clientes;
import ejercicio03.dao.PagosDao;
import ejercicio03.modelo.Pagos;

public class ClienteServices {
	public Map<String, List<Pagos>> consultarPagosClientes() throws ClienteServiceException {

		Connection conn = null;
		Map<String, List<Pagos>> mapa = new HashMap<String, List<Pagos>>();

		try {
			conn = new OpenConnection().abrirConexion();
			ClientesDao cDao = new ClientesDao();
			PagosDao pDao = new PagosDao();
			List<Clientes> lista = cDao.consultarClientes(conn);
			for (Clientes clientes : lista) {
				List<Pagos> listaPagos = pDao.consultarPagos(conn, clientes.getId());
				mapa.put(clientes.getEmail(), listaPagos);
			}

		} catch (Exception e) {
			System.err.println("Error al consultar ");
			throw new ClienteServiceException("Error al consultar clientes ", e);
		}

		return mapa;
	}
}
