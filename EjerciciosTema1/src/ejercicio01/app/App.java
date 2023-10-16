package ejercicio01.app;

import java.util.List;

import ejercicio01.modelo.Pelicula;
import ejercicio01.services.PeliculaServices;
import ejercicio01.services.PeliculasException;

public class App {
	public static void main(String[] args) {
		PeliculaServices service = new PeliculaServices();
		try {
			List<Pelicula> peliculas = service.borrarPelicula();
			for (Pelicula pelicula : peliculas) {
				System.out.println(pelicula);
			}
		} catch (PeliculasException e) {
			e.printStackTrace();
		}
	}
}
