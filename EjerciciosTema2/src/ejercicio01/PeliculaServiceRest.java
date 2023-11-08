package ejercicio01;

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
	public List<Pelicula> getPeliculas(@RequestParam Integer duracion) throws PeliculasServiceException {
		PeliculaServices peliService = new PeliculaServices();
		List<Pelicula> lista = null;
		try {
			lista = peliService.borrarPelicula(duracion);
		} catch (PeliculasException e) {
			throw new PeliculasServiceException("Error de servidor");
		}
		return lista;

	}
}
