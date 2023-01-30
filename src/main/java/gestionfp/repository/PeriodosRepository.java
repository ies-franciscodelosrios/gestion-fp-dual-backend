package gestionfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionfp.model.Periodo_Practica;
@Repository
public interface PeriodosRepository extends JpaRepository<Periodo_Practica, Long> {

}
