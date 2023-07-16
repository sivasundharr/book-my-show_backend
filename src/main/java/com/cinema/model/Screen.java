package com.cinema.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Screen {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String type;
	
	@ManyToOne
	@JoinColumn(name="cinema_House_id")
	private CinemaHouse cinemaHouse;
	
	@JsonIgnore
	@OneToOne(mappedBy="screen")
	private Movie movie;

	public Screen() {
		super();
	}

	public Screen(String type, CinemaHouse cinemaHouse) {
		super();
		this.type = type;
		this.cinemaHouse = cinemaHouse;
		
	}

	
	
}
