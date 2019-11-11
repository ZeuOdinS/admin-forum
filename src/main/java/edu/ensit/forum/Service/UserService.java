package edu.ensit.forum.Service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import edu.ensit.forum.entity.User;



public interface UserService {

    List<User> findAll();
    void delete(Long id);
 ResponseEntity<?> updateUser(User signUpRequest,long id);
ResponseEntity<?> registerUser( User signUpRequest);
List<User> findByUsername(String username);

    User findById(Long id);
	
    
}
