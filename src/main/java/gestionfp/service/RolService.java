package gestionfp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionfp.exception.RecordNotFoundException;
import gestionfp.model.Rol;
import gestionfp.repository.RolesRepository;

@Service
public class RolService {
	@Autowired
	RolesRepository repository;
	
	public List<Rol> getAllRol() {
		return repository.findAll();
	}
	
	public Rol getRolById(Long id) {
		Optional<Rol> n= repository.findById(id);
		if(n.isPresent()) {
			return n.get();
		}else {
			throw new RecordNotFoundException("Rol no encontrado ", id);
		}
	}
	
	public Rol createOrUpdateRol(Rol rol) {
		rol = repository.save(rol);
		return rol;
	}
	
	public void deleteByRol(Long id) {
		Optional<Rol> n = repository.findById(id);
		if(n.isPresent()) {
			repository.deleteById(id);
		}else {
			throw new RecordNotFoundException("Rol no encontrado", id);
		}
	}
}
