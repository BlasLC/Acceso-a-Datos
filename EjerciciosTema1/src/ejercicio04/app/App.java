package ejercicio04.app;

import java.math.BigDecimal;
import java.time.LocalDate;

import ejercicio04.modelo.LineaPedido;
import ejercicio04.modelo.Pedido;
import ejercicio04.services.PedidoException;
import ejercicio04.services.PedidosService;

public class App {
	public static void main(String[] args) {
		Long idPedido = 100L;
		Pedido pedido = new Pedido();
		pedido.setIdPedido(idPedido);
		pedido.setFechaPedido(LocalDate.now());
		pedido.setFechaEntrega(LocalDate.of(2023, 12, 1));
		pedido.setCliente("Laura Salmerón");

		for (int j = 1; j <= 3; j++) {
			LineaPedido linea = new LineaPedido();
			linea.setArticulo("Artículo " + j);
			linea.setPrecio(new BigDecimal(938));
			pedido.getLineaPedido().add(linea);
		}

		PedidosService service = new PedidosService();
		try {
			service.registrarPedido(pedido);
		} catch (PedidoException e) {
			e.printStackTrace();
		}

	}
}
