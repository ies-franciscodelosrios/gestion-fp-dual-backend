package gestionfp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionfp.exception.RecordBadRequestException;
import gestionfp.exception.RecordNotFoundException;
import gestionfp.model.Periodo_Practica;
import gestionfp.model.User;
import gestionfp.repository.PeriodosRepository;
import gestionfp.repository.UsersRepository;

@Service
public class PeriodoService {
	@Autowired
	PeriodosRepository repository;
	@Autowired
	UsersRepository userRepository;
	
	public List<Periodo_Practica> getAllPeriodos() {
		return repository.findAll();
	}
	
	public Periodo_Practica getPeriodoById(Long id) {
		Optional<Periodo_Practica> n= repository.findById(id);
		if(n.isPresent()) {
			return n.get();
		}else {
			throw new RecordNotFoundException("Periodo_Practica no encontrado ", id);
		}
	}
	
	public Periodo_Practica createOrUpdatePeriodo(Periodo_Practica periodo) {
		if(periodo.getId_alumno()!=null && periodo.getId_centro()!=null
				&& periodo.getId_empresa()!=null) {
			User al=userRepository.getById(periodo.getId_alumno().getId());
			User cen=userRepository.getById(periodo.getId_centro().getId());
			User emp=userRepository.getById(periodo.getId_empresa().getId());
			if(al.getId()!=null && cen.getId()!=null && emp.getId()!=null) {
				periodo =repository.save(periodo);
			}else {
				throw new RecordNotFoundException("No se ha podido encontrar un valor de Periodo_Practica", periodo.getId());
			}
		}else {
			throw new RecordBadRequestException("Periodo_Practica no contine lo campos necesarios ", periodo.getId());
		}
		return periodo;
	}
	
	public void deleteByPeriodo(Long id) {
		Optional<Periodo_Practica> n = repository.findById(id);
		if(n.isPresent()) {
			repository.deleteById(id);
		}else {
			throw new RecordNotFoundException("Periodo_Practica no encontrado", id);
		}
	}
	
	public List<Periodo_Practica> getPeriodoByIdEmpresa(Long id){
		List <Periodo_Practica> all = repository.findAll();
		List <Periodo_Practica> result = new ArrayList<Periodo_Practica>();
		for(Periodo_Practica e: all) {
			if(e.getId_empresa().getId()==id) {
				result.add(e);
			}
		}
		return result;
		
	}
	
	
}
