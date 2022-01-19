package com.practica.ejercicio1.Service;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practica.ejercicio1.Entity.Transaction;
import com.practica.ejercicio1.Repository.TransactionRepo;

@Service
public class TransactionService {

	private TransactionRepo repoTransaction;

	@Autowired
	public TransactionService(TransactionRepo repoTransaction) {
		this.repoTransaction = repoTransaction;
	}
	
	public void saveTransaction(Transaction transaction) {
		repoTransaction.save(transaction);
	}

	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void saveOrUpdate(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Transaction> traerTransactions() {
		 List<Transaction> transactions = new ArrayList<Transaction>();
		 repoTransaction.findAll().forEach(transaction -> transactions.add(transaction));
	     return transactions;
	}
	
	public Transaction traerTransactionDni(String dni) {
		return repoTransaction.findByDniUsr(dni);
	}
	
	
}
