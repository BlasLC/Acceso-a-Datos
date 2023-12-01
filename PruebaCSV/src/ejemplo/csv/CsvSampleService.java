package ejemplo.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ejemplo.modelo.Asignatura;
import ejemplo.services.AsignaturasService;

public class CsvSampleService {

	public void escribirCsvAsignaturas(String rutaDestino) throws FicheroException {
		AsignaturasService services = new AsignaturasService();
		List<Asignatura> asignaturas = services.consultarAsignaturas(rutaDestino);
		File file = new File(rutaDestino);
		FileWriter writter = null;
		try {
			writter = new FileWriter(file, true);
			for (Asignatura asignatura : asignaturas) {
				writter.write(asignatura.getId() + ",");
				writter.write(asignatura.getNombre() + ",");
				writter.write(asignatura.getCiclo() + ",");
			}
		} catch (IOException e) {
			throw new FicheroException("Error escribiendo CSV", e);
		} finally {
			try {
				writter.close();
			} catch (Exception ignore) {
			}
		}
	}

	public List<Asignatura> leerCsvAsignaturas(String rutaOrigen) throws FicheroException {
		File file = new File(rutaOrigen);
		Scanner scanner = null;
		try {
			List<Asignatura> asignaturas = new ArrayList<Asignatura>();
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				Asignatura a = new Asignatura();
				String[] campos = line.split(";");
				a.setId(Integer.parseInt(campos[0]));
				a.setNombre(campos[1]);
				a.setCiclo(campos[2]);
				asignaturas.add(a);
			}
		} catch (FileNotFoundException e) {
			throw new FicheroException("No existe el fichero en la ruta indicada", e);
		} finally {
			scanner.close();
		}
		return null;
	}

}
