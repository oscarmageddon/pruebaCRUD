package com.practica.ejercicio1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.ejercicio1.Entity.Transaction;
import com.practica.ejercicio1.Service.TransactionService;



@RestController
@RequestMapping(value = "rest")
public class TransactionController {

	private TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@RequestMapping(value = "/tranx", method = RequestMethod.POST)
	public ResponseEntity<Transaction> insertarTransaction(@RequestBody Transaction transaction){
		
		transactionService.saveTransaction(transaction);
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
