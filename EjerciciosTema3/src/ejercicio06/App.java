package ejercicio06;

import ejercicio06.modelo.Pelicula;
import ejercicio06.xml.XmlService;

public class App {

	public static void main(String[] args) {
		XmlService servicio = new XmlService();
		servicio.crearXML(Pelicula.createRandomList(5), "C:\\Users\\blopez1222\\Desktop\\XMLclase\\XMLpelicula");
	}

}
