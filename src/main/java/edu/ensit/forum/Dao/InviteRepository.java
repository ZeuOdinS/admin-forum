package edu.ensit.forum.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ensit.forum.entity.Invite;

public interface InviteRepository <T extends Invite> extends JpaRepository<T, Long>{
    Boolean existsByEmail(String email);


}
