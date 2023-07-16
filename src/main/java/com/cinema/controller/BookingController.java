package com.cinema.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cinema.dto.BookingDto.CreateBookingDto;
import com.cinema.model.Booking;
import com.cinema.model.Movie;
import com.cinema.model.User;
import com.cinema.service.BookingService;
import com.cinema.service.MovieService;
import com.cinema.service.UserService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping
	public ResponseEntity<Booking> createBooking(@RequestBody CreateBookingDto bookingDto){
		if(bookingDto==null)
			throw new IllegalArgumentException("fields must not be empty");
		
		Optional<User> user =  userService.findUserById(bookingDto.getUser());
		if(user.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found");
		
		Optional<Movie> movie = movieService.findMovieById(bookingDto.getMovie());
		if(movie.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"movie not present");
		
		if(bookingDto.getShowSlot()<0 && (bookingDto.getShowSlot() > movie.get().getShowCycle()))
			throw new IllegalArgumentException("This movie has daily "+ movie.get().getShowCycle()+" show");
		
		Booking booking = new Booking();
		booking.setUser(user.get());
		booking.setMovie(movie.get());
		booking.setShowSlot(bookingDto.getShowSlot());
		booking.setBookingFor(LocalDate.parse(bookingDto.getBookingFor(), DateTimeFormatter.ISO_DATE));
		booking.setCancel(bookingDto.isCancel());
		
		Booking ticket = bookingService.bookShow(booking); 
		if(ticket == null)
			throw new IllegalArgumentException("please provide valid details");
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable("userId") Long id){
		
		return new ResponseEntity<>(bookingService.getBookingsByUserId(id),HttpStatus.OK);
	}
	
	@PutMapping("/cancel-ticket/{id}")
	public ResponseEntity<Map<String,String>> ticketCancellation(@PathVariable("id") Integer bookingId){
		Map<String,String> message = new HashMap<>();
		Integer result = bookingService.cancelBooking(bookingId);
		if(result  == 1) {
			message.put("messgae","Successfully ticket cancelled");
			return new ResponseEntity<>(message,HttpStatus.OK);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Booking is Not Found");
	}
}
