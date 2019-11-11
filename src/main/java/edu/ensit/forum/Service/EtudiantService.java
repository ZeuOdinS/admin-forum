package edu.ensit.forum.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.ensit.forum.entity.Etudiant;

public interface EtudiantService {
	
	ResponseEntity<?>  save(Etudiant etudiant);

	List<Etudiant> findAll();


}
