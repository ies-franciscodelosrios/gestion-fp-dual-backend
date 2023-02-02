package gestionfp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionfp.exception.RecordBadRequestException;
import gestionfp.exception.RecordNotFoundException;
import gestionfp.model.Titulo;
import gestionfp.repository.TitulosRepository;

@Service
public class TituloService {
	@Autowired
	TitulosRepository repository;
	
	public List<Titulo> getAllTitulos() {
		return repository.findAll();
	}
	
	public Titulo getTituloById(Long id) {
		Optional<Titulo> n= repository.findById(id);
		if(n.isPresent()) {
			return n.get();
		}else {
			throw new RecordNotFoundException("Titulo no encontrado ", id);
		}
	}
	
	public Titulo createOrUpdateTitulo(Titulo titulo) {
		if(titulo.getNombre()!=null) {
			titulo = repository.save(titulo);
		}else {
			throw new RecordBadRequestException("Periodo_Practica no contine lo campos necesarios ", titulo.getId());
		}
		return titulo;
	}
	
	public void deleteByTitulo(Long id) {
		Optional<Titulo> n = repository.findById(id);
		if(n.isPresent()) {
			repository.deleteById(id);
		}else {
			throw new RecordNotFoundException("Titulo no encontrado", id);
		}
	}
}