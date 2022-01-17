package com.practica.ejercicio1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.ejercicio1.Entity.Transaction;
import com.practica.ejercicio1.Service.TransactionService;
import com.practica.ejercicio1.dto.TransactionDto;
import com.practica.ejercicio1.exception.TransactionException;



@RestController
@RequestMapping("/transaction")
public class TransactionController {

	private TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	

	@PostMapping("/")
	public ResponseEntity<Transaction> insertarTransaction(@RequestBody TransactionDto transactionDto) throws TransactionException{
		Transaction transaction = new Transaction();
		try {
			transaction.setNombreUsr(transactionDto.getNombreUsr());
			transaction.setApellidoUsr(transactionDto.getApellidoUsr());
			transaction.setDniUsr(transactionDto.getDniUsr());
			transaction.setPaymentMethod(transactionDto.getPaymentMethod());
			transactionService.saveTransaction(transaction);
		} 
		catch (Exception e) {
			TransactionException ex = new TransactionException();
			ex.setErrorMessage(e.getClass().toString() + " " + e.getMessage());
			ex.setDetail(e.getLocalizedMessage());
			throw ex;
		}
		return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/tranx", method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> traerTransactions () {
		List<Transaction> transactions = transactionService.traerTransactions();
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/tranx/dni/{dniUsr}", method = RequestMethod.GET)
	public ResponseEntity<Transaction> traerTransactionDni(@PathVariable("dniUsr") String dniUsr) {
		Transaction transaction = transactionService.traerTransactionDni(dniUsr);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
	}
	
	
	
}
