package exceptions;

public class FCTException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5705532415780643800L;

	public FCTException() {
	}

	public FCTException(String message) {
		super(message);

	}

	public FCTException(Throwable cause) {
		super(cause);

	}

	public FCTException(String message, Throwable cause) {
		super(message, cause);

	}

	public FCTException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
