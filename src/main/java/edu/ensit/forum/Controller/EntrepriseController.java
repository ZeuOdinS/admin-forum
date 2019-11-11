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

import edu.ensit.forum.Service.EntrepriseService;
import edu.ensit.forum.entity.Entreprise;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ForumEnsit")
public class EntrepriseController {
	  @Autowired 
	  EntrepriseService entservice;
    @PostMapping("/entreprise")
	public  ResponseEntity<?> registerEntreprise( @RequestBody Entreprise entreprise) {
	return entservice.save(entreprise);}
	
	@GetMapping("/entreprise")
	public List<Entreprise> getEntrprises() {
		return entservice.findAll();
	

	}
}
