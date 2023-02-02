package gestionfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionfp.model.Titulo;

public interface TitulosRepository extends JpaRepository<Titulo, Long> {

}
