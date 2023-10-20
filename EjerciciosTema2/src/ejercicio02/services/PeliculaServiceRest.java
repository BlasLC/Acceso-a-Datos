package ejercicio02.services;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejercicio01.modelo.Pelicula;
import ejercicio01.services.PeliculaServices;
import ejercicio01.services.PeliculasException;

@RestController
public class PeliculaServiceRest {
	@PostMapping("/peliculas")
	public List<Pelicula> getPeliculas(@RequestParam Integer duracion) {
		PeliculaServices peliService = new PeliculaServices();
		List<Pelicula> lista = null;
		try {
			lista = peliService.borrarPelicula(duracion);
		} catch (PeliculasException e) {
			e.printStackTrace();
		}
		return lista;

	}
}
