package gestionfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionfp.model.CE;
@Repository
public interface CERepository extends JpaRepository<CE, Long> {

}

