package com.practica.ejercicio1.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.ejercicio1.Entity.Transaction;
import com.practica.ejercicio1.Service.TransactionService;
import com.practica.ejercicio1.dto.TransactionDto;
import com.practica.ejercicio1.exception.ResourceNotFoundException;
import com.practica.ejercicio1.exception.TransactionException;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

	private TransactionService transactionService;
	private static final String _MSG_TRANSACCION_EXISTENTE = "No se pudo crear la transaccion: Rut de cliente ya existe";
   //27-01-2022 E.C Se corrije mensaje dependiendo si es editar o agregar
	private static final String _MSG_TRANSACCION_EXISTENTE_EDITAR = "No se pudo editar la transaccion: Rut de cliente ya existe";
	private static final String _MSG_TRANSACCION_NO_ENCONTRADA = "No se encontro la transaccion para el rut ingresado";
	private static final String _MSG_TRANSACCION_NO_ENCONTRADA_BY_ID = "No se encontro la transaccion para el id ingresado";

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	/**
	 * Creado por Oscar Campos 27-01-2022
	 * 
	 * @param transactionDto
	 * @return
	 * @throws TransactionException
	 */
	@PostMapping("/")
	public ResponseEntity<Transaction> insertarTransaction(@Valid @RequestBody TransactionDto transactionDto)
			throws TransactionException {
		Transaction transaction = new Transaction();
		try {
			
			transaction.setNombreUsr(transactionDto.getNombreUsr());
			transaction.setApellidoUsr(transactionDto.getApellidoUsr());
			transaction.setDniUsr(transactionDto.getDniUsr());
			transaction.setPaymentMethod(transactionDto.getPaymentMethod());
			transaction.setEstado(transactionDto.getEstado());
			Transaction transactionBusqueda = transactionService.traerTransactionDni(transactionDto.getDniUsr());
			if (transactionBusqueda != null) {
				TransactionException ex = new TransactionException();
				ex.setErrorMessage(_MSG_TRANSACCION_EXISTENTE);
				throw ex;
			}
			transactionService.saveTransaction(transaction);

		} catch (TransactionException e) {
			throw e;
		} catch (Exception e) {
			TransactionException ex = new TransactionException();
			ex.setErrorMessage(e.getClass().toString() + " " + e.getMessage());
			throw ex;
		}
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	
	/** 
    * Creado por Indira Navas 27-01-2022 Supervisado por Mario Tigua
    * Metodo que elimina por id todas las Entidades Transaction existentes en BD
    * @param id
    * @return
    */
	@DeleteMapping("/{id}")
	private ResponseEntity<Transaction> deleteTransaction(@PathVariable("id") Long id) {
		this.transactionService.deleteById(id);
		return new ResponseEntity<Transaction>(new Transaction(), HttpStatus.OK);
	}

	/** Creado por Indira Navas 27-01-2022 Supervisado por Oscar Ramos
	 * * Metodo que actualiza por id todas las Entidades Transaction existentes en BD
	 * @param transaction
	 * @param id
	 * @return
	 */

	
	/** Creado por Edgar Chavez 27-01-2022 Supervisado por Oscar Ramos
	 * * Metodo que actualiza por id todas las Entidades Transaction existentes en BD(Habilita/Inhabilita)
	 * @param transaction
	 * @param id
	 * @return
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> updateTranx(@RequestBody TransactionDto transaction, @PathVariable long id) {
		this.transactionService.update(id, transaction.getEstado());
		return ResponseEntity.ok(Boolean.TRUE);
	}

	/**
	 * Creado por Moises Neira
	 * Metodo que trae todas las Entidades Transaction existentes en BD.
	 * 
	 * @return
	 */

	@GetMapping("/")
	public ResponseEntity<List<Transaction>> traerTransactions() {
		List<Transaction> transactions = transactionService.traerTransactions();
		System.out.println("Transacciones: " + transactions.size());
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}

	
	/**
	 * Metodo que trae de BD una entidad Transaction segun el dni ingresado
	 * Creado por Moises Neira
	 * @param dniUsr
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/dni/{dniUsr}")
	public ResponseEntity<Transaction> traerTransactionDni(@PathVariable("dniUsr") String dniUsr)
			throws ResourceNotFoundException {
		Transaction transaction = transactionService.traerTransactionDni(dniUsr);
		if (transaction == null) {
			ResourceNotFoundException ex = new ResourceNotFoundException(_MSG_TRANSACCION_NO_ENCONTRADA);
			throw ex;
		}
		return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
	}

	
	/**
	 * Creado por Mario Tigua
	 * Metodo que permite actualizar una transaccion
	 * @param transactionDto
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws TransactionException
	 */
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Object> actualizarTransaction(@Valid @RequestBody TransactionDto transactionDto,
			@PathVariable Long id) throws ResourceNotFoundException, TransactionException {
		Transaction transactionIdBd = transactionService.getTransactionById(id);
		if (transactionIdBd == null) {
			ResourceNotFoundException ex = new ResourceNotFoundException(_MSG_TRANSACCION_NO_ENCONTRADA_BY_ID);
			throw ex;
		}
		Transaction transactionDniBd = transactionService.traerTransactionDni(transactionDto.getDniUsr());
		if (transactionDniBd != null && id != transactionDniBd.getId()) {
			TransactionException ex = new TransactionException();
			//Se Corrije Mensaje de Alerta E.C
			ex.setErrorMessage(_MSG_TRANSACCION_EXISTENTE_EDITAR);
			throw ex;
		}
		transactionIdBd.setNombreUsr(transactionDto.getNombreUsr());
		transactionIdBd.setApellidoUsr(transactionDto.getApellidoUsr());
		transactionIdBd.setDniUsr(transactionDto.getDniUsr());
		transactionIdBd.setPaymentMethod(transactionDto.getPaymentMethod());
		transactionIdBd.setEstado(transactionDto.getEstado());
		
		transactionService.saveTransaction(transactionIdBd);
		
		return ResponseEntity.ok(Boolean.TRUE);
	}

}
