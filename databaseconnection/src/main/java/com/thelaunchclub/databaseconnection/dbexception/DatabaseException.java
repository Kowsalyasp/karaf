package com.thelaunchclub.databaseconnection.dbexception;

import com.thelaunchclub.exception.InvalidStudentDataException;

public class DatabaseException extends InvalidStudentDataException {

	public DatabaseException(String message) {
		super(message);
	}
}
