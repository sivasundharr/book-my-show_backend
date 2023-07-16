package com.cinema.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Movie {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private LocalDate releaseDate;
	
	private Integer showCycle;
	
	@OneToOne
	@JoinColumn(name="screen_id")
	private Screen screen;
	
	@JsonIgnore
	@OneToMany(mappedBy="movie")
	private List<Booking> booking = new ArrayList<>();

	public Movie() {
		super();

	}

	public Movie(String name, LocalDate releaseDate, Integer showCycle) {
		super();
		this.name = name;
		this.releaseDate = releaseDate;
		this.showCycle = showCycle;
	}
	
	
}
