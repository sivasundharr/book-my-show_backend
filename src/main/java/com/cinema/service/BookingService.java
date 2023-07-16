package com.cinema.service;

import java.util.List;

import com.cinema.model.Booking;

public interface BookingService {
	
	List<Booking> getBookingsByUserId(Long userId);
	
	Booking bookShow(Booking booking);
	
	Booking updateBooking(Booking booking);
	
	Integer cancelBooking(Integer id);
	

}
