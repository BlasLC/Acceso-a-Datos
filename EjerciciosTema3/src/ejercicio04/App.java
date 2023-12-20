package ejercicio04;

import java.util.List;

import ejercicio04.modelo.Libro;
import ejercicio04.xml.XmlService;

public class App {

	public static void main(String[] args) {
		String ruta = new String("C:\\Users\\blopez1222\\Desktop\\XMLclase\\XMLlibros");
		XmlService servicio = new XmlService();
		List<Libro> libros = Libro.createRandomList(3);
		servicio.crearXML(libros, ruta);
	}
}
