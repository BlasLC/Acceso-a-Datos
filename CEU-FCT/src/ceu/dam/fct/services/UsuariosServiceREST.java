package ceu.dam.fct.services;

import java.sql.Connection;
import java.sql.SQLException;

import ceu.dam.fct.dao.UsuariosDao;
import ceu.dam.fct.db.OpenConnection;
import ceu.dam.fct.modelo.Usuario;

public class UsuariosServiceREST {

	private OpenConnection con;

	public UsuariosServiceREST() {
		con = new OpenConnection();
	}

	public Usuario crearUsuario() {
		Connection con = null;
		UsuariosDao dao = new UsuariosDao();
		Usuario user = null;

		try {
			user = dao.insertar(con, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
}
