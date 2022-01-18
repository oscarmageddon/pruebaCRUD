package com.practica.ejercicio1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/")
	public ResponseEntity<Transaction> insertarTransaction(@RequestBody TransactionDto transactionDto)
			throws TransactionException {
		Transaction transaction = new Transaction();
		try {
			transaction.setNombreUsr(transactionDto.getNombreUsr());
			transaction.setApellidoUsr(transactionDto.getApellidoUsr());
			transaction.setDniUsr(transactionDto.getDniUsr());
			transaction.setPaymentMethod(transactionDto.getPaymentMethod());
			transaction.setEstado(transactionDto.getEstado());
			transactionService.saveTransaction(transaction);
		} catch (Exception e) {
			TransactionException ex = new TransactionException();
			ex.setErrorMessage(e.getClass().toString() + " " + e.getMessage());
			ex.setDetail(e.getLocalizedMessage());
			throw ex;
		}
		return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	private ResponseEntity<Transaction> deleteTransaction(@PathVariable("id") Long id) {
		this.transactionService.deleteById(id);
		return new ResponseEntity<Transaction>(new Transaction(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> updateTranx(@RequestBody TransactionDto transaction, @PathVariable long id) {
		transactionService.update(id, transaction.getEstado());
		return ResponseEntity.ok(Boolean.TRUE);
	}
 
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/")
	public ResponseEntity<List<Transaction>> traerTransactions() {
		List<Transaction> transactions = transactionService.traerTransactions();
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/dni/{dniUsr}")
	public ResponseEntity<Transaction> traerTransactionDni(@PathVariable("dniUsr") String dniUsr) {
		Transaction transaction = transactionService.traerTransactionDni(dniUsr);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);

	}
}
