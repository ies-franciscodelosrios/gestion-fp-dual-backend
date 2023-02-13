package gestionfp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionfp.exception.RecordNotFoundException;
import gestionfp.model.Titulo;
import gestionfp.service.TituloService;

@RestController
@RequestMapping("/titulo")
public class TituloController {
	
	@Autowired
	TituloService service;
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Titulo>> getAllTitulos() {
		List<Titulo> result = service.getAllTitulos();
		return new ResponseEntity<List<Titulo>>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public ResponseEntity<Titulo> getTituloById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Titulo result = service.getTituloById(id);
		return new ResponseEntity<Titulo>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<Titulo> saveTitulo(@RequestBody Titulo titulo) throws RecordNotFoundException {
		Titulo result = service.createOrUpdateTitulo(titulo);
		return new ResponseEntity<Titulo>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping
	public ResponseEntity<Titulo> updateTitulo(@RequestBody Titulo titulo) throws RecordNotFoundException {
		Titulo result = service.createOrUpdateTitulo(titulo);
		return new ResponseEntity<Titulo>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public ResponseEntity<Titulo> deleteTituloById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteByTitulo(id);
		return new ResponseEntity<Titulo>(null , new HttpHeaders(), HttpStatus.OK);
	}
	
}
