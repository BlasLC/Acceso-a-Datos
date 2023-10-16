package ejercicio01.modelo;

public class Pelicula {

	private Integer id;
	private String titulo;
	private Integer longitud;
	
	public Pelicula() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getLongitud() {
		return longitud;
	}

	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Pelicula [ID=" + id + ", Titulo=" + titulo + ", Longitud=" + longitud + "]";
	}
	
	
	
}
