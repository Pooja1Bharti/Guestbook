package com.GuestsBook.Guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GuestsBook.Guestbook.model.GuestBookEntity;
import com.GuestsBook.Guestbook.service.AdministratorServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdministratorController {

	@Autowired
	private AdministratorServiceImpl administratorService;

	@GetMapping("/guestBooks")
	public ResponseEntity<List<GuestBookEntity>> getAllGusetBookEntry() {
		List<GuestBookEntity> guestBookList = administratorService.findAllGuestBook();
		if (!guestBookList.isEmpty() && guestBookList != null)
			return ResponseEntity.ok(guestBookList);
		else
			return ResponseEntity.notFound().build();

	}

	@PutMapping("/status/{guestId}")
	public ResponseEntity<GuestBookEntity> updateStatus(@PathVariable Long guestId) {
		GuestBookEntity entity = administratorService.updateGusetBook(guestId);
		if (entity != null)
			return ResponseEntity.ok(entity);
		else
			return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/update/{guestId}")
	public ResponseEntity<String> deleteGuestBookEntity(@PathVariable Long guestId) {
		administratorService.deleteGuestBookRecord(guestId);
		return ResponseEntity.ok("GuestBookEntry deleted successfully!.");

	}
}
