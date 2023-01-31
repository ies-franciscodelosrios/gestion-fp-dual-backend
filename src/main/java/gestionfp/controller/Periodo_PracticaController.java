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
import gestionfp.model.Periodo_Practica;
import gestionfp.service.PeriodoService;

@RestController
@RequestMapping("/periodo_practica")
public class Periodo_PracticaController {
	
	@Autowired
	PeriodoService service;
	
	@GetMapping
	public ResponseEntity<List<Periodo_Practica>> getAllPeriodos() {
		List<Periodo_Practica> result = service.getAllPeriodos();
		return new ResponseEntity<List<Periodo_Practica>>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Periodo_Practica> getPeriodoById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Periodo_Practica result = service.getPeriodoById(id);
		return new ResponseEntity<Periodo_Practica>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Periodo_Practica> savePeriodo(@RequestBody Periodo_Practica periodo) throws RecordNotFoundException {
		Periodo_Practica result = service.createOrUpdatePeriodo(periodo);
		return new ResponseEntity<Periodo_Practica>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Periodo_Practica> updatePeriodo(@RequestBody Periodo_Practica periodo) throws RecordNotFoundException {
		Periodo_Practica result = service.createOrUpdatePeriodo(periodo);
		return new ResponseEntity<Periodo_Practica>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Periodo_Practica> deletePeriodoById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteByPeriodo(id);
		return new ResponseEntity<Periodo_Practica>(null , new HttpHeaders(), HttpStatus.OK);
	}
	
}
