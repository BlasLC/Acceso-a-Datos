package ejercicio02.app;

import java.util.Map;
import java.util.Scanner;

import ejercicio02.modelo.Clientes;
import ejercicio02.services.ClienteServiceException;
import ejercicio02.services.ClienteServices;

public class App {

	public static void main(String[] args) throws ClienteServiceException {
		Scanner scanner = new Scanner(System.in);
		ClienteServices servicios = new ClienteServices();
		Map<String, Clientes> mapa = servicios.consultarEmail();
		try {
			System.out.println(mapa.get("MARILYN.ROSS@sakilacustomer.org"));

		} catch (Exception e) {
			
		} finally {
			scanner.close();
		}
	}

}
