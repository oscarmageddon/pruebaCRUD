package com.practica.ejercicio1.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.gson.JsonObject;


@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleResourceNotFound(final ResourceNotFoundException e,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(e.getClass().toString() + " " + e.getMessage());		
		error.setRequestedURI(request.getRequestURI());

		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<ExceptionResponse> handleException(final TransactionException e,
			final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(e.getErrorMessage());		
		JsonObject details = new JsonObject();
		details.addProperty(e.getSubject(), e.getDetail());		
		error.setDetails(details);
		error.setRequestedURI(request.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleGenericExceptions(final Exception e, final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse();	
		error.setErrorMessage(e.getClass().toString() + " " + e.getMessage());
		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
