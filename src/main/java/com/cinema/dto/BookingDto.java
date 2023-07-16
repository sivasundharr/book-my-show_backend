package com.cinema.dto;

import lombok.Data;

public interface BookingDto {
	
	@Data
	public static class CreateBookingDto{
		private long user;
		private long movie;
		private boolean cancel;
		private int showSlot;
		private String bookingFor;
	}
}
