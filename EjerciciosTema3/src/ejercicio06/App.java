package ejercicio06;

import java.util.List;

import ejercicio06.modelo.Pelicula;
import ejercicio06.xml.XmlService;

public class App {

	public static void main(String[] args) {
		String ruta = new String("C:\\Users\\blopez1222\\Desktop\\XMLclase\\XMLpelicula");
		XmlService servicio = new XmlService();
		List<Pelicula> peliculas = Pelicula.createRandomList(4);
		servicio.crearXML(peliculas, ruta);
	}

}
