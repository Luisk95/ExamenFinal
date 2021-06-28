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
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Clientes;
import com.example.demo.entity.Compras;
import com.example.demo.entity.Consulta;
import com.example.demo.repository.IClientesRepo;
import com.example.demo.repository.ICompras;
@RestController

public class ComprasController {

	@Autowired
	ICompras comprasRepo;

	@GetMapping("/compras")
	
	
	public ResponseEntity<List<Compras>> getAllCompras() {
		try {
			List<Compras> list = comprasRepo.findAll();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(list, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/compras/consulta/{id}")
    public Long getConsulta(@PathVariable Long id){
    Long Total = comprasRepo.Total(id);
	
	return Total;
	}

	
	

	
	@GetMapping("/compras/{id}")
	public ResponseEntity<Compras> getCompras(@PathVariable Long id) {
		Optional<Compras> compras = comprasRepo.findById(id);
		
		if (compras.isPresent()) {
			
			return new ResponseEntity<>(compras.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

	@PostMapping("/compras")
	public ResponseEntity<Compras> saveCompras(@RequestBody Compras compras) {
		try {
			return new ResponseEntity<>(comprasRepo.save(compras), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/compras")
	public ResponseEntity<Compras> updateCompras(@RequestBody Compras compras) {
		try {
			return new ResponseEntity<>(comprasRepo.save(compras), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/compras/{id}")
	public ResponseEntity<HttpStatus> deleteCompras(@PathVariable Long id) {
		try {
			Optional<Compras> compras = comprasRepo.findById(id);
			if (compras.isPresent()) {
				comprasRepo.delete(compras.get());
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
