package com.practica.ejercicio1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practica.ejercicio1.Entity.Transaction;
import com.practica.ejercicio1.Service.TransactionService;

@RestController
@RequestMapping(value = "Transaction")
public class TransactionController {

	private TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Transaction> insertarTransaction(@RequestBody Transaction transaction) {

		transactionService.saveTransaction(transaction);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Transaction> deleteTransaction(@PathVariable("id") Long id) {
		this.transactionService.deleteById(id);
		return new ResponseEntity<Transaction>(new Transaction(), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> updateTranx(@RequestBody Transaction transaction, @PathVariable int Id) {
		return ResponseEntity.ok(Boolean.TRUE);
	}

}
