package com.practica.ejercicio1.exception;

public class TransactionException extends Exception{

	private static final long serialVersionUID = 1L;
	private String subject;
	private String detail;
	private Exception concreteException;
	private String errorMessage;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
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
