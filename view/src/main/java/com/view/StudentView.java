package com.view;

import com.atmo.exception.InvalidDateException;
import com.controller.StudentManagement;
import com.model.Student;

import java.sql.Date;
import java.util.Map;

/**
 * StudentView program implements an application that simply displays "User
 * input".
 */
public class StudentView {

	private static final StudentView STUDENT_VIEW = new StudentView();

	public static int validateChoice() {
		System.out.println("Enter choice:");

		final String userChoice = StudentMain.SCANNER.nextLine().trim();

		if (!StudentManagement.getUserChoice(userChoice)) {
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
		StudentDetails.LOGGER.info("Enter RollNo:");
		final String rollNo = StudentMain.SCANNER.nextLine().trim();
	
		if (!StudentManagement.getRollNumber(rollNo)) {
			StudentDetails.LOGGER.info("Enter Valid RollNo (Use Only Three Digits e.g: 123)");
			return STUDENT_VIEW.getRollNo();
		} else {
			return Integer.parseInt(rollNo);
		}
	}

	/**
	 * Gets a name from the student and it validates the input.
	 */
	public String getName() {
		StudentDetails.LOGGER.info("Enter Name:");
		final String name = StudentMain.SCANNER.nextLine().trim();
		
		if (!StudentManagement.getName(name)) {
			StudentDetails.LOGGER.info("Enter valid name");
			return STUDENT_VIEW.getName();
		}
		return name;
	}

	/**
	 * Get the phone number from the student and validates the input.
	 */
	public long getPhoneNumber() {
		StudentDetails.LOGGER.info("Enter Phone number:");
		final String phoneNumber = StudentMain.SCANNER.nextLine().trim();
		
		if (!StudentManagement.getPhoneNumber(phoneNumber)) {
			StudentDetails.LOGGER.info("Enter valid Phone number");
			return STUDENT_VIEW.getPhoneNumber();
		} else {
			return Long.parseLong(phoneNumber);
		}
	}

	/**
	 * Get a branch and validate it according to user input.
	 */
	public String getBranchName() {
		StudentDetails.LOGGER.info("Enter Branch:(IT, CSE, ECE, MECH, CIVIL)");
		String branchName = StudentMain.SCANNER.nextLine().trim();
		
		if (!StudentManagement.getBranch(branchName)) {
			StudentDetails.LOGGER.info("Enter valid Branch Name");
			return STUDENT_VIEW.getBranchName();
		}
		return branchName;
	}

	/**
	 * Get date of birth from the student and validate it based on input.
	 */
	public Date getAdmissionDate() {
		StudentDetails.LOGGER.info("Enter Admission Date (year-month-day) [e.g: 2000-02-27]");
		String date = StudentMain.SCANNER.nextLine().trim();

		try {

			if (StudentManagement.getAdmissionDate(date)) {
				return Date.valueOf(date.toString());
			} else {
				StudentDetails.LOGGER.info("Enter valid date");
				return STUDENT_VIEW.getAdmissionDate();
			}
		} catch (InvalidDateException e) {
			StudentDetails.LOGGER.error("Check your date it should be ");
			return STUDENT_VIEW.getAdmissionDate();
		}
	}

	/**
	 * Iterate one by one to show all Students details from the list.
	 */
	public void showAllStudents(Map<Integer, Student> map) {

		for (Map.Entry<Integer, Student> entry : map.entrySet()) {
			Student value = entry.getValue();

			StudentDetails.LOGGER.info(value);
		}
	}

	/**
	 * Show the student detail from the list based on unique roll number.
	 */
	public void showStudent(Student show) {
		System.out.println(show);
	}
}
