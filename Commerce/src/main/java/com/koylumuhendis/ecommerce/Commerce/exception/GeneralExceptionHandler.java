package com.koylumuhendis.ecommerce.Commerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> userNotFoundException(UserNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}
