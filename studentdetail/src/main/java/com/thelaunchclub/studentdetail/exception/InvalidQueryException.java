package com.thelaunchclub.studentdetail.exception;

import com.thelaunchclub.exception.InvalidStudentDataException;

public class InvalidQueryException extends InvalidStudentDataException {
	
	public InvalidQueryException(String message) {
		super(message);
	}
}