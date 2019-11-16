package edu.ensit.forum.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	 @RequestMapping(value = "/entreprises/{id}", method = RequestMethod.GET)
	    public Entreprise getOne(@PathVariable(value = "id") Long id){
	        return entservice.findById(id);
	    }
	 @RequestMapping(value = "/entreprises/delete/{id}", method = RequestMethod.GET)
	 public void deleteById(@PathVariable(value = "id") Long id){
		 entservice.delete(id);
	 }
	 
	@PutMapping("/updateEntreprise/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Entreprise entreprise, @PathVariable long id) {
		return entservice.updateInvite(entreprise, id);

	}
}
