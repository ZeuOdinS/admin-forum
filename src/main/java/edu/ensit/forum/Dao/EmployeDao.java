package edu.ensit.forum.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import edu.ensit.forum.entity.Employe;

public interface EmployeDao extends InviteRepository<Employe> {

	Optional<Employe> findByUsername(String email);
    Boolean existsByEmail(String email);

	 Boolean existsByIdNotAndEmail(@Param("id") long id, @Param("email") String email);
	List<Employe> findByEmailContaining(String email);
}
