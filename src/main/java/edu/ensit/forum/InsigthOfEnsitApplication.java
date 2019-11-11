package edu.ensit.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


import edu.ensit.forum.Service.UserService;
import edu.ensit.forum.entity.User;

@SpringBootApplication
public class InsigthOfEnsitApplication implements CommandLineRunner {
	@Autowired
	PasswordEncoder encoder;
	  @Autowired
	    private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(InsigthOfEnsitApplication.class, args);
		
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		userService.registerUser(new User("24508958", true, "GhoumaNacim","GhoumaNacim", "GhoumaNacim","ROLE_ADMIN_SUP"));
	
	}

}
