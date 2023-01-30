package gestionfp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import gestionfp.exception.RecordNotFoundException;
import gestionfp.model.Encargo;
import gestionfp.service.EncargoService;

@RestController
@RequestMapping("/encargo")
public class EncargoController {
	
	@Autowired
	EncargoService service;
	
	@GetMapping
	public ResponseEntity<List<Encargo>> getAllNotes() {
		List<Encargo> result = service.getAllEncargo();
		return new ResponseEntity<List<Encargo>>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Encargo> getNoteById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Encargo result = service.getEncargoById(id);
		return new ResponseEntity<Encargo>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Encargo> saveNote(@RequestBody Encargo encargo) throws RecordNotFoundException {
		Encargo result = service.createOrUpdateEncargo(encargo);
		return new ResponseEntity<Encargo>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Encargo> updateNote(@RequestBody Encargo encargo) throws RecordNotFoundException {
		Encargo result = service.createOrUpdateEncargo(encargo);
		return new ResponseEntity<Encargo>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Encargo> deleteNoteById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteByEncargo(id);
		return new ResponseEntity<Encargo>(null , new HttpHeaders(), HttpStatus.OK);
	}
	
}
