package gestionfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionfp.model.Modulo;
@Repository
public interface ModulosRepository extends JpaRepository<Modulo, Long> {

}

