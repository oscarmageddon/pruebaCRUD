package com.practica.ejercicio1.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dniUsr;
	private String nombreUsr;
	private String apellidoUsr;
	private String paymentMethod;
	@NonNull
	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public Long getId() {
		return id;
	}

}
