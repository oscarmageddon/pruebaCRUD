package com.practica.ejercicio1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.practica.ejercicio1.Entity.Transaction;

@CrossOrigin
@RepositoryRestResource(path = "Transactions", collectionResourceRel = "Transactions")
public interface TransactionRepo extends JpaRepository<Transaction, Long>{

	
	
	
	//void delete( id);
	//void update(Transaction transaction, Id);

}
