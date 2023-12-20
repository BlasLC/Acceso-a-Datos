package ejercicio01.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ejercicio01.modelo.Pelicula;
import ejercicio01.services.PeliculaServices;
import ejercicio01.services.PeliculasException;

public class CsvService {

	public void escribirCsvAsignaturas(String rutaDestino) throws FicheroException, PeliculasException {
		PeliculaServices services = new PeliculaServices();
		List<Pelicula> peliculas = services.borrarPelicula(100, rutaDestino);
		File file = new File(rutaDestino);
		FileWriter writter = null;
		try {
			writter = new FileWriter(file, true);
			for (Pelicula pelicula : peliculas) {
				writter.write(pelicula.getId() + "\t");
				writter.write(pelicula.getTitulo() + "\t");
				writter.write(pelicula.getLongitud() + "\t");
			}
		} catch (IOException e) {
			throw new FicheroException("Error escribiendo CSV", e);
		} finally {
			try {
				writter.close();
			} catch (Exception ignore) {
			}
		}
	}

}
