package edu.ensit.forum.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import edu.ensit.forum.entity.Etudiant;



public interface EtudiantDao  extends InviteRepository<Etudiant>{

	Optional<Etudiant> findByUsername(String email);
    Boolean existsByEmail(String email);

	 Boolean existsByIdNotAndEmail(@Param("id") long id, @Param("email") String email);
	List<Etudiant> findByEmailContaining(String email);
}
