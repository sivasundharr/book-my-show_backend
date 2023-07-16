package com.cinema.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.model.User;
import com.cinema.repository.UserRepository;
import com.cinema.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User loginUser(String userName,String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}

	@Override
	public Optional<User> findUserById(Long Id) {
		
		return userRepository.findById(Id);
	}

}
