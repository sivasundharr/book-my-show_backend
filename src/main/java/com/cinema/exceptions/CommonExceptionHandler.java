package com.cinema.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class CommonExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails>  handleAllExceptions(Exception ex,WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails();
		
		HttpStatus statusEnum = HttpStatus.INTERNAL_SERVER_ERROR;
		
		errorDetails.setTitle("something went wrong");
		errorDetails.setTimeStamp(LocalDateTime.now());
		
		errorDetails.setDetail(ex.getMessage());
		errorDetails.setDeveloperMessage(ex.getClass().getName());
		
		if(ex instanceof ResponseStatusException) {
			ResponseStatusException ex1 = (ResponseStatusException)ex;
			statusEnum = ex1.getStatus();
			errorDetails.setTitle("Resource Not Available");
			errorDetails.setDetail(ex1.getReason());
		}
		
		if(ex instanceof IllegalArgumentException) {
			statusEnum = HttpStatus.BAD_REQUEST;
			errorDetails.setTitle("Argument values are not valid");
		}
		
		errorDetails.setStatus(statusEnum.value());

		return new ResponseEntity<>(errorDetails,statusEnum);
		
	}
	
}
