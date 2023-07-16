package com.cinema.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cinema.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	@Query("Select b from Booking b where b.user.id = ?1")
	List<Booking> findByUser(Long userId,Sort sort);
	
	@Modifying
	@Query("UPDATE Booking b SET b.cancel = true WHERE b.id = ?1")
	int findByIdAndUpdate(Integer id);
}
