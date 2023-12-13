package ejercicio06.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ejercicio06.modelo.Pelicula;

public class XmlService {

	public void crearXML(List<Pelicula> peliculas, String rutaFicheroCompleta) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			Document xml = builder.newDocument();
			Element root = xml.createElement("peliculas");
			xml.appendChild(root);

			for (Pelicula pelicula : peliculas) {
				Element peliculaTag = xml.createElement("pelicula");
				root.appendChild(peliculaTag);

				Element tituloTag = xml.createElement("titulo");
				peliculaTag.appendChild(tituloTag);
				tituloTag.setTextContent(pelicula.getTitulo());

				Element duracionTag = xml.createElement("duracion");
				peliculaTag.appendChild(duracionTag);
				duracionTag.setTextContent(pelicula.getDuracion().toString());

				Element añoTag = xml.createElement("año");
				peliculaTag.appendChild(añoTag);
				añoTag.setTextContent(pelicula.getAño().toString());

				
				
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			File file = new File(rutaFicheroCompleta);
			StreamResult stream = new StreamResult(file);
			transformer.transform(source, stream);
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}

	}

}
