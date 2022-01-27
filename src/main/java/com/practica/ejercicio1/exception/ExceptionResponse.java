package com.practica.ejercicio1.exception;
/**
 * Clase de respuesta con mensajes de error del sistema
 * @author Mario Tigua
 *
 */
		
public class ExceptionResponse {

	private String errorMessage;
	private String requestedURI;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void setRequestedURI(final String requestedURI) {
		this.requestedURI = requestedURI;
	}
}
