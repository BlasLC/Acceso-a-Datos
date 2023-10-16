package ejercicio03.app;

import java.util.List;
import java.util.Map;
import ejercicio03.modelo.Pagos;
import ejercicio03.services.ClienteServiceException;
import ejercicio03.services.ClienteServices;

public class App {

	public static void main(String[] args) throws ClienteServiceException {
		ClienteServices servicios = new ClienteServices();
		try {
			Map<String, List<Pagos>> mapa = servicios.consultarPagosClientes();
			List<Pagos> pagos = mapa.get("MARILYN.ROSS@sakilacustomer.org");
			for (Pagos pagos2 : pagos) {
				System.out.println(pagos2);
			}

		} catch (Exception e) {

		}
	}
}
