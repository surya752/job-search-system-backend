package com.cg.jss.advicer;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.jss.exception.EmployerNotFoundException;
import com.cg.jss.exception.JobNotFoundException;
import com.cg.jss.exception.JobSeekerNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handelBVadRequest(MethodArgumentNotValidException ex){
		Map<String, String> errors = new LinkedHashMap<>();
		ex.getFieldErrors().stream().forEach(fieldError -> {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		});
		
		return errors;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployerNotFoundException.class)
	public String handleEmployerNotFoundException(EmployerNotFoundException e) {
		return e.getMessage();
	}
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(JobNotFoundException.class)
	public String handleJobNotFoundException(JobNotFoundException e) {
		return e.getMessage();
	}
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(JobSeekerNotFoundException.class)
	public String handleJobSeekerNotFoundException(JobSeekerNotFoundException e) {
		return e.getMessage();
	}

}
