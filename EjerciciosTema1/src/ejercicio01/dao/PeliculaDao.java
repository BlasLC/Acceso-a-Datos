package ejercicio01.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio01.modelo.Pelicula;

public class PeliculaDao {
	public List<Pelicula> devolverPeliculas(Connection conn) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;

		try {
			
			List<Pelicula> lista = new ArrayList<Pelicula>();

			String sql = "SELECT * FROM film";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pelicula p = new Pelicula();
				p.setId(rs.getInt("film_id"));
				p.setTitulo(rs.getString("title"));
				p.setLongitud(rs.getInt("length"));
				lista.add(p);
			}
			return lista;

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {

			}
		}

	}
}
