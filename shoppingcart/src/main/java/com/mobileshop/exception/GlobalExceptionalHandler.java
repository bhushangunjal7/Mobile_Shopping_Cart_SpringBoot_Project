package com.mobileshop.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionalHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), request.getDescription(false), new Date ());

		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> handleAPIException(APIException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), request.getDescription(false), new Date());

		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), request.getDescription(false), new Date());

		return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
