package edu.ensit.forum.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.ensit.forum.entity.Entreprise;
import edu.ensit.forum.entity.Etudiant;

public interface EntrepriseService {
	ResponseEntity<?> save(Entreprise entreprise);

	List<Entreprise> findAll();
	Entreprise findById(Long id);
	void delete(Long id);
	 ResponseEntity<?> updateInvite(Entreprise entreprise,long id);

}
