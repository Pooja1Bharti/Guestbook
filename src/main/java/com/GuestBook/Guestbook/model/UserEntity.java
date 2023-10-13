package com.GuestsBook.Guestbook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@ToString
@Getter
@Setter
public class UserEntity {
	
	

	@GeneratedValue
	private Long uid;
	
	private String uname;
	
	private String password;
	
	private String role;
	
	public UserEntity(Long i, String name, String password, String role) {
		super();
		this.uid=i;
		this.uname=name;
		this.password=password;
		this.role=role;
	}

}
