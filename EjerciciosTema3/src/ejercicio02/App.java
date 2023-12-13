package ejercicio02;

import java.util.List;

import ejercicio01.csv.FicheroException;
import ejercicio02.csv.csv;
import ejercicio05.exceptions.ServerErrorException;
import ejercicio05.modelo.City;

public class App {

	public static void main(String[] args) {

		csv serviceCsv = new csv();

		List<City> resultado = null;

		try {
			resultado = serviceCsv.escribirCsvCiudades("C:\\Users\\arodriguez1063\\Desktop/ciudades.csv");
		} catch (FicheroException e) {
			e.printStackTrace();
		} catch (ServerErrorException e) {
			e.printStackTrace();
		}

		for (City ciudades : resultado) {
			System.out.println(ciudades.getDescripcion());
		}
	}
}
