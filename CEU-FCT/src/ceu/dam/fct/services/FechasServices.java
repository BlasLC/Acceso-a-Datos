package ceu.dam.fct.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import ceu.dam.fct.dao.FechasDao;
import ceu.dam.fct.db.OpenConnection;
import ceu.dam.fct.exception.CeuFctException;
import ceu.dam.fct.modelo.Fecha;

public class FechasServices {

	private FechasDao dao;
	private OpenConnection connProvider;

	public FechasServices() {
		dao = new FechasDao();
		connProvider = new OpenConnection();
	}

	public List<Fecha> consultarFechasActuales() throws CeuFctException {
		Connection conn = null;
		try {
			conn = connProvider.abrirConexion();
			LocalDate hoy = LocalDate.now();
			Integer evaluacion = 1;
			if (hoy.getMonthValue() >= 9) {
				evaluacion = 3;
			}
			return dao.consultar(conn, hoy.getYear(), evaluacion);
		} catch (SQLException e) {
			System.err.println("Error al consultar fechas");
			throw new CeuFctException("Error al consultar fechas en BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

}
