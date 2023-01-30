package gestionfp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionfp.exception.RecordBadRequestException;
import gestionfp.exception.RecordNotFoundException;
import gestionfp.model.Encargo;
import gestionfp.model.Periodo_Practica;
import gestionfp.repository.EncargosRepository;
import gestionfp.repository.PeriodosRepository;

@Service
public class EncargoService {
	@Autowired
	EncargosRepository repository;
	@Autowired
	PeriodosRepository repository2;
	
	public List<Encargo> getAllEncargo() {
		return repository.findAll();
	}
	
	public Encargo getEncargoById(Long id) {
		Optional<Encargo>  n= repository.findById(id);
		if(n.isPresent()) {
			return n.get();
		}else {
			throw new RecordNotFoundException("Encargo no encontrado ", id);
		}
	}
	
	public Encargo createOrUpdateEncargo(Encargo encargo) {
		if(encargo.getPeriodo_practica().getId()!=null) {	
			Optional<Periodo_Practica> n = repository2.findById(encargo.getPeriodo_practica().getId());
			if(n.isPresent()) {
				encargo = repository.save(encargo);
			}else {
				throw new RecordNotFoundException("Periodo Practicas del encargo no encontrado", encargo.getId());
			}
		}else {
			throw new RecordBadRequestException("Se necesita un periodo Practicas del encargo", encargo.getId());
		}
		return encargo;
	}
	
	public void deleteByEncargo(Long id) {
		Optional<Encargo> n = repository.findById(id);
		if(n.isPresent()) {
			repository.deleteById(id);
		}else {
			throw new RecordNotFoundException("Encargo no encontrado", id);
		}
	}
}
