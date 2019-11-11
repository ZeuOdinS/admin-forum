package edu.ensit.forum.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.ensit.forum.entity.Entreprise;

public interface EntrepriseService {
	ResponseEntity<?> save(Entreprise entreprise);

	List<Entreprise> findAll();

}
