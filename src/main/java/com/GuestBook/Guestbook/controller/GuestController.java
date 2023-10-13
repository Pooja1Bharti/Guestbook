package com.GuestsBook.Guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GuestsBook.Guestbook.model.GuestBookEntity;
import com.GuestsBook.Guestbook.model.UserEntity;
import com.GuestsBook.Guestbook.service.AdministratorServiceImpl;
import com.GuestsBook.Guestbook.service.UserServiceImpl;

@RestController
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	private AdministratorServiceImpl adminServiceImpl;

	@Autowired
	private UserServiceImpl userserviceimpl;

	@GetMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserEntity user) {

		Boolean check = userserviceimpl.loginUser(user);
		if (check)
			return ResponseEntity.ok("login successfull..");
		else
			return ResponseEntity.notFound().build();

	}

	@PostMapping("/create")
	public ResponseEntity<GuestBookEntity> createGuestBook(@RequestBody GuestBookEntity guestBook) {

		GuestBookEntity guestBookentity = adminServiceImpl.createGuestBook(guestBook);

		return ResponseEntity.ok(guestBookentity);

	}

}
