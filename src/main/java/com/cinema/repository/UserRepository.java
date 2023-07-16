package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserNameAndPassword(String userName,String password);
}
