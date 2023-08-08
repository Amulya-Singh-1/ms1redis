package com.task.employee.customExceptions;

public class NoEmployeeFoundException extends RuntimeException {
	public NoEmployeeFoundException(String str) {
		super(str);
	}
}
