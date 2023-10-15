package servicios;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UsuarioDao;
import exceptions.AutentificationException;
import modelo.Usuario;

public class LoginServices {

	private OpenConnection con;

	public LoginServices() {
		con = new OpenConnection();
	}

	/**
	 * Método para hacer Login a un usuario registrado
	 * 
	 * @param email
	 * @param pass
	 * @return User
	 * @throws SQLException
	 * @throws AutentificationException
	 */

	public Usuario comprobarUsuario(String email, String pass) throws SQLException, AutentificationException {
		Connection conn = null;
		conn = con.abrirConexion();

		UsuarioDao userDao = new UsuarioDao();
		Usuario user = userDao.consultarUsuario(conn, email);

		if (user == null) {
			throw new AutentificationException("Usuario no encontrado");
		}
		if (!user.getPassword().equals(pass)) {
			throw new AutentificationException("Contraseña incorrecta");
		}
		return user;

	}
}
