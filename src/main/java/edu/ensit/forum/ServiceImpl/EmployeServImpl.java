package edu.ensit.forum.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import edu.ensit.forum.Dao.EmployeDao;
import edu.ensit.forum.Dao.InviteRepository;
import edu.ensit.forum.Service.EmployeService;
import edu.ensit.forum.entity.Employe;
import edu.ensit.forum.entity.Invite;
import edu.ensit.forum.jwt.ResponseMessage;


@Service(value = "employeService")

public class EmployeServImpl implements EmployeService {

	
	
	@Autowired
	EmployeDao emplDao;
	@Autowired
	InviteRepository<Invite> invDao;
	@Override
	public ResponseEntity<?> save(Employe employe) {
		// TODO Auto-generated method stub
		if (invDao.existsByEmail(employe.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		 emplDao.save(employe);
		return new ResponseEntity<>(new ResponseMessage("Inscription registered successfully!"), HttpStatus.OK);

	}

	@Override
	public List<Employe> findAll() {
		// TODO Auto-generated method stub
		return emplDao.findAll();
	}

	@Override
	public Employe findById(Long id) {
		return emplDao.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		emplDao.deleteById(id);
		
	}

	@Override
	public ResponseEntity<?> updateInvite(Employe employe, long id) {
		if (emplDao.existsByIdNotAndEmail(id, employe.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already taken!"),
					HttpStatus.BAD_REQUEST);
		}
		emplDao.save(employe);

		return new ResponseEntity<>(new ResponseMessage("Update successfully!"), HttpStatus.OK);
	}

}
