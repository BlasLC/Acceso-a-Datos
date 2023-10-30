package ejercicio05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio05.modelo.City;

public class CityDao {
	public List<City> devolverPeliculas(Connection conn, String filtro) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;

		try {

			List<City> lista = new ArrayList<City>();

			String sql = "SELECT * FROM city WHERE city LIKE" + " '%" + filtro + "%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				City ciudad = new City();
				ciudad.setId(rs.getLong("city_id"));
				ciudad.setDescripcion(rs.getString("city"));
				ciudad.setCountryId(rs.getLong("country_id"));
				lista.add(ciudad);
			}
			return lista;

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {

			}
		}
	}

	public City devolverCiudad(Connection conn, Long id) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			City ciudad = new City();
			String sql = "SELECT * FROM city WHERE city_id = " + id + ";";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				ciudad.setId(rs.getLong("city_id"));
				ciudad.setDescripcion(rs.getString("city"));
				ciudad.setCountryId(rs.getLong("country_id"));
				return ciudad;
			} else {
				return null;
			}

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {

			}
		}
	}

	public City crearCiudad(Connection conn, City ciudad) throws SQLException {
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("INSERT INTO city (city_id, city, country_id) VALUES (?,?,?)");
			stmt.setLong(1, ciudad.getId());
			stmt.setString(2, ciudad.getDescripcion());
			stmt.setLong(3, ciudad.getCountryId());
			stmt.execute();

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
		return ciudad;
	}

	public Integer updateCity(Connection conn, City ciudad) throws SQLException {
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("UPDATE city SET city = ? , country_id = ? WHERE city_id = ?");
			stmt.setString(1, ciudad.getDescripcion());
			stmt.setLong(2, ciudad.getCountryId());
			stmt.setLong(3, ciudad.getId());
			return stmt.executeUpdate();

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {

			}
		}
	}

	public void updateSelective(Connection conn, City ciudad) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("UPDATE city SET city = ? , country_id = ? WHERE city_id = ?");
			stmt.setString(1, ciudad.getDescripcion());
			stmt.setLong(2, ciudad.getCountryId());
			stmt.setLong(3, ciudad.getId());
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}
}
