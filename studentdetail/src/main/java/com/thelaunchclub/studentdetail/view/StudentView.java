package com.thelaunchclub.studentdetail.view;

import com.thelaunchclub.studentdetail.studentvalidation.StudentValidation;
import com.thelaunchclub.userinput.CommonInput;
import com.thelaunchclub.validation.Validation;
import com.thelaunchclub.validation.validateexception.InvalidDateException;
import org.apache.log4j.Logger;

import java.sql.Date;

/**
 * StudentView program implements an application that simply displays "User
 * input".
 */
public class StudentView {

	private static final StudentValidation STUDENT_VALIDATION = new StudentValidation();
	private static final Validation VALIDATION = new Validation();
	private static final StudentView STUDENT_VIEW = new StudentView();
	private static final CommonInput COMMON_INPUT = new CommonInput();
	private static final Logger LOGGER= Logger.getLogger(StudentView.class);

	public static int validateChoice() {
		final int userChoice = COMMON_INPUT.getInt("Enter choice");

		if (!STUDENT_VALIDATION.validateChoice(Integer.toString(userChoice))){
			LOGGER.error("Enter Valid Choice (1-5)");
			return StudentView.validateChoice();
		} else {
			return Integer.parseInt(Integer.toString(userChoice));
		}
	}

	/**
	 * Gets roll number from the student and it validates the input.
	 */
	public int getRollNo() {
		final int rollNo = COMMON_INPUT.getInt("Enter Roll number");
	
		if (!STUDENT_VALIDATION.validateRollNumber(Integer.toString(rollNo))) {
			LOGGER.error("Enter Valid RollNo (Use Only Three Digits e.g: 123)");
			return STUDENT_VIEW.getRollNo();
		} else {
			return Integer.parseInt(Integer.toString(rollNo));
		}
	}

	/**
	 * Gets a name from the student and it validates the input.
	 */
	public String getName() {
		final String name = COMMON_INPUT.getString("Enter name");
		
		if (!VALIDATION.validateName(name)) {
			LOGGER.error("Enter valid name");
			return STUDENT_VIEW.getName();
		}
		return name;
	}

	/**
	 * Get the phone number from the student and validates the input.
	 */
	public long getPhoneNumber() {
		final Long phoneNumber = COMMON_INPUT.getLong("Enter Phone Number");
		
		if (!VALIDATION.validatePhoneNumber(Long.toString(phoneNumber))) {
			LOGGER.error("Enter valid Phone number");
			return STUDENT_VIEW.getPhoneNumber();
		} else {
			return Long.parseLong(Long.toString(phoneNumber));
		}
	}

	/**
	 * Get a branch and validate it according to user input.
	 */
	public String getBranchName() {
		final String branchName = COMMON_INPUT.getString("Enter Branch:(IT, CSE, ECE, MECH, CIVIL)");
		
		if (!STUDENT_VALIDATION.validateBranchName(branchName)) {
			LOGGER.error("Enter valid Branch Name");
			return STUDENT_VIEW.getBranchName();
		}
		return branchName;
	}

	/**
	 * Get date of birth from the student and validate it based on input.
	 */
	public Date getAdmissionDate() {
		final String date = COMMON_INPUT.getString("Enter Admission Date (year-month-day) [e.g: 2000-02-27]");

		try {

			if (VALIDATION.validateDate(date)) {
				return Date.valueOf(date.toString());
			} else {
				LOGGER.error("Enter valid date");
				return STUDENT_VIEW.getAdmissionDate();
			}
		} catch (InvalidDateException e) {
			LOGGER.error("Check your date it should be ");
			return STUDENT_VIEW.getAdmissionDate();
		}
	}
}
