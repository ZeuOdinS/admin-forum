package edu.ensit.forum.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.ensit.forum.entity.Etudiant;
import edu.ensit.forum.entity.User;

public interface EtudiantService {
	
	ResponseEntity<?>  save(Etudiant etudiant);

	List<Etudiant> findAll();
	Etudiant findById(Long id);
	void delete(Long id);
	 ResponseEntity<?> updateInvite(Etudiant entreprise,long id);

}
