package edu.ensit.forum.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ensit.forum.Service.UserService;
import edu.ensit.forum.entity.User;
import edu.ensit.forum.jwt.JwtProvider;
import edu.ensit.forum.jwt.JwtResponse;
import edu.ensit.forum.jwt.LoginForm;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ForumEnsit")

public class UserController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;
    @Autowired
    private UserService userService;
    
 
    
  

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }




	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> updateUser(@Valid @RequestBody User signUpRequest, @PathVariable long id) {
	return userService.updateUser(signUpRequest, id);

	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User signUpRequest) {
	return userService.registerUser(signUpRequest);

	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println(userDetails.getPassword());
		String jwt = jwtProvider.generateJwtToken(authentication);
		System.out.println(jwt);

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}  
    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable(value = "id") Long id){
    	userService.delete(id);
    }

	@PostMapping("/searchuers")
    public List<User> findByUsername(@RequestBody String username){
		System.out.println(username);
    	return userService.findByUsername(username);
    }

}
