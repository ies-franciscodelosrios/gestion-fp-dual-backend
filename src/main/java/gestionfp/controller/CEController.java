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
import gestionfp.model.CE;
import gestionfp.service.CEService;

@RestController
@RequestMapping("/ce")
public class CEController {
	
	@Autowired
	CEService service;
	
	@GetMapping
	public ResponseEntity<List<CE>> getAllCE() {
		List<CE> result = service.getAllCE();
		return new ResponseEntity<List<CE>>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CE> getCEById(@PathVariable("id") Long id) throws RecordNotFoundException {
		CE result = service.getCEById(id);
		return new ResponseEntity<CE>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CE> saveCE(@RequestBody CE ce) throws RecordNotFoundException {
		CE result = service.createOrUpdateCE(ce);
		return new ResponseEntity<CE>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<CE> updateCE(@RequestBody CE ce) throws RecordNotFoundException {
		CE result = service.createOrUpdateCE(ce);
		return new ResponseEntity<CE>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CE> deleteCEById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteByCE(id);
		return new ResponseEntity<CE>(null , new HttpHeaders(), HttpStatus.OK);
	}
	
}
