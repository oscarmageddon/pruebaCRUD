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
		System.out.println(transaction.getNombreUsr()); 
		repoTransaction.save(transaction);
	}

	public List<Transaction> traerTransactions() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		repoTransaction.findAll().forEach(transaction -> transactions.add(transaction));
		return transactions;
	}

	public Transaction traerTransactionDni(String dni) {
		return repoTransaction.findByDniUsr(dni);
	}

	public void deleteById(Long Id) {
		this.repoTransaction.deleteById(Id);
	}

	public void saveOrUpdate(long id, String estado) {
		  Transaction trx = repoTransaction.getById(id);
		  trx.setEstado(estado);
		  repoTransaction.save(trx);
	}

}
