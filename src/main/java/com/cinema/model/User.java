package com.cinema.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name="movie_users")
@Data
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String userName;
	private String password;
	private String address;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Booking> bookedList = new ArrayList<>();
	
	public User() {
		
	}
	
	public User(String userName,String password,String address) {
		this.userName = userName;
		this.password = password;
		this.address = address;
	}

}
