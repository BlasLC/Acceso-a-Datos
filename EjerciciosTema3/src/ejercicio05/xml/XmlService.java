package ejercicio05.xml;

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

import ejercicio04.modelo.Edicion;
import ejercicio04.modelo.Libro;

public class XmlService {

	public List<Libro> leerXML(String rutaFichero) throws CursosXMLException {
		List<Libro> listaLibros = new ArrayList<Libro>();
		List<Edicion> listaEdiciones = new ArrayList<Edicion>();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xml = builder.parse(new File(rutaFichero));
			Element root = xml.getDocumentElement();
			NodeList listaLibrosTag = root.getElementsByTagName("libro");

			for (int i = 0; i < listaLibrosTag.getLength(); i++) {
				Libro libro = new Libro();
				Element libroTag = (Element) listaLibrosTag.item(i);
				String isbn = libroTag.getAttribute("isbn");
				libro.setIsbn(Integer.parseInt(isbn));
				// System.out.println("ISBN libro: " + isbn);

				Element tituloTag = (Element) libroTag.getElementsByTagName("titulo").item(0);
				String titulo = tituloTag.getTextContent();
				libro.setTitulo(titulo);
				// System.out.println("Titulo libro: " + titulo);

				Element autoresTag = (Element) libroTag.getElementsByTagName("autores").item(0);
				NodeList listaAutoresTag = autoresTag.getElementsByTagName("autor");

				for (int j = 0; j < listaAutoresTag.getLength(); j++) {

					List<String> autores = new ArrayList<String>();
					Element autorTag = (Element) listaAutoresTag.item(j);
					String nombreAutor = autorTag.getTextContent();
					autores.add(nombreAutor);
					libro.setAutores(autores);
					// System.out.println("\tNombre Autor: " + nombreAutor);
				}

				Element edicionesTag = (Element) libroTag.getElementsByTagName("ediciones").item(0);
				NodeList listaEdicionesTag = edicionesTag.getElementsByTagName("edicion");

				for (int j = 0; j < listaEdicionesTag.getLength(); j++) {
					Edicion edicion = new Edicion();
					Element edicionTag = (Element) listaEdicionesTag.item(j);
					Element año = (Element) edicionTag.getElementsByTagName("año").item(0);
					String añoEdicion = año.getTextContent();
					edicion.setAño(Integer.parseInt(añoEdicion));
					// System.out.println("Año de edicion: " + añoEdicion);

					Element editorial = (Element) edicionTag.getElementsByTagName("editorial").item(0);
					String editorialLibro = editorial.getTextContent();
					edicion.setEditorial(editorialLibro);
					listaEdiciones.add(edicion);
					// System.out.println("Editorial: " + editorialLibro);
				}
				libro.setEdiciones(listaEdiciones);
				listaLibros.add(libro);
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new CursosXMLException("Error leyendo XML", e);
		}
		return listaLibros;

	}

}
