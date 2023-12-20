package ejercicio07.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ejercicio05.xml.CursosXMLException;
import ejercicio06.modelo.Pelicula;
import ejercicio06.modelo.Persona;

public class XmlService {

	public List<Pelicula> leerXML(String rutaFichero) throws CursosXMLException {
		List<Pelicula> listaPelicula = new ArrayList<Pelicula>();
		List<Persona> listaActores = new ArrayList<Persona>();

		try {
			Pelicula peli = new Pelicula();

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			Document xml = builder.parse(new File(rutaFichero));
			Element root = xml.getDocumentElement();
			NodeList listaPeliculasTag = root.getElementsByTagName("pelicula");

			for (int i = 0; i < listaPeliculasTag.getLength(); i++) {

				Element peliTag = (Element) listaPeliculasTag.item(i);

				Element tituloTag = (Element) peliTag.getElementsByTagName("titulo").item(0);
				String titulo = tituloTag.getTextContent();
				peli.setTitulo(titulo);

				Element duracionTag = (Element) peliTag.getElementsByTagName("duracion").item(0);
				String duracion = duracionTag.getTextContent();
				peli.setDuracion(Integer.parseInt(duracion));

				Element añoTag = (Element) peliTag.getElementsByTagName("año").item(0);
				String año = añoTag.getTextContent();
				peli.setAño(Integer.parseInt(año));

				Element artistasTag = (Element) peliTag.getElementsByTagName("artistas").item(0);
				NodeList listaArtistasTag = artistasTag.getElementsByTagName("artista");

				for (int j = 0; j < listaArtistasTag.getLength(); j++) {
					Persona persona = new Persona();

					Element artistaTag = (Element) listaArtistasTag.item(j);

					Element nombrePersona = (Element) artistaTag.getElementsByTagName("nombre").item(0);
					String nombre = nombrePersona.getTextContent();
					persona.setNombre(nombre);

					Element nacionalidadPersona = (Element) artistaTag.getElementsByTagName("nacionalidad").item(0);
					String nacionalidad = nacionalidadPersona.getTextContent();
					persona.setNacionalidad(nacionalidad);

					String tipo = artistaTag.getAttribute("tipo");
					if (tipo.equals("dirección")) {
						peli.setDireccion(persona);
					} else if (tipo.equals("producción")) {
						peli.setProduccion(persona);
					} else {
						listaActores.add(persona);
					}

				}
				peli.setActores(listaActores);
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new CursosXMLException("Error leyendo XML", e);
		}

		return listaPelicula;
	}

}
