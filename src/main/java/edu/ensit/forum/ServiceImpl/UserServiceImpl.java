package edu.ensit.forum.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;



import edu.ensit.forum.Dao.UserDao;
import edu.ensit.forum.Service.UserService;
import edu.ensit.forum.entity.User;
import edu.ensit.forum.jwt.ResponseMessage;



@Service(value = "userService")
public class UserServiceImpl implements  UserService {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	private UserDao userDao;
	@Override
	public User findById(Long id) {
		return userDao.findById(id).get();
	}
	
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	@Override
	public void delete(Long id) {
		userDao.deleteById(id);
	}

	@Override

	public ResponseEntity<?> updateUser(@Valid @RequestBody User signUpRequest, @PathVariable long id) {

		if (userDao.existsByIdNotAndUsername(id, signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		User user = findById(id);

		if (!signUpRequest.getPassword().equals(user.getPassword())) {
			signUpRequest.setPassword(encoder.encode(signUpRequest.getPassword()));
		}
		signUpRequest.setId(id);
		userDao.save(signUpRequest);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
	
	
	@Override
	public ResponseEntity<?> registerUser(@Valid @RequestBody User signUpRequest) {

		if (userDao.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

	

		// Creating user's account
		User user = new User(signUpRequest.getPhone(), signUpRequest.isEnable(), signUpRequest.getName(),
				signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getRoles());
		userDao.save(user);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}

	@Override
	public List<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsernameContaining(username);
	}



}
