package exceptions;

public class RegistroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6600415679879995027L;

	public RegistroException() {
	}

	public RegistroException(String message) {
		super(message);

	}

	public RegistroException(Throwable cause) {
		super(cause);

	}

	public RegistroException(String message, Throwable cause) {
		super(message, cause);

	}

	public RegistroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
