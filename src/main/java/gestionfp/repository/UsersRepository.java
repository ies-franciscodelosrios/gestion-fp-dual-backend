package gestionfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionfp.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

}
