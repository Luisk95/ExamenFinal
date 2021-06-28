package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.entity.Clientes;
import com.example.demo.repository.IClientesRepo;

@RestController

public class ClientesController {

	@Autowired
	IClientesRepo clientesRepo;

	@GetMapping("/clientes")
	public ResponseEntity<List<Clientes>> getAllClientes() {
		try {
			List<Clientes> list = clientesRepo.findAll();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(list, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Clientes> getClientes(@PathVariable Long id) {
		Optional<Clientes> clientes = clientesRepo.findById(id);
		
		if (clientes.isPresent()) {
			return new ResponseEntity<>(clientes.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/clientes")
	public ResponseEntity<Clientes> saveClientes(@RequestBody Clientes clientes) {
		try {
			return new ResponseEntity<>(clientesRepo.save(clientes), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/clientes")
	public ResponseEntity<Clientes> updateClientes(@RequestBody Clientes clientes) {
		try {
			return new ResponseEntity<>(clientesRepo.save(clientes), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<HttpStatus> deleteClientes(@PathVariable Long id) {
		try {
			Optional<Clientes> clientes = clientesRepo.findById(id);
			if (clientes.isPresent()) {
				clientesRepo.delete(clientes.get());
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}