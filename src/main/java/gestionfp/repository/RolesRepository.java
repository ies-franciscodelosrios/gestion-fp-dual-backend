package gestionfp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gestionfp.model.Rol;

@Repository
public interface RolesRepository extends JpaRepository<Rol, Long> {
	@Query(
			value="SELECT * FROM roles WHERE nombre = ?1 ",
			nativeQuery=true)
	Optional<Rol> getByName(String name);
}

