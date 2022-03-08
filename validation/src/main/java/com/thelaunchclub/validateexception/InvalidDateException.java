package com.thelaunchclub.validateexception;


import com.thelaunchclub.InvalidStudentDataException;

public class InvalidDateException extends InvalidStudentDataException {

	public InvalidDateException(String message) {
		super(message);
	}
}
