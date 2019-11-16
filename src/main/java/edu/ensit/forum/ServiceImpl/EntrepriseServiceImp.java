package edu.ensit.forum.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.ensit.forum.Dao.EntrepriseDao;
import edu.ensit.forum.Dao.InviteRepository;
import edu.ensit.forum.Service.EntrepriseService;
import edu.ensit.forum.entity.Entreprise;
import edu.ensit.forum.entity.Invite;
import edu.ensit.forum.jwt.ResponseMessage;
@Service(value = "entrepriseService")

public class EntrepriseServiceImp implements EntrepriseService {

	
	@Autowired
EntrepriseDao entrDao;
	@Autowired
	InviteRepository<Invite> invDao;
	@Override
	public ResponseEntity<?> save(Entreprise entreprise) {
		// TODO Auto-generated method stub
		if (invDao.existsByEmail(entreprise.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		 entrDao.save(entreprise);
			return new ResponseEntity<>(new ResponseMessage("Inscription registered successfully!"), HttpStatus.OK);

	}

	@Override
	public List<Entreprise> findAll() {
		// TODO Auto-generated method stub
		return entrDao.findAll();
	}

	@Override
	public Entreprise findById(Long id) {
		return entrDao.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		entrDao.deleteById(id);
		
	}

	@Override
	public ResponseEntity<?> updateInvite(Entreprise entreprise, long id) {
		if (entrDao.existsByIdNotAndEmail(id, entreprise.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already taken!"),
					HttpStatus.BAD_REQUEST);
		}
		entrDao.save(entreprise);

		return new ResponseEntity<>(new ResponseMessage("Update successfully!"), HttpStatus.OK);
	}

}
