package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cinema.model.CinemaHouse;
import com.cinema.model.Movie;
import com.cinema.model.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {
	List<Screen> findByCinemaHouse(CinemaHouse cinemaHouse);
	
	@Query("Select s.movie from Screen s where s.movie.id = ?1")
	Movie findByMovie(Integer id);
}
