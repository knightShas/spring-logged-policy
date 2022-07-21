package com.knightdesk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApplicationGlobalException extends RuntimeException{

	
	private static final long serialVersionUID = -4181095054246108944L;
	
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<String> emptyList(EmptyListException ex){
		return new ResponseEntity<>("No entry of any policy",HttpStatus.NO_CONTENT);
	}

}
