package com.GuestsBook.Guestbook;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.GuestsBook.Guestbook.model.UserEntity;
import com.GuestsBook.Guestbook.repository.UserRepository;
import com.GuestsBook.Guestbook.service.UserServiceImpl;

@SpringBootTest
class GuestbookApplicationTests {

	@Autowired
	private UserServiceImpl serviceUser;

	@Mock
	private UserRepository userRepo;

	@Test
	public void contextLoads() {

		UserEntity sampleUser = new UserEntity();
		sampleUser.setUid(1L);
		sampleUser.setPassword("password123");

		Mockito.when(userRepo.findById(1L)).thenReturn(Optional.of(sampleUser));

		UserEntity userToLogin = new UserEntity();
		userToLogin.setUid(1L);
		userToLogin.setPassword("password123");
		Boolean loginResult = serviceUser.loginUser(userToLogin);
		Assertions.assertTrue(loginResult);

	}

}
