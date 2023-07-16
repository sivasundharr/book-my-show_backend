package com.cinema.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {
	
	private String title;
	
	private String detail;
	
	private int status;
	
	private String developerMessage;
	
	private LocalDateTime timeStamp;
	
}
