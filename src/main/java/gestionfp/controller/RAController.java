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
import gestionfp.model.RA;
import gestionfp.service.RAService;

@RestController
@RequestMapping("/ra")
public class RAController {
	
	@Autowired
	RAService service;
	
	@GetMapping
	public ResponseEntity<List<RA>> getAllNotes() {
		List<RA> result = service.getAllRA();
		return new ResponseEntity<List<RA>>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RA> getNoteById(@PathVariable("id") Long id) throws RecordNotFoundException {
		RA result = service.getRAById(id);
		return new ResponseEntity<RA>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<RA> saveNote(@RequestBody RA ra) throws RecordNotFoundException {
		RA result = service.createOrUpdateRA(ra);
		return new ResponseEntity<RA>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<RA> updateNote(@RequestBody RA ra) throws RecordNotFoundException {
		RA result = service.createOrUpdateRA(ra);
		return new ResponseEntity<RA>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<RA> deleteNoteById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteByRA(id);
		return new ResponseEntity<RA>(null , new HttpHeaders(), HttpStatus.OK);
	}
	
}
