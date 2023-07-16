package com.cinema.service.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.model.CinemaHouse;
import com.cinema.model.CinemaHouseType;
import com.cinema.model.Movie;
import com.cinema.model.Screen;
import com.cinema.repository.CinemaHouseRepository;
import com.cinema.repository.MovieRepository;
import com.cinema.repository.ScreenRepository;
import com.cinema.service.CinemaHouseService;

@Service
public class CinemaHouseServiceImpl implements CinemaHouseService {
	
	
	@Autowired
	private CinemaHouseRepository cinemaHouseRepository;
	
	@Autowired
	private ScreenRepository screenRepo;
	
	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	@Transactional
	public void bookTicket() {
		
		CinemaHouse c1 = new CinemaHouse(CinemaHouseType.INOX);
		Screen screen1 = new Screen("IMAX",c1);
		Screen screen2 = new Screen("Dts3",c1);
		Screen screen3 = new Screen("Dts&4D",c1);
		
		c1.setScreens(Arrays.asList(screen1,screen2,screen3));
		
		Movie movie1 = new Movie("MI7 English",LocalDate.of(2023,7, 10),2);
		movie1.setScreen(screen1);
		Movie movie2 = new Movie("MI7 Tamil",LocalDate.of(2023, 7, 10),3);
		movie2.setScreen(screen2);
		Movie movie3 = new Movie("MI7 Hindi",LocalDate.of(2023, 7, 10),3);
		movie3.setScreen(screen3);
		
		movieRepo.saveAll(List.of(movie1,movie2,movie3));
		screenRepo.saveAll(List.of(screen1,screen2,screen3));
		cinemaHouseRepository.save(c1);
		
		CinemaHouse c2 = new CinemaHouse(CinemaHouseType.PVR);
		Screen screen11 = new Screen("IMAX",c2);
		Screen screen21 = new Screen("Dts3",c2);
		Screen screen31 = new Screen("Dts&4D",c2);
		
		c1.setScreens(Arrays.asList(screen11,screen21,screen31));
		
		Movie movie11 = new Movie("FAST X",LocalDate.of(2023,6, 20),2);
		movie11.setScreen(screen11);
		Movie movie21 = new Movie("Adipurush",LocalDate.of(2023, 6, 10),1);
		movie21.setScreen(screen21);
		Movie movie31 = new Movie("MI7 Hindi",LocalDate.of(2023, 7, 15),3);
		movie31.setScreen(screen31);
		
		movieRepo.saveAll(List.of(movie11,movie21,movie31));
		screenRepo.saveAll(List.of(screen11,screen21,screen31));
		cinemaHouseRepository.save(c2);
		
	}
	
	@Override
	public CinemaHouse getCinemaHouseByType(CinemaHouseType type) {
	
		return cinemaHouseRepository.findByType(type);
	}

	@Override
	public List<CinemaHouse> getCinemaHouseByTypes(Collection<CinemaHouseType> type) {
		
		return cinemaHouseRepository.findByAllType(type);
	}

	@Override
	public List<Screen> getAllScreensById(Integer id) {
		
		return cinemaHouseRepository.findScreensById(id);
	}

}
