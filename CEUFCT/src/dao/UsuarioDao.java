package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Usuario;

public class UsuarioDao {

	/**
	 * Método para consultar usuarios de la tabla Usuarios filtrando por el email,
	 * devuelve 1 usuario
	 * 
	 * @param conn
	 * @param email
	 * @return Usuario
	 * @throws SQLException
	 */
	public Usuario consultarUsuario(Connection conn, String email) throws SQLException {
		ResultSet rs = null;
		Statement stmt = null;

		String sql = "SELECT * FROM usuarios WHERE email = '" + email + "'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				Usuario user = new Usuario();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setNombre(rs.getString("nombre"));
				user.setApellidos(rs.getString("apellidos"));
				user.setCiclo(rs.getString("ciclo"));
				user.setActivo(rs.getBoolean("activo"));
				return user;
			} else {
				return null;
			}

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}

	}

	/**
	 * Método para insertar usuarios en la tabla Usuarios
	 * 
	 * @param conn
	 * @param user
	 * @throws SQLException
	 */
	public void insertarUsuario(Connection conn, Usuario user) throws SQLException {

		PreparedStatement stmt = null;

		String sql = "INSERT INTO usuarios (email, password, nombre, apellidos, ciclo, activo) VALUES(?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getNombre());
			stmt.setString(4, user.getApellidos());
			stmt.setString(5, user.getCiclo());
			stmt.setBoolean(6, user.getActivo());
			stmt.execute();

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}

	}
}
