package com.GuestsBook.Guestbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GuestsBook.Guestbook.model.GuestBookEntity;

@Repository
public interface AdministratirRepository extends JpaRepository<GuestBookEntity, Long> {

	@Query("select from GuestBookEntity")
	 List<GuestBookEntity> findAllGuest();

}
