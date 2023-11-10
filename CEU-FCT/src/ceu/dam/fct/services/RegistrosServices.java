package ceu.dam.fct.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ceu.dam.fct.dao.RegistrosDao;
import ceu.dam.fct.db.OpenConnection;
import ceu.dam.fct.exception.CeuFctException;
import ceu.dam.fct.modelo.Registro;

public class RegistrosServices {

	private RegistrosDao dao;
	private OpenConnection connProvider;

	public RegistrosServices() {
		dao = new RegistrosDao();
		connProvider = new OpenConnection();
	}

	public List<Registro> consultarRegistrosUsuario(Long idUsuario) throws CeuFctException {
		Connection conn = null;
		try {
			conn = connProvider.abrirConexion();
			return dao.consultarPorUsuario(conn, idUsuario);
		} catch (SQLException e) {
			System.err.println("Error al consultar registros");
			throw new CeuFctException("Error al consultar registros en BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}
	
	public void altaRegistro(Registro registro) throws CeuFctException {
		Connection conn = null;
		try {
			conn = connProvider.abrirConexion();
			List<Registro> registrosPrevios = dao.consultarPorUsuario(conn, registro.getIdUsuario());
			for (Registro previo : registrosPrevios) {
				if (previo.getFecha().equals(registro.getFecha())) {
					throw new CeuFctException("Ya existe un registro para ese usuario en esa fecha");
				}
			}
			dao.insertar(conn, registro);
		} catch (SQLException e) {
			System.err.println("Error al insertar registro");
			throw new CeuFctException("Error al insertar registro en BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

}
