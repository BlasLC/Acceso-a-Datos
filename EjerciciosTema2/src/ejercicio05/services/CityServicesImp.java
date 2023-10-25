package ejercicio05.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ejercicio05.dao.CityDao;
import ejercicio05.exceptions.NotFoundException;
import ejercicio05.modelo.City;

@RestController
public class CityServicesImp implements CityService {

	private OpenConnection con;

	public CityServicesImp() {
		con = new OpenConnection();
	}

	@Override
	@GetMapping("/city")
	public List<City> getCities(@RequestParam(required = false) String filtroDescripcion)
			throws NotFoundException, ejercicio05.exceptions.ServerErrorException {
		Connection conn = null;
		CityDao cDao = new CityDao();
		List<City> listaCiudades = new ArrayList<City>();
		try {
			conn = con.abrirConexion();
			listaCiudades = cDao.devolverPeliculas(conn, filtroDescripcion);
			if (listaCiudades.isEmpty()) {
				throw new NotFoundException("Lista vacia");
			}
			return listaCiudades;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ejercicio05.exceptions.ServerErrorException("Error del servidor");
		}
	}

	@Override
	public City getCity(Long id) throws NotFoundException {
		return null;
	}

	@Override
	public City createCity(City city) {
		return null;
	}

	@Override
	public void updateCity(City city) throws NotFoundException {
	}

	@Override
	public City updateSelectiveCity(City city) throws NotFoundException {
		return null;
	}

	@Override
	public void deleteCity(Long id) throws NotFoundException {
	}

}
