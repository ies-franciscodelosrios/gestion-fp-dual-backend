package gestionfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionfp.model.Rol;

@Repository
public interface RolesRepository extends JpaRepository<Rol, Long> {

}

