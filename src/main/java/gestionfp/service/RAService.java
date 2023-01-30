package gestionfp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionfp.exception.RecordBadRequestException;
import gestionfp.exception.RecordNotFoundException;
import gestionfp.model.Modulo;
import gestionfp.model.RA;
import gestionfp.repository.RARepository;

@Service
public class RAService {
	@Autowired
	RARepository repository;
	
	public List<RA> getAllRA() {
		return repository.findAll();
	}
	
	public RA getRAById(Long id) {
		Optional<RA> n= repository.findById(id);
		if(n.isPresent()) {
			return n.get();
		}else {
			throw new RecordNotFoundException("RA no encontrado ", id);
		}
	}
	
	public RA createOrUpdateRA(RA ra) {
		if (ra.getModulo() != null) {
			ModuloService ms = new ModuloService();
			Modulo a = ms.getModuloById(ra.getModulo().getCod_mod_boja());
			if (a.getNombre() != null) {
				ra = repository.save(ra);
			} else {
				throw new RecordBadRequestException("id_Ra del CE es invalido", ra.getId());
			}
		}else {
			throw new RecordBadRequestException("id_Ra del CE es null", ra.getId());
		}
		return ra;
	}
	
	public void deleteByRA(Long id) {
		Optional<RA> n = repository.findById(id);
		if(n.isPresent()) {
			repository.deleteById(id);
		}else {
			throw new RecordNotFoundException("RA no encontrado", id);
		}
	}
}
