package ejercicio07;

import java.util.ArrayList;
import java.util.List;

import ejercicio05.xml.CursosXMLException;
import ejercicio06.modelo.Pelicula;
import ejercicio07.xml.XmlService;

public class App {

	public static void main(String[] args) {
		XmlService servicios = new XmlService();
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		try {
			peliculas = servicios.leerXML("C:\\Users\\blopez1222\\Desktop\\XMLclase\\XMLpelicula");
		} catch (CursosXMLException e) {
			e.printStackTrace();
		}
		for (Pelicula pelicula : peliculas) {
			System.out.println(pelicula);
		}
	}

}
