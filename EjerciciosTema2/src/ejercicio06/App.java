package ejercicio06;

import ejercicio06.clients.CiudadErrorException;
import ejercicio06.clients.CiudadNoEncontradaException;
import ejercicio06.clients.CiudadesClientImp;
import ejercicio06.modelo.City;

public class App {

	public static void main(String[] args) {
		String url = "http://10.50.22.37:8080";
		CiudadesClientImp client = new CiudadesClientImp(url, 3000);
		City ciudad = new City();
		ciudad.setDescripcion("Samarcanda");
		ciudad.setCountryId(87L);
		try {
			/*
			 * System.out.println("\n>>> Test consulta ciudad existente Hanoi:::");
			 * System.out.println(client.getCity(201L));
			 */

			/*
			 * System.out.
			 * println("\n>>> Test consulta ciudades existentes Lancaster-Newcastle:::");
			 * System.out.println(client.getCities("cas"));
			 */

			/*
			 * System.out.println("\n>>> Test crear ciudad nueva Samarcanda:::"); ciudad =
			 * client.createCity(ciudad); System.out.println(ciudad);
			 */

			/*
			 * System.out.
			 * println("\n>>> Test modificar ciudad Samarcanda por Babilonia (conservando país):::"
			 * ); ciudad.setCountryId(null); ciudad.setDescripcion("Babilonia"); ciudad =
			 * client.updateSelectiveCity(ciudad); System.out.println(ciudad);
			 */

			/*
			 * System.out.
			 * println("\n>>> Test modificar ciudad Babilonia por Samarcanda (borrando pa�s):::"
			 * ); ciudad.setCountryId(null); ciudad.setDescripcion("Samarcanda");
			 * client.updateCity(ciudad);
			 * System.out.println(client.getCity(ciudad.getId()));
			 */

			System.out.println("\n>>> Test borrar ciudad Samarcanda:::");
			client.deleteCity(ciudad.getId());

		} catch (CiudadErrorException | CiudadNoEncontradaException e) {
			System.out.println("El test no se ha superado correctamente. Revisa tu código.");
			e.printStackTrace();
		}
		try {
			ciudad = client.getCity(ciudad.getId()); // Debe saltar NotFoundException
			System.out.println("Test de borrado err�neo: la ciudad sigue existiendo: " + ciudad);
		} catch (CiudadNoEncontradaException e) {
			System.out.println(e.getMessage());
			System.out.println("Test superado correctamente");
		} catch (CiudadErrorException e) {
			System.out.println("El test no se ha superado correctamente. Revisa tu código.");
			e.printStackTrace();
		}

	}

}
