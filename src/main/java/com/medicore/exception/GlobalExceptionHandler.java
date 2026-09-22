package com.medicore.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	 public String handleIllegalArgumentException(IllegalArgumentException ex)
	 {
		return ex.getMessage();
	 }
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNoSuchElementException(NoSuchElementException ex) {
	    return ex.getMessage();
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleMethodArgumentNotValidException(
	        MethodArgumentNotValidException ex) {

	    return ex.getBindingResult()
	            .getFieldError()
	            .getField() + ": " +
	            ex.getBindingResult()
	            .getFieldError()
	            .getDefaultMessage();
	}
}
