package com.cinema.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	@Column(columnDefinition="boolean default false")
	private boolean cancel;
	
	private Integer showSlot;
	
	private LocalDate bookingFor;
	
	@UpdateTimestamp
	private LocalDateTime bookingTiming;
}
