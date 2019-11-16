package edu.ensit.forum.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.ensit.forum.entity.Employe;
import edu.ensit.forum.entity.Etudiant;

public interface EmployeService {
	

	ResponseEntity<?> save(Employe employe);
	
    List<Employe> findAll();
    Employe findById(Long id);
	void delete(Long id);
	 ResponseEntity<?> updateInvite(Employe employe,long id);
   

}
