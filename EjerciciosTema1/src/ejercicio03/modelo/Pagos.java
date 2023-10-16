package ejercicio03.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pagos {

	private BigDecimal importe;
	private LocalDate fecha;

	public Pagos() {

	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Pago [importe=" + importe + ", fecha=" + fecha + "]";
	}

}
