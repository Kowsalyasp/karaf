package com.thelaunchclub;

import com.thelaunchclub.validateexception.InvalidDateException;

import java.time.LocalDate;

/**
 * The StudentValidation implements an program to validate the user details.
 */
public class Validation {

	/**
	 * Validate the name based on given input.
	 */
	public  boolean validateName(final String name) {
		return (name.matches("^[A-Za-z\\s]*$")) ? true : false;
	}

	/**
	 * Validate the phone Number based on input.
	 */
	public  boolean validatePhoneNumber(final String phoneNumber) {
		return (phoneNumber.matches("[6789]{1}[0-9]{9}")) ? true : false;
	}

	/**
	 * Get and validate the value of admission date by importing Date class.
	 */
	public  boolean validateDate(final String date) {

		try {
			final LocalDate todayDate = LocalDate.now();
			final LocalDate dateFormat = LocalDate.parse(date);
			java.util.Date inputDate = java.sql.Date.valueOf(dateFormat);
			java.util.Date currentDate = java.sql.Date.valueOf(todayDate);

			if (inputDate.compareTo(currentDate) > 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			throw new InvalidDateException("Invalid Date");
		}
	}
}