package gestionfp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionfp.exception.RecordBadRequestException;
import gestionfp.exception.RecordNotFoundException;
import gestionfp.model.CE;
import gestionfp.model.RA;
import gestionfp.repository.CERepository;
import gestionfp.repository.RARepository;

@Service
public class CEService {
	@Autowired
	CERepository repository;
	@Autowired
	RARepository raRepository;
	
	public List<CE> getAllCE() {
		return repository.findAll();
	}
	
	public CE getCEById(Long id) {
		Optional<CE> n= repository.findById(id);
		if(n.isPresent()) {
			return n.get();
		}else {
			throw new RecordNotFoundException("CE no encontrado ", id);
		}
	}
	
	public CE createOrUpdateCE(CE ce) {
		if (ce.getRa() != null) {
			Optional<RA> a = raRepository.findById(ce.getRa().getId());
			if (a.isPresent()) {
				ce = repository.save(ce);
			} else {
				throw new RecordBadRequestException("id_Ra del CE es invalido", ce.getId());
			}
		}else {
			throw new RecordBadRequestException("id_Ra del CE es null", ce.getId());
		}
		return ce;
	}
	
	public void deleteByCE(Long id) {
		Optional<CE> n = repository.findById(id);
		if(n.isPresent()) {
			repository.deleteById(id);
		}else {
			throw new RecordNotFoundException("CE no encontrado", id);
		}
	}
}
