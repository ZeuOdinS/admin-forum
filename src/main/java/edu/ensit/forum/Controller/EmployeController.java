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

import edu.ensit.forum.Service.EmployeService;
import edu.ensit.forum.entity.Employe;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ForumEnsit")
public class EmployeController {
	
	  @Autowired 
	  EmployeService empservice;
    @PostMapping("/employes")
	public  ResponseEntity<?> registerEmpl( @RequestBody Employe employe) {
	return empservice.save(employe);}
	
	@GetMapping("/employes")
	public List<Employe> getEmployes() {
		return empservice.findAll();
	

	}

}
