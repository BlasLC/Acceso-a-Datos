package pruebaLombok;

import java.time.LocalDate;

import lombok.Data;

public @Data class Animal {
	private Integer id;
	private String raza;
	private String color;
	private LocalDate fechaNacimiento;

}
