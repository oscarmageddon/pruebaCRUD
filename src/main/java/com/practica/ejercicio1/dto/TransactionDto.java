package com.practica.ejercicio1.dto;

import javax.validation.constraints.NotBlank;

/**
 * Clase dto de Transaction con validaciones para los campos a ingresar  
 * @author Mario Tigua
 *
 */
public class TransactionDto {
	private Long id;
	@NotBlank (message = "Rut no puede ser nulo")
	private String dniUsr;
	@NotBlank (message = "Nombre no puede ser nulo")
	private String nombreUsr;
	@NotBlank (message = "Apellido no puede ser nulo")
	private String apellidoUsr;
	@NotBlank (message = "Metodo de pago no puede ser nulo")
	private String paymentMethod;
	private String estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDniUsr() {
		return dniUsr;
	}
	public void setDniUsr(String dniUsr) {
		this.dniUsr = dniUsr;
	}
	public String getNombreUsr() {
		return nombreUsr;
	}
	public void setNombreUsr(String nombreUsr) {
		this.nombreUsr = nombreUsr;
	}
	public String getApellidoUsr() {
		return apellidoUsr;
	}
	public void setApellidoUsr(String apellidoUsr) {
		this.apellidoUsr = apellidoUsr;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
