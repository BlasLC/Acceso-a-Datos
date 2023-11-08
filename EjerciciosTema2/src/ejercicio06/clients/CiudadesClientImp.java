package ejercicio06.clients;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ejercicio06.modelo.City;

public class CiudadesClientImp implements CiudadesClient {
	private String urlBase;
	private RestTemplate restTemplate;

	public CiudadesClientImp(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(msTimeout);
		restTemplate = new RestTemplate(requestFactory);
	}

	@Override
	public List<City> getCities(String filtroDescripcion) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city?filtroDescripcion=" + filtroDescripcion;
			City[] lista = restTemplate.getForObject(url, City[].class);
			return Arrays.asList(lista);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existe ciudad con filtro " + filtroDescripcion);
			} else if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("Error del servidor");
			}
			throw e;
		}
	}

	@Override
	public City getCity(Long id) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city/{" + id + "}";
			City respuesta = restTemplate.getForObject(url, City.class, id);
			return respuesta;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existe ciudad con id " + id);
			} else if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("Error del servidor");
			}
			throw e;
		}
	}

	@Override
	public City createCity(City city) throws CiudadErrorException {
		try {
			String url = urlBase + "/city";
			City respuesta = restTemplate.postForObject(url, city, City.class);
			return respuesta;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("Error del servidor");
			}
			throw e;
		}
	}

	@Override
	public void updateCity(City city) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city";
			restTemplate.put(url, city);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No ");
			} else if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("Error del servidor");
			}
			throw e;
		}
	}

	@Override
	public City updateSelectiveCity(City city) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city";
			city = restTemplate.patchForObject(url, city, City.class);
			return city;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existe ciudad c");
			} else if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("Error del servidor");
			}
			throw e;
		}
	}

	@Override
	public void deleteCity(Long id) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
			String url = urlBase + "/city/{" + id + "}";
			restTemplate.delete(url, id);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existe ciudad con id " + id);
			} else if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("Error del servidor");
			}
			throw e;
		}
	}

}
