package ceu.dam.fct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5414509863575634135L;

	public NotFoundException() {
	}

	public NotFoundException(String message) {
		super(message);

	}

	public NotFoundException(Throwable cause) {
		super(cause);

	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
