package com.task.employee.customExceptions;

public class EmptyInputException extends RuntimeException {
	public EmptyInputException(String str) {
		super(str);
	}
}
