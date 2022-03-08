package com.thelaunchclub.dbexception;

import com.thelaunchclub.InvalidStudentDataException;

public class DatabaseException extends InvalidStudentDataException {

	public DatabaseException(String message) {
		super(message);
	}
}
