package com.surely.surely.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalHandlerException {
	private static final Logger logger = LoggerFactory.getLogger(GlobalHandlerException.class);

	@ExceptionHandler(CodedException.class)
	public ResponseEntity<Object> handleCartNotFoundException(CodedException ex) {
		logger.error("Se produjo un CodedException: ", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleUncaughtException(Exception ex) {
		logger.error("Se produjo una excepción no controlada", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Se produjo un error inesperado. Por favor, intenta nuevamente más tarde.");
	}
}
