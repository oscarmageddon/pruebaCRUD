package com.practica.ejercicio1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.ejercicio1.Entity.Transaction;
import com.practica.ejercicio1.Service.TransactionService;
import com.practica.ejercicio1.dto.TransactionDto;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	private TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@PostMapping("/")
	public ResponseEntity<Transaction> insertarTransaction(@RequestBody TransactionDto transactionDto){
		Transaction transaction = new Transaction();
		transaction.setNombreUsr(transactionDto.getNombreUsr());
		transaction.setApellidoUsr(transactionDto.getApellidoUsr());
		transaction.setDniUsr(transactionDto.getDniUsr());
		transaction.setPaymentMethod(transactionDto.getPaymentMethod());
		transactionService.saveTransaction(transaction);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
	}
}
