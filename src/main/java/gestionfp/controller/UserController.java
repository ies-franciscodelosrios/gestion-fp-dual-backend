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
import gestionfp.model.User;
import gestionfp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllNotes() {
		List<User> result = service.getAllUsers();
		return new ResponseEntity<List<User>>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getNoteById(@PathVariable("id") Long id) throws RecordNotFoundException {
		User result = service.getUserById(id);
		return new ResponseEntity<User>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> saveNote(@RequestBody User user) throws RecordNotFoundException {
		User result = service.createOrUpdateUser(user);
		return new ResponseEntity<User>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<User> updateNote(@RequestBody User user) throws RecordNotFoundException {
		User result = service.createOrUpdateUser(user);
		return new ResponseEntity<User>(result, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteNoteById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteByUser(id);
		return new ResponseEntity<User>(null , new HttpHeaders(), HttpStatus.OK);
	}
	
}
