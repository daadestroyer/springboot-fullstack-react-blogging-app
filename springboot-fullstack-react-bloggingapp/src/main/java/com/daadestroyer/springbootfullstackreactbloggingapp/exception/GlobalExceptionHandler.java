package com.daadestroyer.springbootfullstackreactbloggingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.daadestroyer.springbootfullstackreactbloggingapp.helper.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException) {
		String message = resourceNotFoundException.getMessage();
		APIResponse apiResponse = new APIResponse(message,"failed");
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}

}