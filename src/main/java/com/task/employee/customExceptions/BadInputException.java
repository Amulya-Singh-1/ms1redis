package com.task.employee.customExceptions;

public class BadInputException extends RuntimeException {
	public BadInputException(String str) {
		super(str);
	}
}
