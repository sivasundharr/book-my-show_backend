package com.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.model.Movie;
import com.cinema.repository.MovieRepository;
import com.cinema.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> findAllMovies() {
		
		return movieRepository.findAll();
	}

	@Override
	public Optional<Movie> findMovieById(Long id) {
		
		return movieRepository.findById(id);
	}

}
