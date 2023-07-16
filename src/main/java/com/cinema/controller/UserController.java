package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cinema.dto.UserDto.UserLoginDto;
import com.cinema.model.User;
import com.cinema.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody UserLoginDto userLoginDto) {
		if((userLoginDto == null)||
				(userLoginDto.getUserName() == null || 
				userLoginDto.getPassword() == null))
			throw new IllegalArgumentException("UserName and password must not be null");
		User user = userService.loginUser(userLoginDto.getUserName(),userLoginDto.getPassword());
		if(user==null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"UserName or Password is invalid");
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}
