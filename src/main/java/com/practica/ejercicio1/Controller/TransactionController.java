package com.practica.ejercicio1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
		
		@GetMapping("/tranx")
		private List<Transaction> getAllTransactions() {
	        return transactionService.getAllTransactions();
	    }
	
	@RequestMapping(value = "/tranx/", method = RequestMethod.POST)
	public ResponseEntity<Transaction> insertarTransaction(@RequestBody Transaction transaction){
		
		transactionService.saveTransaction(transaction);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/tranx/{id}")
    private void deletePerson(@PathVariable("id") Long id) {
		transactionService.delete(id);
    }
	
	
		@PostMapping("/tranx")
    private Long saveTransaction(@RequestBody Transaction transaction) {
		transactionService.saveOrUpdate(transaction);
        return transaction.getId();
		}

}


