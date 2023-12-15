package leer.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import escribir.xml.CursosXMLException;

public class XmlService {

	public void leerXMLCursos(String rutaFichero) throws CursosXMLException {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document xml = builder.parse(new File(rutaFichero));
			Element root = xml.getDocumentElement();
			NodeList listaCursosTag = root.getElementsByTagName("curso");

			for (int i = 0; i < listaCursosTag.getLength(); i++) {
				Element cursoTag = (Element) listaCursosTag.item(i);

				Element nombreTag = (Element) cursoTag.getElementsByTagName("nombre").item(0);
				String nombre = nombreTag.getTextContent();
				System.out.println("Nombre curso: " + nombre);

				Element horasTag = (Element) cursoTag.getElementsByTagName("horas");
				String horas = horasTag.getTextContent();
				System.out.println("Horas curso: " + horas);

				Element alumnosTag = (Element) cursoTag.getElementsByTagName("alumnos");
				NodeList listAlumnoTag = alumnosTag.getElementsByTagName("alumno");

				for (int j = 0; j < listAlumnoTag.getLength(); j++) {
					Element alumnoTag = (Element) listAlumnoTag.item(j);
					String nombreAlumno = alumnoTag.getTextContent();
					System.out.println("\tNombreAlumno: " + nombreAlumno);
					String dni = alumnoTag.getAttribute("dni");
					System.out.println("\tDNIAlumno: " + dni);
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new CursosXMLException("Error leyendo XML", e);
		}

	}

}
