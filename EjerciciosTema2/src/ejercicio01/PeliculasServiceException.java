package ejercicio01;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class PeliculasServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2644119763869827804L;

	public PeliculasServiceException() {
	}

	public PeliculasServiceException(String message) {
		super(message);

	}

	public PeliculasServiceException(Throwable cause) {
		super(cause);

	}

	public PeliculasServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public PeliculasServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
