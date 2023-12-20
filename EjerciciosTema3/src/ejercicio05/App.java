package ejercicio05;

import java.util.ArrayList;
import java.util.List;

import ejercicio04.modelo.Libro;
import ejercicio05.xml.CursosXMLException;
import ejercicio05.xml.XmlService;

public class App {

	public static void main(String[] args) {
		XmlService servicios = new XmlService();
		List<Libro> libros = new ArrayList<Libro>();
		try {
			libros = servicios.leerXML("C:\\Users\\blopez1222\\Desktop\\XMLclase\\XMLlibros");
			System.out.println(libros);
		} catch (CursosXMLException e) {
			e.printStackTrace();
		}
		for (Libro libro : libros) {
			System.out.println(libro);
		}
	}

}
