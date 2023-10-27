package ejercicio05.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ejercicio05.dao.CityDao;
import ejercicio05.exceptions.NotFoundException;
import ejercicio05.exceptions.ServerErrorException;
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
	@GetMapping("/city/{id}")
	public City getCity(@PathVariable Long id) throws NotFoundException, ejercicio05.exceptions.ServerErrorException {
		Connection conn = null;
		CityDao cDao = new CityDao();
		City ciudad = new City();
		try {
			conn = con.abrirConexion();
			ciudad = cDao.devolverCiudad(conn, id);
			return ciudad;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ejercicio05.exceptions.ServerErrorException("Error del servidor");
		}
	}

	@Override
	@PostMapping("/city")
	public City createCity(@RequestBody City city) {
		Connection conn = null;

		CityDao cDao = new CityDao();
		City ciudad = null;
		try {
			conn = con.abrirConexion();
			ciudad = cDao.crearCiudad(conn, city);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}

	@Override
	@PutMapping("/city")
	public void updateCity(@RequestBody City ciudad) throws NotFoundException, ServerErrorException {
		Connection conn = null;

		CityDao cDao = new CityDao();
		List<City> lista = new ArrayList<City>();
		try {
			conn = con.abrirConexion();
			lista = cDao.devolverPeliculas(conn, "");
			for (City city : lista) {
				if (city.getId() == ciudad.getId()) {
					cDao.updateCity(conn, ciudad);
				} else {
					throw new NotFoundException("No existe ciudad para la id");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ejercicio05.exceptions.ServerErrorException("Error del servidor");
		}

	}

	@Override
	public City updateSelectiveCity(City city) throws NotFoundException {

		return null;
	}

	@Override
	public void deleteCity(Long id) throws NotFoundException {
	}

}
