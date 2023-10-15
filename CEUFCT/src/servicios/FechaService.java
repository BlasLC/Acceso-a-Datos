package servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import dao.FechaDao;
import modelo.Fecha;

public class FechaService {

	private OpenConnection con;

	public FechaService() {
		con = new OpenConnection();
	}

	/**
	 * Método para consultar las fechas de la BBDD filtrando por el año y la
	 * evaluación
	 * 
	 * @return List<Fecha>
	 * @throws SQLException
	 */

	public List<Fecha> consultarActuales() throws SQLException {
		Connection conn = con.abrirConexion();

		FechaDao fechaDao = new FechaDao();
		LocalDate fecha = LocalDate.now();
		Integer año = fecha.getYear();
		Integer mes = fecha.getMonthValue();
		Integer evaluación;

		if (mes >= 9 && mes <= 11) {
			evaluación = 1;
			return fechaDao.consultarFechas(conn, año, evaluación);
		} else if (mes >= 12 && mes <= 2) {
			evaluación = 2;
			return fechaDao.consultarFechas(conn, año, evaluación);
		} else if (mes >= 3 && mes <= 6) {
			evaluación = 3;
			return fechaDao.consultarFechas(conn, año, evaluación);
		} else {
			System.out.println("Ese mes no es una evaluación");
			return null;
		}

	}
}
