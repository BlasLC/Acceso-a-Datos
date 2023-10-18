package ejemploAPIRest.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ejemploAPIRest.modelo.Deporte;

@RestController
public class DeporteServices {

	@GetMapping("/deporte")
	public Deporte getDeporte() {
		Deporte depor = new Deporte();
		depor.setId(1);
		depor.setNombre("Baloncesto");
		depor.setJugadores(5);
		return depor;
	}

	@PostMapping("/deporte2")
	public void crearDeporte(@RequestBody Deporte depor) {
		System.out.println("Creando deporte en la BBDD...");
		System.out.println(depor);
		System.out.println("Deporte creado");
	}
}
