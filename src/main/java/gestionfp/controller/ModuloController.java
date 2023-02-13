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
import gestionfp.model.Modulo;
import gestionfp.service.ModuloService;

@RestController
@RequestMapping("/modulo")
public class ModuloController {
	
	@Autowired
	ModuloService service;
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Modulo>> getAllModulos() {
		List<Modulo> result = service.getAllModulo();
		return new ResponseEntity<List<Modulo>>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public ResponseEntity<Modulo> getModuloById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Modulo result = service.getModuloById(id);
		return new ResponseEntity<Modulo>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<Modulo> saveModulo(@RequestBody Modulo modulo) throws RecordNotFoundException {
		Modulo result = service.createOrUpdateModulo(modulo);
		return new ResponseEntity<Modulo>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping
	public ResponseEntity<Modulo> updateModulo(@RequestBody Modulo modulo) throws RecordNotFoundException {
		Modulo result = service.createOrUpdateModulo(modulo);
		return new ResponseEntity<Modulo>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public ResponseEntity<Modulo> deleteModuloById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteByModulo(id);
		return new ResponseEntity<Modulo>(null , new HttpHeaders(), HttpStatus.OK);
	}
	
}
