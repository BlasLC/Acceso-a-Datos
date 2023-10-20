package pruebaLombok;

import java.time.LocalDate;

public class App {

	public static void main(String[] args) {
		Animal a = new Animal();
		a.setId(22);
		a.setColor("Rojo");
		a.setRaza("Perro");
		a.setFechaNacimiento(LocalDate.now());
		System.out.println(a);
	}

}
