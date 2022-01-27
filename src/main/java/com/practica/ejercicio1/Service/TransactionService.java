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

	/**
	 * Creado por Oscar Campos
	 * @param transaction
	 */
	public void saveTransaction(Transaction transaction) {
		System.out.println(transaction.getNombreUsr()); 
		repoTransaction.save(transaction);
	}

	/**
	 * Creado por Moises Neira
	 * Metodo que trae todas las Entidades Transaction existentes en BD.
	 * 
	 * @return
	 */
	public List<Transaction> traerTransactions() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		repoTransaction.findAll().forEach(transaction -> transactions.add(transaction));
		return transactions;
	}

	/**
	 * Creado por Moises Neira
	 * Metodo que trae de BD la entidad Transaction segun el dni ingresado
	 * 
	 * @param dni 
	 * @return
	 */
	public Transaction traerTransactionDni(String dni) {
		return repoTransaction.findByDniUsr(dni);
	}

	public void deleteById(Long Id) {
		this.repoTransaction.deleteById(Id);
	}

	public void update(long id, String estado) {
		  Transaction trx = repoTransaction.getById(id);
		  trx.setEstado(estado);
		  repoTransaction.save(trx);
	}

	/**
	 * Creado por Mario Tigua.
	 * Servicio que permite obtener una Transaction dado su id.
	 * @param id
	 * @return
	 */
	public Transaction getTransactionById(Long id) {
		return repoTransaction.getById(id);
	}

}
