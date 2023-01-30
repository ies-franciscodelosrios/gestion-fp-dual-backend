package gestionfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionfp.model.Encargo;
@Repository
public interface EncargosRepository extends JpaRepository<Encargo, Long> {

}
