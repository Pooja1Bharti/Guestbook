package com.GuestsBook.Guestbook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GuestsBook.Guestbook.model.UserEntity;
import com.GuestsBook.Guestbook.repository.UserRepository;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepo;

	public Boolean loginUser(UserEntity user) {
		Optional<UserEntity> userEntity = userRepo.findById(user.getUid());
		
		if(userEntity.isPresent()) {
			if(userEntity.get().getPassword().equals(user.getPassword()))
				return true;
		}
		
		return false;
	}
	
	

}
