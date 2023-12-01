package ejemplo;

import java.util.List;

import ejemplo.csv.CsvSampleService;
import ejemplo.csv.FicheroException;
import ejemplo.modelo.Asignatura;

public class App {

	public static void main(String[] args) {
		CsvSampleService serviceCsv = new CsvSampleService();

		try {
			serviceCsv.escribirCsvAsignaturas("C:\\Users\\blopez1222\\Desktop\\pruebaCSV");
		} catch (FicheroException e) {
			e.printStackTrace();
		}

		/*
		 * try { List<Asignatura> resultado =
		 * serviceCsv.leerCsvAsignaturas("C:\\Users\\blopez1222\\Desktop\\pruebaCSV");
		 * for (Asignatura asignatura : resultado) { System.out.println(asignatura); } }
		 * catch (FicheroException e) { e.printStackTrace(); }
		 */
	}

}
