package ceu.dam.fct.exception;

public class FechaErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5477382121365443272L;

	public FechaErrorException() {
	}

	public FechaErrorException(String message) {
		super(message);

	}

	public FechaErrorException(Throwable cause) {
		super(cause);

	}

	public FechaErrorException(String message, Throwable cause) {
		super(message, cause);

	}

	public FechaErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
