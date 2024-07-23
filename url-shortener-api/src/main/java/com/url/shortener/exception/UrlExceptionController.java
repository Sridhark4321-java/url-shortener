package com.url.shortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UrlExceptionController {
	
	  @ExceptionHandler(value = UrlNotFoundException.class)
	   public ResponseEntity<Object> exception(UrlNotFoundException exception) {
	      return new ResponseEntity<>("URL not found", HttpStatus.NOT_FOUND);
	   }

}
