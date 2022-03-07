package com.thelaunchclub;

import org.osgi.service.component.annotations.Component;

import java.time.LocalDate;

/**
 * The StudentValidation implements an program to validate the user details.
 */
@Component
public class StudentValidation implements Validation{

	public  boolean validateChoice(String Choice) {
		return (Choice.matches("[1-6]{1}")) ? true : false;
	}

	/**
	 * Validate the roll number based on given input.
	 */
	public  boolean validateRollNumber(final String rollNumber) {
		return (rollNumber.matches("[0-9]{3}")) ? true : false; 
			
	}

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
	 * Validate the Branch Name based on input.
	 */
	public  boolean validateBranchName(final String branchName) {
		return (("IT".equalsIgnoreCase(branchName) || "CSE".equalsIgnoreCase(branchName) || "MECH".equalsIgnoreCase(branchName)|| "CIVIL".equalsIgnoreCase(branchName) || "ECE".equalsIgnoreCase(branchName)))? true : false;
	}

	/**
	 * Get and validate the value of admission date by importing Date class.
	 */
	public  boolean validateAdmissionDate(String date) {

		try {
			LocalDate todayDate = LocalDate.now();
			LocalDate dateFormat = LocalDate.parse(date);
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