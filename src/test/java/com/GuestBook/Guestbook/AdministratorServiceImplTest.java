package com.GuestsBook.Guestbook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.GuestsBook.Guestbook.model.GuestBookEntity;
import com.GuestsBook.Guestbook.model.UserEntity;
import com.GuestsBook.Guestbook.repository.AdministratirRepository;
import com.GuestsBook.Guestbook.service.AdministratorServiceImpl;

@RunWith(SpringRunner.class)
public class AdministratorServiceImplTest {

	@Autowired
	private AdministratorServiceImpl serviceUser;

	@MockBean
	private AdministratirRepository repo;

	@Test
	public void findAllGuestBookTest() {

		UserEntity entity1 = new UserEntity(1L, "sdf", "werww", "ADMIN");
		UserEntity entity2 = new UserEntity(2L, "sdf", "werww", "ADMIN");
		Mockito.when(repo.findAll())
				.thenReturn(Stream
						.of(new GuestBookEntity(1L, "APPROVED", entity1), new GuestBookEntity(2L, "SUBMITTED", entity2))
						.collect(Collectors.toList()));

		List<GuestBookEntity> retrievedGuests = serviceUser.findAllGuestBook();

		assertThat(retrievedGuests).hasSize(2);
		assertThat(retrievedGuests).extracting("id").contains(1L, 2L);

	}

	@Test
	public void updateGusetBookTest() {

		UserEntity entity1 = new UserEntity(1L, "sdf", "werww", "ADMIN");

		GuestBookEntity entity = new GuestBookEntity(1L, "PENDING", entity1);

		Mockito.when(repo.findById(Mockito.any(Long.class))).thenReturn(Optional.of(entity));

		Mockito.when(repo.save(Mockito.any(GuestBookEntity.class))).thenReturn(entity);
		GuestBookEntity guestBook = serviceUser.updateGusetBook(1L);
		Assertions.assertNotNull(guestBook);
		Assertions.assertEquals("APPROVED", guestBook.getStatus());

	}
	
	@Test
	public void deleteGuestBookRecord() {
		 GuestBookEntity sampleGuest = new GuestBookEntity();
	        sampleGuest.setGuestId(1L);

	        // Mock the behavior of the repository
	        Mockito.when(repo.findById(1L)).thenReturn(Optional.of(sampleGuest));

	        // Instantiate your service

	        // Call the method to test
	        serviceUser.deleteGuestBookRecord(1L);

	        // Verify that the repository's findById and deleteById methods are called
	        Mockito.verify(repo, Mockito.times(1)).findById(1L);
	        Mockito.verify(repo, Mockito.times(1)).deleteById(1L);

	}
	
	@Test
	public void createGuestBook() {
		
		 GuestBookEntity sampleGuest = new GuestBookEntity();
	        sampleGuest.setGuestId(1L);

	        // Mock the behavior of the repository
	        Mockito.when(repo.save(Mockito.any(GuestBookEntity.class))).thenReturn(sampleGuest);



	        // Call the method to test
	        GuestBookEntity createdGuest = serviceUser.createGuestBook(sampleGuest);

	        // Verify that the repository's save method is called
	        Mockito.verify(repo, Mockito.times(1)).save(sampleGuest);
	    }


}
