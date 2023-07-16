package com.cinema;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.cinema.model.User;
import com.cinema.repository.UserRepository;
import com.cinema.service.CinemaHouseService;

@EnableJpaAuditing
@SpringBootApplication
public class BookMyShow2Application {
	
	private Logger logger = LoggerFactory.getLogger(BookMyShow2Application.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CinemaHouseService cinemaHouseService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookMyShow2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner run(){
		return args -> {
			logger.info("Application started!!");
			User user1 = new User("Siva","123","address1");
			logger.info("message {}", userRepository.save(user1));
			
			cinemaHouseService.bookTicket();
		};
		
	}

	

}
