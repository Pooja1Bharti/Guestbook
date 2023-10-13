package com.GuestsBook.Guestbook.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GuestsBook.Guestbook.exception.ResourceNotFoundException;
import com.GuestsBook.Guestbook.model.GuestBookEntity;
import com.GuestsBook.Guestbook.repository.AdministratirRepository;

@Service
public class AdministratorServiceImpl {
	private static final Logger logger= LoggerFactory.getLogger(AdministratorServiceImpl.class);
	
	@Autowired
	private AdministratirRepository adminRepository;

	public List<GuestBookEntity> findAllGuestBook() {
		
		List<GuestBookEntity> guestList= adminRepository.findAll();
		
		return guestList;
		
		
	}

	public GuestBookEntity updateGusetBook(Long guestId) {
		Optional<GuestBookEntity> entity= adminRepository.findById(guestId);
		if(!entity.isEmpty()) {
			GuestBookEntity guest=entity.get();
			guest.setStatus("APPROVED");
		return	adminRepository.save(guest);
		}
		else {
			throw new ResourceNotFoundException("GuestBookEntry not found with id : " + guestId);
		}
	}

	public void deleteGuestBookRecord(Long guestId) {
		
		GuestBookEntity guestBook = adminRepository.findById(guestId)
                .orElseThrow(() -> new ResourceNotFoundException("GuestBookEntry not found with id : " + guestId));

		adminRepository.deleteById(guestBook.getGuestId());

	}

	public GuestBookEntity createGuestBook(GuestBookEntity guestBook) {
		
		return adminRepository.save(guestBook);
		
	}

}
