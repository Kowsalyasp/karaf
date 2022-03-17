package com.thelaunchclub.studentdetail.exception;


import com.thelaunchclub.exception.InvalidStudentDataException;

public class InvalidRollNumberException extends InvalidStudentDataException {
	
	public InvalidRollNumberException(String message) {
		super(message);
	}
}
