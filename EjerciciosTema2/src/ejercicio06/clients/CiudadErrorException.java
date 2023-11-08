package ejercicio06.clients;

public class CiudadErrorException extends Exception {

	private static final long serialVersionUID = 2111054470075545119L;

	public CiudadErrorException() {
		super();
	}

	public CiudadErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CiudadErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public CiudadErrorException(String message) {
		super(message);
	}

	public CiudadErrorException(Throwable cause) {
		super(cause);
	}

}
