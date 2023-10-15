package servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.RegistroDao;
import exceptions.RegistroException;
import modelo.Registro;
import modelo.Usuario;

public class RegistroService {
	private OpenConnection con;

	public RegistroService() {
		con = new OpenConnection();
	}

	/**
	 * Método para consultar si el registro solicitado se encuentra en la BBDD
	 * 
	 * @param idUsuario
	 * @return List<Registro>
	 * @throws SQLException
	 * @throws RegistroException
	 */
	public List<Registro> consultarRegistroUsuario(Long idUsuario) throws SQLException, RegistroException {
		Connection conn = con.abrirConexion();

		RegistroDao registroDao = new RegistroDao();
		if (idUsuario == null) {
			throw new RegistroException("La id del usuario no existe");
		} else {
			return registroDao.consultarRegistro(conn, idUsuario);
		}
	}

	/**
	 * Método para crear un nuevo registro en la BBDD
	 * 
	 * @param registro
	 * @throws SQLException
	 * @throws RegistroException
	 */

	public void crearRegistro(Registro registro) throws SQLException, RegistroException {
		Connection conn = con.abrirConexion();
		RegistroDao registroDao = new RegistroDao();
		Usuario user = new Usuario();

		if (registroDao.consultarRegistro(conn, user.getId_usuario()) != registro) {
			registroDao.insertarRegistro(conn, registro);
		} else {
			throw new RegistroException("El registro ya existe");
		}
	}
}
