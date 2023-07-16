package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
