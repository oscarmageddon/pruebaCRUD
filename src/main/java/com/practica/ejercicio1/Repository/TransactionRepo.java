package com.practica.ejercicio1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.ejercicio1.Entity.Transaction;


public interface TransactionRepo extends JpaRepository<Transaction, Long>{

	
	public Transaction findByDniUsr(String dni);
}
