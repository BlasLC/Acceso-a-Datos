package servicios;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UsuarioDao;
import exceptions.FCTException;
import modelo.Usuario;

public class AltaUsuarioServices {

	private OpenConnection con;

	public AltaUsuarioServices() {
		con = new OpenConnection();
	}

	/**
	 * Método para dar de alta usuarios en la BBDD
	 * 
	 * @param user
	 * @throws SQLException
	 * @throws FCTException
	 */
	public void darAltaUsuario(Usuario user) throws SQLException, FCTException {
		Connection conn = null;
		conn = con.abrirConexion();
		UsuarioDao userDao = new UsuarioDao();
		if (user.equals(userDao.consultarUsuario(conn, user.getEmail()))) {
			throw new FCTException("El usuario ya existe");
		} else {
			userDao.insertarUsuario(conn, user);
		}
	}

}
