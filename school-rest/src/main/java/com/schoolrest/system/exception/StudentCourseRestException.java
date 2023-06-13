package com.schoolrest.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentCourseRestException extends RuntimeException{
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception ex){
		
		ErrorResponse error = new ErrorResponse();	
				error.setStatus(HttpStatus.BAD_REQUEST.value());
				error.setMessage("Course has conflict with Students other Courses");
				error.setTimeStamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
