package com.thelaunchclub;

import org.osgi.service.component.annotations.Reference;

import java.sql.Date;

/**
 * StudentView program implements an application that simply displays "User
 * input".
 */
public class StudentView {
	@Reference
	private static StudentValidation validation;

	private static final StudentView STUDENT_VIEW = new StudentView();

	public static int validateChoice() {
		System.out.println("Enter choice:");
		final String userChoice = StudentMain.SCANNER.next().trim();

		if (!validation.validateChoice(userChoice)) {
			System.out.println("Enter Valid Choice (1-5)");
			return StudentView.validateChoice();
		} else {
			return Integer.parseInt(userChoice);
		}
	}

	/**
	 * Gets roll number from the student and it validates the input.
	 */
	public int getRollNo() {
		System.out.println("Enter RollNo:");
		final String rollNo = StudentMain.SCANNER.next().trim();
	
		if (!validation.validateRollNumber(rollNo)) {
			System.out.println("Enter Valid RollNo (Use Only Three Digits e.g: 123)");
			return STUDENT_VIEW.getRollNo();
		} else {
			return Integer.parseInt(rollNo);
		}
	}

	/**
	 * Gets a name from the student and it validates the input.
	 */
	public String getName() {
		System.out.println("Enter Name:");
		final String name = StudentMain.SCANNER.next().trim();
		
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
		System.out.println("Enter Phone number:");
		final String phoneNumber = StudentMain.SCANNER.next().trim();
		
		if (!validation.validatePhoneNumber(phoneNumber)) {
			System.out.println("Enter valid Phone number");
			return STUDENT_VIEW.getPhoneNumber();
		} else {
			return Long.parseLong(phoneNumber);
		}
	}

	/**
	 * Get a branch and validate it according to user input.
	 */
	public String getBranchName() {
		System.out.println("Enter Branch:(IT, CSE, ECE, MECH, CIVIL)");
		String branchName = StudentMain.SCANNER.next().trim();
		
		if (!validation.validateBranchName(branchName)) {
			System.out.println("Enter valid Branch Name");
			return STUDENT_VIEW.getBranchName();
		}
		return branchName;
	}

	/**
	 * Get date of birth from the student and validate it based on input.
	 */
	public Date getAdmissionDate() {
		System.out.println("Enter Admission Date (year-month-day) [e.g: 2000-02-27]");
		String date = StudentMain.SCANNER.next().trim();

		try {

			if (validation.validateAdmissionDate(date)) {
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
