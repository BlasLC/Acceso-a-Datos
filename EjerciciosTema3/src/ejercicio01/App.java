package ejercicio01;

import ejercicio01.csv.CsvService;
import ejercicio01.csv.FicheroException;
import ejercicio01.services.PeliculasException;

public class App {

	public static void main(String[] args) {
		CsvService services = new CsvService();
		try {
			services.escribirCsvAsignaturas("C:\\Users\\blopez1222\\Desktop\\pruebaCSV\\csvPeliculas");
		} catch (FicheroException | PeliculasException e) {
			e.printStackTrace();
		}
	}

}
