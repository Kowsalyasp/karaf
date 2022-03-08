package com.thelaunchclub.exception;


import com.thelaunchclub.InvalidStudentDataException;

public class InvalidRollNumberException extends InvalidStudentDataException {
	
	public InvalidRollNumberException(String message) {
		super(message);
	}
}
