package com.cinema.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cinema.model.CinemaHouse;
import com.cinema.model.CinemaHouseType;
import com.cinema.model.Screen;

public interface CinemaHouseRepository extends JpaRepository<CinemaHouse,Integer>{
	
	CinemaHouse findByType(CinemaHouseType type);
	
	@Query("select c from CinemaHouse c where c.type in :types ")
	List<CinemaHouse> findByAllType(@Param("types") Collection<CinemaHouseType> types);
	
	@Query("select c.screens from CinemaHouse c where c.id=?1 ")
	List<Screen> findScreensById(Integer id);
}
