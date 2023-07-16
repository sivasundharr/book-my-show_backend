package com.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cinema.model.CinemaHouse;
import com.cinema.model.CinemaHouseType;
import com.cinema.model.Screen;
import com.cinema.service.CinemaHouseService;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
	
	@Autowired
	private CinemaHouseService cinemaHouseService;
	
	
	@GetMapping("/{type}/screen")
	public ResponseEntity<List<Screen>> getCinemaByType(@PathVariable("type") String type){
		CinemaHouse cinemaHouse;
		try {
			cinemaHouse = cinemaHouseService.getCinemaHouseByType(CinemaHouseType.valueOf(type.toUpperCase()));
		}catch(IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cinema Type is not available");
		}
		
		List<Screen> screens = cinemaHouseService.getAllScreensById(cinemaHouse.getId());
		
		return new ResponseEntity<>(screens,HttpStatus.OK);
	}
	
}
