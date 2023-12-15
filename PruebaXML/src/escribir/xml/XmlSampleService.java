package escribir.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import escribir.modelo.Alumno;
import escribir.modelo.Curso;

public class XmlSampleService {

	public void crearXMLCursos(List<Curso> cursos, String rutaFicheroCompleta) throws CursosXMLException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document xml = builder.newDocument();

			Element root = xml.createElement("cursos");
			xml.appendChild(root);

			for (Curso curso : cursos) {
				Element cursoTag = xml.createElement("curso");
				root.appendChild(cursoTag);

				Element nombreTag = xml.createElement("nombre");
				cursoTag.appendChild(nombreTag);
				nombreTag.setTextContent(curso.getNombre());

				Element horasTag = xml.createElement("horas");
				cursoTag.appendChild(horasTag);
				horasTag.setTextContent(curso.getHora().toString());

				Element alumnosTag = xml.createElement("alumnos");
				cursoTag.appendChild(alumnosTag);

				for (Alumno alumno : curso.getAlumnos()) {
					Element alumnoTag = xml.createElement("alumno");
					alumnosTag.appendChild(alumnoTag);
					alumnoTag.setTextContent(alumno.getNombre());
					alumnoTag.setAttribute("dni", alumno.getDni());
				}

			}

			// Guardar XML en fichero
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			File file = new File(rutaFicheroCompleta);
			StreamResult stream = new StreamResult(file);
			transformer.transform(source, stream);

		} catch (Exception e) {
			throw new CursosXMLException("Error generando XML de cursos", e);
		}

	}

}
