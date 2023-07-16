package com.cinema.service;

import java.util.List;
import java.util.Optional;

import com.cinema.model.Movie;

public interface MovieService {
	List<Movie> findAllMovies();
	
	Optional<Movie> findMovieById(Long id);
}
