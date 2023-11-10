package ceu.dam.fct.clienteREST;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ceu.dam.fct.exception.FechaErrorException;
import ceu.dam.fct.modelo.Fecha;

public class FCTCliente {

	private String urlBase;
	private RestTemplate restTemplate;

	public FCTCliente(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(msTimeout);
		restTemplate = new RestTemplate(requestFactory);
	}

	public List<Fecha> getCities(Integer year, Integer eva) throws FechaErrorException, FechaNotFoundException {
		try {
			String url = urlBase + "/city/{year}/{eva}";
			Fecha[] lista = restTemplate.getForObject(url, Fecha[].class);
			return Arrays.asList(lista);
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new FechaNotFoundException("No existen fechas");
			}
			if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new FechaErrorException("Error del servidor");
			}
			throw e;
		}
	}

}
