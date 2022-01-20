package com.practica.ejercicio1.exception;

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
