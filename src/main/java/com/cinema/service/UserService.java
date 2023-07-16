package com.cinema.service;

import java.util.Optional;

import com.cinema.model.User;

public interface UserService {
	User loginUser(String userName,String password);
	
	Optional<User> findUserById(Long Id);
}
