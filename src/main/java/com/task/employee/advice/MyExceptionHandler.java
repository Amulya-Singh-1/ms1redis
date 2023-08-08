package com.task.employee.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.task.employee.customExceptions.BadInputException;
import com.task.employee.customExceptions.EmptyInputException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		log.error("no such element was found. {}", e.getMessage());
		return new ResponseEntity<String>("no such element found", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ClassNotFoundException.class)
	public ResponseEntity<String> handleClassNotFoundException(ClassNotFoundException e) {
		log.error("no such class found. {}", e.getMessage());
		return new ResponseEntity<String>("class not found", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleNoInput(EmptyInputException e) {
		log.error("the input body is empty. {}", e.getMessage());
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BadInputException.class)
	public ResponseEntity<String> handleBadInput(BadInputException e) {
		log.error("bad input format found. {}", e.getMessage());
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
