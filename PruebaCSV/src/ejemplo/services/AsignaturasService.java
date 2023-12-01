package ejemplo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ejemplo.modelo.Asignatura;

public class AsignaturasService {

	public List<Asignatura> consultarAsignaturas(String rutaDestino) {
		List<Asignatura> lista = new ArrayList<Asignatura>();
		for (int i = 0; i < 100; i++) {
			Asignatura a = new Asignatura();
			if (i % 2 == 0) {
				a.setCiclo("DAM");

			} else {
				a.setCiclo("DAW");
			}

			a.setNombre("Ejemplo asignatura " + new Random().nextInt(1, 292338));
			a.setId(i);
			lista.add(a);

		}

		return lista;
	}

}
