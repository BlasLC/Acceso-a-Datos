package ejercicio01.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import ejercicio01.dao.PeliculaDao;
import ejercicio01.modelo.Pelicula;

public class PeliculaServices {

	public List<Pelicula> borrarPelicula(Integer longitud) throws PeliculasException {
		Connection conn = null;
		try {
			conn = new OpenConnection().abrirConexion();
			PeliculaDao dao = new PeliculaDao();
			List<Pelicula> pelis = dao.devolverPeliculas(conn);
			Iterator<Pelicula> iterator = pelis.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getLongitud() != longitud ) {
					iterator.remove();
				}
			}
			return pelis;
		} catch (SQLException e) {
			System.err.println("Error al consultar");
			throw new PeliculasException("Error al consultar", e);
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}

	}

}
