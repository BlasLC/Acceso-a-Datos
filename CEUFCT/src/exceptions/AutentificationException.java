package exceptions;

public class AutentificationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1485462858014510189L;

	public AutentificationException() {
	}

	public AutentificationException(String message) {
		super(message);

	}

	public AutentificationException(Throwable cause) {
		super(cause);

	}

	public AutentificationException(String message, Throwable cause) {
		super(message, cause);

	}

	public AutentificationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
