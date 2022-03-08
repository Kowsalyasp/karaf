package com.thelaunchclub.exception;

import com.thelaunchclub.InvalidStudentDataException;

public class InvalidQueryException extends InvalidStudentDataException {
	
	public InvalidQueryException(String message) {
		super(message);
	}
}