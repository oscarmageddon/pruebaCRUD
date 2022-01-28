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
    /** 
     * Creado por Indira Navas con supervision y ayuda Mario Tigua 27-01-2021
     * Servicio que permite el borrado por id
     * @param Id
     */
	public void deleteById(Long Id) {
		this.repoTransaction.deleteById(Id);
	}
	/**
	 * Creado por Indira Navas con supervision y ayuda de Oscar Campos 27-01-2021
	 * Servicio que permite el cambio de estado de 1 cuando es Habilitado a 0 cuando esta Inhabilitado
	 * @param id
	 * @param estado
	 */

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
