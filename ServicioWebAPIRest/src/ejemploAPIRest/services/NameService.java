package ejemploAPIRest.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameService {
	@GetMapping("/name")
	public String getNombre() {
		return "Blas";
	}

	@GetMapping("/cuadrado")
	public Integer getCuadrado(@RequestParam Integer num) {
		return num * num;

	}

	@GetMapping("/potenciaRequest")
	public Double getPotencia(@RequestParam Integer base, @RequestParam Integer potencia) {
		Double resultado = Math.pow(base, potencia);
		return resultado;
	}

	@GetMapping("/potenciaPath/{base}/{potencia}")
	public Double getPotencia2(@PathVariable Integer base, @PathVariable Integer potencia) {
		Double resultado = Math.pow(base, potencia);
		return resultado;
	}


}
