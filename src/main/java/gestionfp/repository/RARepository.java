package gestionfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionfp.model.RA;
@Repository
public interface RARepository extends JpaRepository<RA, Long> {

}
