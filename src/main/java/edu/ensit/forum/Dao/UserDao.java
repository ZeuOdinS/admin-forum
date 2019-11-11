package edu.ensit.forum.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ensit.forum.entity.User;



@Repository
public interface UserDao extends JpaRepository<User, Long> {
 
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

	 Boolean existsByIdUserNotAndUsername(@Param("idUser") long idUser, @Param("username") String username);
	List<User> findByUsernameContaining(String username);




}
