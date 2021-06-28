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

import com.example.demo.entity.Compras;
import com.example.demo.entity.Planes;
import com.example.demo.repository.ICompras;
import com.example.demo.repository.IPlanes;
@RestController
public class PlanesController {
	@Autowired
	IPlanes planesRepo;

	@GetMapping("/planes")
	public ResponseEntity<List<Planes>> getallPlanes() {
		try {
			List<Planes> list = planesRepo.findAll();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(list, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/planes/{id}")
	public ResponseEntity<Planes> getPlanes(@PathVariable Long id) {
		Optional<Planes> planes = planesRepo.findById(id);
		
		if (planes.isPresent()) {
			
			return new ResponseEntity<>(planes.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/planes")
	public ResponseEntity<Planes> savePlanes(@RequestBody Planes planes) {
		try {
			return new ResponseEntity<>(planesRepo.save(planes), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/planes")
	public ResponseEntity<Planes> updatePlanes(@RequestBody Planes planes) {
		try {
			return new ResponseEntity<>(planesRepo.save(planes), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/planes/{id}")
	public ResponseEntity<HttpStatus> deletePlanes(@PathVariable Long id) {
		try {
			Optional<Planes> planes = planesRepo.findById(id);
			if (planes.isPresent()) {
				planesRepo.delete(planes.get());
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

