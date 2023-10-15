package modelo;

import java.time.LocalDate;

public class Fecha {

	private LocalDate fecha;
	private Integer año;
	private Integer evaluación;
	private Boolean disponibilidad;

	public Fecha() {

	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getAño() {
		return año;
	}

	public void setAño(Integer año) {
		this.año = año;
	}

	public Integer getEvaluación() {
		return evaluación;
	}

	public void setEvaluación(Integer evaluación) {
		this.evaluación = evaluación;
	}

	public Boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "Fechas [fecha=" + fecha + ", año=" + año + ", evaluación=" + evaluación + ", disponibilidad="
				+ disponibilidad + "]";
	}

}
