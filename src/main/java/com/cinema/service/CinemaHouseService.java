package com.cinema.service;

import java.util.Collection;
import java.util.List;

import com.cinema.model.CinemaHouse;
import com.cinema.model.CinemaHouseType;
import com.cinema.model.Screen;

public interface CinemaHouseService {
	
	void bookTicket();

	CinemaHouse getCinemaHouseByType(CinemaHouseType type);
	
	List<Screen> getAllScreensById(Integer id);
	
	List<CinemaHouse> getCinemaHouseByTypes(Collection<CinemaHouseType> type);
	
}
