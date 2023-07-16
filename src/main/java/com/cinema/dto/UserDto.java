package com.cinema.dto;

import lombok.Data;

public interface UserDto {
	
	@Data
	public static class UserLoginDto{
		private String userName;
		private String password;
	}
	
}
