package ejercicio03.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PeliculaNoEncontradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7321396712588681725L;

	public PeliculaNoEncontradaException() {
	}

	public PeliculaNoEncontradaException(String message) {
		super(message);

	}

	public PeliculaNoEncontradaException(Throwable cause) {
		super(cause);

	}

	public PeliculaNoEncontradaException(String message, Throwable cause) {
		super(message, cause);

	}

	public PeliculaNoEncontradaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
