package escribir.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	private String nombre;
	private Integer hora;
	private List<Alumno> alumnos;

	public Curso() {
		alumnos = new ArrayList<Alumno>();
	}

	public Curso(String nombre, Integer hora) {
		super();
		this.nombre = nombre;
		this.hora = hora;
		alumnos = new ArrayList<Alumno>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
