package com.practica.ejercicio1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practica.ejercicio1.Entity.Transaction;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "Transactions", collectionResourceRel = "Transactions")
public interface TransactionRepo extends JpaRepository<Transaction, String> {

	public Transaction findByDniUsr(String dni);
}
