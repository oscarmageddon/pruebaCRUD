package com.practica.ejercicio1.Service;

import com.practica.ejercicio1.Repository.TransactionRepo;

import antlr.collections.List;

public interface ITransactionService {
	
	public List getTransactions();
	public TransactionRepo addTransactions(TransactionRepo transaction);
	public List postTransaction();
	public TransactionRepo updateTransactions(TransactionRepo transaction);
	void delete(int id);
	
}


