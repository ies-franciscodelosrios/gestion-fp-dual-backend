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
import gestionfp.model.Rol;
import gestionfp.service.RolService;

@RestController
@RequestMapping("/roles")
public class RolController {
	
	@Autowired
	RolService service;
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Rol>> getAllRoles() {
		List<Rol> result = service.getAllRol();
		return new ResponseEntity<List<Rol>>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public ResponseEntity<Rol> getRolById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Rol result = service.getRolById(id);
		return new ResponseEntity<Rol>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<Rol> saveRol(@RequestBody Rol rol) throws RecordNotFoundException {
		Rol result = service.createOrUpdateRol(rol);
		return new ResponseEntity<Rol>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping
	public ResponseEntity<Rol> updateRol(@RequestBody Rol rol) throws RecordNotFoundException {
		Rol result = service.createOrUpdateRol(rol);
		return new ResponseEntity<Rol>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public ResponseEntity<Rol> deleteRolById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteByRol(id);
		return new ResponseEntity<Rol>(null , new HttpHeaders(), HttpStatus.OK);
	}
	
}
