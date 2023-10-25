package ejercicio05.services;

import java.util.List;

import ejercicio05.exceptions.NotFoundException;
import ejercicio05.exceptions.ServerErrorException;
import ejercicio05.modelo.City;

public interface CityService { // TODO: INCLUIR EXCEPCION SERVEREXCEPTION PARA CUALQUIER OTRO ERROR CON UN 500

	/**
	 * Devuelve la lista de ciudades de la bbdd filtrando por la descripcián
	 * indicada. - El filtro se debe aplicar como un contiene. Es decir, si se
	 * filtra por "ara", resultados válidos seráan: "arak", "okara", "caracas", etc.
	 * - Se debe invocar mediante un GET a la URL /city?filtroDescripcion=valor - El
	 * parámetro filtroDescripcián es opcional. Si no llega, no se aplicará filtro.
	 * - Tendrá que devolver un 404 si la lista de resultados es vacáa
	 * 
	 * @param filtroDescripcion - El parámetro se pasará con este nombre
	 * @return
	 * @throws NotFoundException
	 * @throws ServerErrorException
	 */
	public List<City> getCities(String filtroDescripcion) throws NotFoundException, ServerErrorException;

	/**
	 * Devuelve la ciudad con el id indicado. - Se debe invocar mediante un GET a la
	 * URL /city/id (siendo "id" el parámetro) - Tendrá que devolver un 404 si no
	 * existe ciudad con ese id
	 * 
	 * @param id - formará parte de la URL
	 * @return
	 * @throws NotFoundException
	 */
	public City getCity(Long id) throws NotFoundException, ServerErrorException;

	/**
	 * Creará en base de datos la ciudad indicada por parámetro. Despuás devolverá
	 * esa ciudad como respuesta. - Se debe invocar mediante un POST a la URL /city
	 * - El parámetro city vendrá en body de la peticián
	 * 
	 * @param city
	 * @return
	 */
	public City createCity(City city);

	/**
	 * Actualizará en base de datos la ciudad indicada por parámetro. Actualizará
	 * todos los valores que lleguen en el objeto, aunque están a null - Se debe
	 * invocar mediante un PUT a la URL /city - El parámetro city vendrá en body de
	 * la peticián - Tendrá que devolver un 404 si no existe ciudad con ese id
	 * 
	 * @param city
	 * @throws NotFoundException
	 */
	public void updateCity(City city) throws NotFoundException, ServerErrorException;

	/**
	 * Actualizará en base de datos la ciudad indicada por parámetro. Actualizará
	 * sálo los valores que lleguen informados en el objeto, es decir, los atributos
	 * que vengan a NULL, no se actualizan - Se debe invocar mediante un PATCH a la
	 * URL /city - El parámetro city vendrá en body de la peticián - Tendrá que
	 * devolver un 404 si no existe ciudad con ese id - Si la actualizacián es
	 * correcta, devolverá el objeto city actualizado y completo
	 * 
	 * @param city
	 * @return
	 * @throws NotFoundException
	 */
	public City updateSelectiveCity(City city) throws NotFoundException, ServerErrorException;

	/**
	 * Borrará en base de datos la ciudad indicada por parámetro. - Se debe invocar
	 * mediante un DELETE a la URL /city/id (siendo "id" el parámetro) - Tendrá que
	 * devolver un 404 si no existe ciudad con ese id
	 * 
	 * @param id
	 * @throws NotFoundException
	 */
	public void deleteCity(Long id) throws NotFoundException, ServerErrorException;

}
