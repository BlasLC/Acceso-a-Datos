package escribir.xml;

import java.util.ArrayList;
import java.util.List;

import escribir.modelo.Alumno;
import escribir.modelo.Curso;

public class App {

	public static void main(String[] args) {

		// Generamos lista de cursos de ejemplo para probar el XML
		List<Curso> cursos = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Alumno a1 = new Alumno("4324X", "Alberto Ávila");
			Alumno a2 = new Alumno("3432D", "Carlos Camacho");
			Curso c1 = new Curso("DAM", 7);
			c1.getAlumnos().add(a1);
			c1.getAlumnos().add(a2);

			Curso c2 = new Curso("ASIR", 7);
			c2.getAlumnos().add(a1);
			c2.getAlumnos().add(a2);
			cursos.add(c1);
			cursos.add(c2);
		}

		// Llamamos al servicio para que genere el XML
		XmlSampleService service = new XmlSampleService();
		try {
			service.crearXMLCursos(cursos, "C:\\Users\\blopez1222\\Desktop\\CSVclase\\XMLprueba");
		} catch (CursosXMLException e) {
			e.printStackTrace();
		}

	}

}
