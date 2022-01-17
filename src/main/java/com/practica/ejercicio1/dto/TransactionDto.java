package com.practica.ejercicio1.dto;

public class TransactionDto {
	private Long id;
	private String dniUsr;
	private String nombreUsr;
	private String apellidoUsr;
	private String paymentMethod;
	
	
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

}
