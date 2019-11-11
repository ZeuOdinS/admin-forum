package edu.ensit.forum.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.ensit.forum.entity.Employe;

public interface EmployeService {
	

	ResponseEntity<?> save(Employe employe);
	
    List<Employe> findAll();
    
   

}
