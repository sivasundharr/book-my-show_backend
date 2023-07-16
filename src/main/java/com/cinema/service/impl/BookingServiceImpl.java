package com.cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cinema.model.Booking;
import com.cinema.repository.BookingRepository;
import com.cinema.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Booking bookShow(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {	
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getBookingsByUserId(Long userId) {
		
		return bookingRepository.findByUser(userId,Sort.by("bookingTiming").descending());
	}

	@Override
	public Integer cancelBooking(Integer id) {
		return bookingRepository.findByIdAndUpdate(id);
	}

}
