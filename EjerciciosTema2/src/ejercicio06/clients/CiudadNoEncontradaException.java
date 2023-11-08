package ejercicio06.clients;

public class CiudadNoEncontradaException extends Exception {

	private static final long serialVersionUID = 2111054470075545119L;

	public CiudadNoEncontradaException() {
		super();
	}

	public CiudadNoEncontradaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CiudadNoEncontradaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CiudadNoEncontradaException(String message) {
		super(message);
	}

	public CiudadNoEncontradaException(Throwable cause) {
		super(cause);
	}

}