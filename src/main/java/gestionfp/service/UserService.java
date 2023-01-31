package gestionfp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionfp.exception.RecordBadRequestException;
import gestionfp.exception.RecordNotFoundException;
import gestionfp.model.Rol;
import gestionfp.model.User;
import gestionfp.repository.RolesRepository;
import gestionfp.repository.UsersRepository;


@Service
public class UserService {
	@Autowired
	UsersRepository repository;
	@Autowired
	RolesRepository rs;
	
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	
	public List<User> getCentros() {
		List <User> users= getAllUsers();
		ArrayList<User> found = new ArrayList<User>();
		if(users.size()>=1) {
			for(int i=0;i<users.size();i++) {
				if(users.get(i).getRol().equals("Centro Educativo")) {
					found.add(users.get(i));
				}
			}
		}
		return found;
		
	}
	
	public List<User> getAlumnos() {
		List <User> users= getAllUsers();
		ArrayList<User> found = new ArrayList<User>();
		if(users.size()>=1) {
			for(int i=0;i<users.size();i++) {
				if(users.get(i).getRol().equals("Alumno")) {
					found.add(users.get(i));
				}
			}
		}
		return found;
		
	}
	
	public User getUserById(Long id) {
		Optional<User> n= repository.findById(id);
		if(n.isPresent()) {
			return n.get();
		}else {
			throw new RecordNotFoundException("Ususario no encontrado ", id);
		}
	}
	
	public User createOrUpdateUser(User user) {
		
		if(user.getId()!=null) {
			Optional<User> n = repository.findById(user.getId());
			if(n.isPresent()) {
				Optional<Rol> rol=rs.getByName(user.getRol().getNombre());
				if(rol.isPresent()) {
					user.setRol(rol.get());
					user = repository.save(user);
				}else {
					throw new RecordBadRequestException("Rol invalido", user.getId());
				}
			}else {
				throw new RecordNotFoundException("Usuario no encontrado", user.getId());
			}
		}else {
			if(user.isAlta()==true) {
				Optional<Rol> rol=rs.getByName(user.getRol().getNombre());
				if(rol.isPresent()) {
					user.setRol(rol.get());
					user = repository.save(user);
				}else {
					throw new RecordBadRequestException("Rol invalido", user.getId());
				}
			}
		}
		return user;
	}
	
	public void deleteByUser(Long id) {
		Optional<User> n = repository.findById(id);
		if(n.isPresent()) {
			repository.deleteById(id);
		}else {
			throw new RecordNotFoundException("Usuario no encontrado", id);
		}
	}
}

