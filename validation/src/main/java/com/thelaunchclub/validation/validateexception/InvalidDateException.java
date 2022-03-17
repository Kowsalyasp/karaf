package com.thelaunchclub.validation.validateexception;


import com.thelaunchclub.exception.InvalidStudentDataException;

public class InvalidDateException extends InvalidStudentDataException {

	public InvalidDateException(String message) {
		super(message);
	}
}
