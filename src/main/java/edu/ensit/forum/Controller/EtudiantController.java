package edu.ensit.forum.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ensit.forum.Service.EtudiantService;
import edu.ensit.forum.entity.Etudiant;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ForumEnsit")
public class EtudiantController {
	
	 @Autowired 
	  EtudiantService etudiantservice;
   @PostMapping("/etudiant")
	public  ResponseEntity<?> registerEntreprise( @RequestBody Etudiant etudiant) {
	return etudiantservice.save(etudiant);}
	
	@GetMapping("/etudiant")
	public List<Etudiant> getEntrprises() {
		return etudiantservice.findAll();
	

	}
}



