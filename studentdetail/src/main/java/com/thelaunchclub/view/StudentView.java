package com.thelaunchclub.view;

import com.thelaunchclub.CommonInput;
import com.thelaunchclub.Validation;
import com.thelaunchclub.studentvalidation.StudentValidation;
import com.thelaunchclub.validateexception.InvalidDateException;

import java.sql.Date;

/**
 * StudentView program implements an application that simply displays "User
 * input".
 */
public class StudentView {

	private static final StudentValidation studentValidation = new StudentValidation();
	private static final Validation validation = new Validation();
	private static final StudentView STUDENT_VIEW = new StudentView();
	private static final CommonInput input = new CommonInput();

	public static int validateChoice() {
		System.out.println("Enter choice:");
		final int userChoice = input.getInt("Enter choice");

		if (!studentValidation.validateChoice(Integer.toString(userChoice))){
			System.out.println("Enter Valid Choice (1-5)");
			return StudentView.validateChoice();
		} else {
			return Integer.parseInt(Integer.toString(userChoice));
		}
	}

	/**
	 * Gets roll number from the student and it validates the input.
	 */
	public int getRollNo() {
		final int rollNo = input.getInt("Enter Roll number");
	
		if (!studentValidation.validateRollNumber(Integer.toString(rollNo))) {
			System.out.println("Enter Valid RollNo (Use Only Three Digits e.g: 123)");
			return STUDENT_VIEW.getRollNo();
		} else {
			return Integer.parseInt(Integer.toString(rollNo));
		}
	}

	/**
	 * Gets a name from the student and it validates the input.
	 */
	public String getName() {
		final String name = input.getString("Enter name");
		
		if (!validation.validateName(name)) {
			System.out.println("Enter valid name");
			return STUDENT_VIEW.getName();
		}
		return name;
	}

	/**
	 * Get the phone number from the student and validates the input.
	 */
	public long getPhoneNumber() {
		final Long phoneNumber = input.getLong("Enter Phone Number");
		
		if (!validation.validatePhoneNumber(Long.toString(phoneNumber))) {
			System.out.println("Enter valid Phone number");
			return STUDENT_VIEW.getPhoneNumber();
		} else {
			return Long.parseLong(Long.toString(phoneNumber));
		}
	}

	/**
	 * Get a branch and validate it according to user input.
	 */
	public String getBranchName() {
		final String branchName = input.getString("Enter Branch:(IT, CSE, ECE, MECH, CIVIL)");
		
		if (!studentValidation.validateBranchName(branchName)) {
			System.out.println("Enter valid Branch Name");
			return STUDENT_VIEW.getBranchName();
		}
		return branchName;
	}

	/**
	 * Get date of birth from the student and validate it based on input.
	 */
	public Date getAdmissionDate() {
		final String date = input.getString("Enter Admission Date (year-month-day) [e.g: 2000-02-27]");

		try {

			if (validation.validateDate(date)) {
				return Date.valueOf(date.toString());
			} else {
				System.out.println("Enter valid date");
				return STUDENT_VIEW.getAdmissionDate();
			}
		} catch (InvalidDateException e) {
			System.out.println("Check your date it should be ");
			return STUDENT_VIEW.getAdmissionDate();
		}
	}
}
