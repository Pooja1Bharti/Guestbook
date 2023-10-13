package com.GuestsBook.Guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GuestsBook.Guestbook.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	

}
