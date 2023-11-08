package ejercicio04;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7647062860139466911L;

	public ClienteNotFoundException() {
	}

	public ClienteNotFoundException(String message) {
		super(message);

	}

	public ClienteNotFoundException(Throwable cause) {
		super(cause);

	}

	public ClienteNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public ClienteNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
