package gestionfp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionfp.exception.RecordBadRequestException;
import gestionfp.exception.RecordNotFoundException;
import gestionfp.model.Modulo;
import gestionfp.repository.ModulosRepository;

@Service
public class ModuloService {
	@Autowired
	ModulosRepository repository;
	
	public List<Modulo> getAllModulo() {
		return repository.findAll();
	}
	
	public Modulo getModuloById(Long id) {
		Optional<Modulo> n= repository.findById(id);
		if(n.isPresent()) {
			return n.get();
		}else {
			throw new RecordNotFoundException("Modulo no encontrado ", id);
		}
	}
	
	public Modulo createOrUpdateModulo(Modulo modulo) {
		if(modulo.getCod_mod_boja()!=null) {
			boolean create=true;
			List<Modulo> modulos = getAllModulo();
			for(Modulo e: modulos) {
				if(e.getNombre().equals(modulo.getNombre())) {
					create =false;
				}
			}
			if(create) {
				modulo = repository.save(modulo);
			}else {
				throw new RecordBadRequestException("El nombre del modulo ya existe", modulo.getCod_mod_boja());
			}
		}else {
			modulo = repository.save(modulo);
		}
		return modulo;
	}
	
	public void deleteByModulo(Long id) {
		Optional<Modulo> n = repository.findById(id);
		if(n.isPresent()) {
			repository.deleteById(id);
		}else {
			throw new RecordNotFoundException("Modulo no encontrado", id);
		}
	}
}
