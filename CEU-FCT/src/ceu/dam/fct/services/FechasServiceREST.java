package ceu.dam.fct.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.fct.dao.FechasDao;
import ceu.dam.fct.db.OpenConnection;
import ceu.dam.fct.exception.NotFoundException;
import ceu.dam.fct.exception.ServerErrorException;
import ceu.dam.fct.modelo.Fecha;

@RestController
public class FechasServiceREST {

	private OpenConnection con;

	public FechasServiceREST() {
		con = new OpenConnection();
	}

	@GetMapping("/fechas/{year}/{eva}")
	public List<Fecha> getFechas(@PathVariable Integer year, @PathVariable Integer eva)
			throws NotFoundException, ServerErrorException {
		Connection conn = null;
		FechasDao dao = new FechasDao();
		List<Fecha> listaFechas = new ArrayList<Fecha>();
		try {
			conn = con.abrirConexion();
			listaFechas = dao.consultar(conn, year, eva);
			if (listaFechas.isEmpty()) {
				throw new NotFoundException("Lista vacia");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServerErrorException("Error del servidor");
		}
		return null;
	}

}
