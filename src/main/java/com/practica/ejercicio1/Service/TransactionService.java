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
	
	public void deleteById(Long Id) {
		this.repoTransaction.deleteById(Id);
		}



	    public void saveOrUpdate(Transaction transaction) {
	    	repoTransaction.save( transaction);
	    }

	
	}
	
	

