package com.cinema.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cinema.model.Movie;
import com.cinema.service.MovieService;

@RequestMapping("/movie")
@CrossOrigin("http://localhost:4200/")
@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies(){
		
		List<Movie> findAllMovies = movieService.findAllMovies();
		
		if(findAllMovies.isEmpty())
			return new ResponseEntity<>(findAllMovies,HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(findAllMovies,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id){
		
		Optional<Movie> movie = movieService.findMovieById(id);
		if(movie.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Movie Does NotExists");
		return new ResponseEntity<>(movie.get(),HttpStatus.OK);
	}
}
