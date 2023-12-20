package ejercicio02.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.web.server.ServerErrorException;

import ejercicio01.csv.FicheroException;
import ejercicio05.exceptions.NotFoundException;
import ejercicio05.modelo.City;
import ejercicio05.services.CityServicesImp;

public class csv {

	public List<City> escribirCsvCiudades(String rutaDestino)
			throws FicheroException, ejercicio05.exceptions.ServerErrorException {
		CityServicesImp ciudades = new CityServicesImp();
		List<City> ciudadeslist = null;
		try {
			ciudadeslist = ciudades.getCities("");
		} catch (ServerErrorException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		File fichero = new File(rutaDestino);
		FileWriter escribidor = null;
		try {
			escribidor = new FileWriter(fichero);
			for (City peli : ciudadeslist) {

				escribidor.write(peli.getDescripcion() + "\n");

			}
			return ciudadeslist;
		} catch (IOException e) {
			throw new FicheroException("Error escribiendo csv.", e);
		} finally {
			try {
				escribidor.close();
			} catch (Exception ignore) {

			}
		}
	}

}
