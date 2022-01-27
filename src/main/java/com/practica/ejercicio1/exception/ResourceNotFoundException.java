package com.practica.ejercicio1.exception;

/**
 * Clase de excepción que será lanzada cuando no se encuentre un recurso
 * @author Mario Tigua
 *
 */

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message) {
		super(message);
	}

}
