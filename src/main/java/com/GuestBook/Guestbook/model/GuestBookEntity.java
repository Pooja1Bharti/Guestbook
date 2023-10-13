package com.GuestsBook.Guestbook.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class GuestBookEntity {
	
	@GeneratedValue
	private Long guestId;
	
	private String status;
	
	@ManyToAny
	@JoinColumn(name ="uid")
	private UserEntity user;



}
