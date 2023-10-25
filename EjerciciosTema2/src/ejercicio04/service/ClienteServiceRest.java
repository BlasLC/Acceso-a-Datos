package ejercicio04.service;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejercicio02.modelo.Clientes;
import ejercicio02.services.ClienteServiceException;
import ejercicio02.services.ClienteServices;

@RestController
public class ClienteServiceRest {
	@GetMapping("/clientes")
	public Clientes consultarClientes(@RequestParam String email) throws ClienteNotFoundException {
		ClienteServices cliService = new ClienteServices();
		Map<String, Clientes> mapa = null;
		try {
			mapa = cliService.consultarEmail();
			if (!mapa.containsKey(email)) {
				throw new ClienteNotFoundException("El email no corresponde con ningun cliente");
			}

		} catch (ClienteServiceException e) {
			e.printStackTrace();
		}
		return mapa.get(email);
	}
}
