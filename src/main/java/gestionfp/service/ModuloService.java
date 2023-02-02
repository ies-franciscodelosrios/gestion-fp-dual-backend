package gestionfp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionfp.exception.RecordBadRequestException;
import gestionfp.exception.RecordNotFoundException;
import gestionfp.model.Modulo;
import gestionfp.model.Titulo;
import gestionfp.repository.ModulosRepository;
import gestionfp.repository.TitulosRepository;

@Service
public class ModuloService {
	@Autowired
	ModulosRepository repository;
	@Autowired
	TitulosRepository tiRepository;
	
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
		if(modulo.getTitulo()!=null) {
			Optional<Titulo> a=tiRepository.findById(modulo.getTitulo().getId());
			if(a.isPresent()) {
				modulo=repository.save(modulo);
			}
			
		}else {
			throw new RecordBadRequestException("id_Ra del CE es null", modulo.getCod_mod_boja());
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
