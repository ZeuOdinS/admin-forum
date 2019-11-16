package edu.ensit.forum.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.ensit.forum.Dao.EtudiantDao;
import edu.ensit.forum.Dao.InviteRepository;
import edu.ensit.forum.Service.EtudiantService;
import edu.ensit.forum.entity.Etudiant;
import edu.ensit.forum.entity.Invite;
import edu.ensit.forum.jwt.ResponseMessage;
@Service(value = "etudiantService")

public class EtudiantServiceImpl implements EtudiantService {
	@Autowired
	EtudiantDao etudDao;
	@Autowired
	InviteRepository<Invite> invDao;
	@Override
	public ResponseEntity<?>  save(Etudiant etudiant) {
		// TODO Auto-generated method stub
		if (invDao.existsByEmail(etudiant.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		 etudDao.save(etudiant);
		return new ResponseEntity<>(new ResponseMessage("Inscription registered successfully!"), HttpStatus.OK);

	}

	@Override
	public List<Etudiant> findAll() {
		// TODO Auto-generated method stub
		return etudDao.findAll();
	}

	@Override
	public Etudiant findById(Long id) {
		return etudDao.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		etudDao.deleteById(id);
		
	}

	@Override
	public ResponseEntity<?> updateInvite(Etudiant etud, long id) {
		if (etudDao.existsByIdNotAndEmail(id, etud.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already taken!"),
					HttpStatus.BAD_REQUEST);
		}
		etudDao.save(etud);

		return new ResponseEntity<>(new ResponseMessage("Update successfully!"), HttpStatus.OK);
	}

}
