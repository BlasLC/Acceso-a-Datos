package ejercicio05.dao;

import java.sql.Connection;
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

	public City devolverCiudad(Connection conn, Integer id) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			City ciudad = new City();
			String sql = "SELECT * FROM city WHERE city_id = " + id + ";";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ciudad.setId(rs.getLong("city_id"));
				ciudad.setDescripcion(rs.getString("city"));
				ciudad.setCountryId(rs.getLong("country_id"));
			}
			return ciudad;

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {

			}
		}
	}
}
