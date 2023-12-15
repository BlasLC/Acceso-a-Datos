package ejercicio05.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlService {

	public void leerXML(String rutaFichero) throws CursosXMLException {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xml = builder.parse(new File(rutaFichero));
			Element root = xml.getDocumentElement();
			NodeList listaLibrosTag = root.getElementsByTagName("libro");
			for (int i = 0; i < listaLibrosTag.getLength(); i++) {
				Element libroTag = (Element) listaLibrosTag.item(i);
				String isbn = libroTag.getAttribute("isbn");
				System.out.println("ISBN libro: " + isbn);

				Element tituloTag = (Element) libroTag.getElementsByTagName("titulo");
				String titulo = tituloTag.getTextContent();
				System.out.println("Titulo libro: " + titulo);
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new CursosXMLException("Error leyendo XML", e);
		}

	}

}
