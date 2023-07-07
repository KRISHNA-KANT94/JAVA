package com.app.exception_handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		
		Map<String,String> maps= new HashMap<>();
		
		for(FieldError f: e.getFieldErrors()) {
		maps.put(f.getField(), f.getDefaultMessage());
	}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(maps);

}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse(e.getMessage()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIResponse(e.getMessage()));
	}
}
