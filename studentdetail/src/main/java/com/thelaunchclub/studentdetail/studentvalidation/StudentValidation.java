package com.thelaunchclub.studentdetail.studentvalidation;

/**
 * The StudentValidation implements an program to validate the user details.
 */
public class StudentValidation {

	public static boolean validateChoice(final String Choice) {
		return (Choice.matches("[1-6]{1}")) ? true : false;
	}

	/**
	 * Validate the roll number based on given input.
	 */
	public  static boolean validateRollNumber(final String rollNumber) {
		return (rollNumber.matches("[0-9]{3}")) ? true : false;
	}

	/**
	 * Validate the Branch Name based on input.
	 */
	public  static boolean validateBranchName(final String branchName) {
		return (("IT".equalsIgnoreCase(branchName) || "CSE".equalsIgnoreCase(branchName) || "MECH".equalsIgnoreCase(branchName)|| "CIVIL".equalsIgnoreCase(branchName) || "ECE".equalsIgnoreCase(branchName)))? true : false;
	}
}