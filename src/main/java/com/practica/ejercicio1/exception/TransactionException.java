package com.practica.ejercicio1.exception;

public class TransactionException extends Exception{

	private static final long serialVersionUID = 1L;
	private Exception concreteException;
	private String errorMessage;
	
	public Exception getConcreteException() {
		return concreteException;
	}
	public void setConcreteException(Exception concreteException) {
		this.concreteException = concreteException;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


}
