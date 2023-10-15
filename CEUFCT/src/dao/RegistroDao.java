package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Registro;

public class RegistroDao {
	/**
	 * Método para consultar registro de la tabla Registros filtrando por el
	 * idUsuario, los devuelve en una lista
	 * 
	 * @param conn
	 * @param idUsuario
	 * @return List<Registro>
	 * @throws SQLException
	 */
	public List<Registro> consultarRegistro(Connection conn, Long idUsuario) throws SQLException {
		ResultSet rs = null;
		Statement stmt = null;
		List<Registro> listaRegistro = new ArrayList<Registro>();
		String sql = "SELECT * FROM registros WHERE id_usuario = " + idUsuario;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Registro registro = new Registro();
				registro.setId_usuario(rs.getLong("id_usuario"));
				registro.setFecha(rs.getDate("fecha").toLocalDate());
				registro.setNum_horas(rs.getBigDecimal("num_horas"));
				registro.setDescripcion(rs.getString("descripcion"));
				listaRegistro.add(registro);
			}

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}
		return listaRegistro;
	}

	/**
	 * Método para insertar registros en la tabla Registros
	 * 
	 * @param conn
	 * @param registro
	 * @throws SQLException
	 */
	public void insertarRegistro(Connection conn, Registro registro) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO registros (id_usuario,fecha,num_horas,descripcion) VALUES(?,?,?,?)";

		try {
			LocalDate fechaRegistroLocal = registro.getFecha();
			Date fechaRegistro = Date.valueOf(fechaRegistroLocal);

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, registro.getId_usuario());
			stmt.setDate(2, fechaRegistro);
			stmt.setBigDecimal(3, registro.getNum_horas());
			stmt.setString(4, registro.getDescripcion());
			stmt.execute();

		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}

	}
}
