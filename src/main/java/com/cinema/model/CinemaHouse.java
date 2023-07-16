package com.cinema.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CinemaHouse {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	@Enumerated(EnumType.STRING)
	private CinemaHouseType type;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="cinemaHouse")
	private List<Screen> screens;

	public CinemaHouse(CinemaHouseType type) {
		super();
		this.type = type;
	}

	
	
}
