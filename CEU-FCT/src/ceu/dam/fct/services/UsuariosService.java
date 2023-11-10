package ceu.dam.fct.services;

import java.sql.Connection;
import java.sql.SQLException;

import ceu.dam.fct.dao.UsuariosDao;
import ceu.dam.fct.db.OpenConnection;
import ceu.dam.fct.exception.CeuFctException;
import ceu.dam.fct.exception.LoginIncorrectoException;
import ceu.dam.fct.modelo.Usuario;

public class UsuariosService {

	private UsuariosDao dao;
	private OpenConnection connProvider;

	public UsuariosService() {
		dao = new UsuariosDao();
		connProvider = new OpenConnection();
	}

	public Usuario login(String email, String password) throws CeuFctException, LoginIncorrectoException {
		Connection conn = null;
		try {
			conn = connProvider.abrirConexion();
			Usuario usuario = dao.consultar(conn, email);
			if (usuario == null) {
				throw new LoginIncorrectoException("No existe el email indicado");
			}
			if (!usuario.getPassword().equals(password)) {
				throw new LoginIncorrectoException("La password no es correcta");
			}
			if (!usuario.getActivo()) {
				throw new LoginIncorrectoException("El usuario aún no está activo");
			}
			return usuario;
		} catch (SQLException e) {
			System.err.println("Error al consultar usuarios");
			throw new CeuFctException("Error al consultar usuarios en BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}
	
	
	public void altaUsuario(Usuario usuario) throws CeuFctException {
		Connection conn = null;
		try {
			conn = connProvider.abrirConexion();
			Usuario usuarioExistente = dao.consultar(conn, usuario.getEmail());
			if (usuarioExistente != null) {
				throw new CeuFctException("Ya existe un usuario con el mismo email");
			}
			usuario.setActivo(false);
			dao.insertar(conn, usuario);
		} catch (SQLException e) {
			System.err.println("Error al insertar usuarios");
			throw new CeuFctException("Error al insertar usuarios en BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

}
