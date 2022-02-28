package com.view;

import java.sql.Date;
import java.util.List;

import com.atmo.exception.InvalidQueryException;
import com.controller.StudentManagement;
import com.model.Student;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * Performs operation such as adding, removing, searching and updating the student details.
 */
public class StudentDetails {

	public static final Logger LOGGER = LogManager.getLogger(StudentDetails.class);
	private static final StudentView VIEW = new StudentView();

	/**
	 * Adds the student details.
	 */
	public static void addStudent() {
		final int rollNo = VIEW.getRollNo();

		if (StudentManagement.checkRollNo(rollNo)) {
			System.out.println("Roll Number Already Exist \n  Please enter another roll number");
			StudentDetails.addStudent();
			StudentMain.studentMain();
		}
		final String name = VIEW.getName();
		final long phoneNumber = VIEW.getPhoneNumber();
		final String branch = VIEW.getBranchName();
		final Date admissionDate = VIEW.getAdmissionDate();
		final Student student = new Student(rollNo, name, phoneNumber, branch, admissionDate);

		try {

			if (StudentManagement.addStudent(student)) {
				System.out.println("Successfully Added The Student Data");
			}
		} catch (InvalidQueryException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Search the student detail based on roll number.
	 */
	public static void searchStudent() {
		final int rollNo = VIEW.getRollNo();

		try {
			Student student = StudentManagement.searchStudent(rollNo);

			System.out.println(student);
		} catch (InvalidQueryException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Remove the student detail for the specified roll number.
	 */
	public static void removeStudent() {
		final int rollNo = VIEW.getRollNo();

		try {
	
			if (StudentManagement.removeStudent(rollNo)) {
				System.out.println("Successfully Removed");
			}
		} catch (InvalidQueryException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Updates the student detail.
	 */

	public static void updateStudent() {
		final Student student = new Student();
		final int rollNo = VIEW.getRollNo();

		if (!StudentManagement.checkRollNo(rollNo)) {
			System.out.println("Roll Number Not Exist \n  Please enter another roll number");
			StudentDetails.updateStudent();
			StudentMain.studentMain();
		}
		student.setRollno(rollNo);
		String updateInput = null;

		System.out.println("If You Want To Change Your Name Enter yes a no");
		StudentDetails.getName(updateInput, student);
		System.out.println("If You Want To Change Your phone number Enter yes or no");
		StudentDetails.getPhoneNo(updateInput, student);
		System.out.println("If You Want To Change Your Branch Name Enter yes or no");
		StudentDetails.getBranch(updateInput, student);
		System.out.println("If You Want To Change Your date Enter yes or no");
		StudentDetails.getDate(updateInput, student);

		try {
			StudentManagement.updateStudent(student);
			System.out.println("Successfully updated the student data");
		} catch (InvalidQueryException exception) {
			System.out.println(exception);
		}
	}

	public static void getName(String updateInput, Student student) {

		while (true) {
			updateInput = StudentMain.SCANNER.next().trim();

			if (updateInput.equalsIgnoreCase("yes")) {
				student.setName(VIEW.getName());
				break;
			} else if (updateInput.equalsIgnoreCase("no")) {
				break;
			} else {
				System.out.println("Enter valid input (Only Use yes or no)");
				continue;
			}
		}
	}
		
	public static void getBranch(String updateInput, Student student) {

		while (true) {
			updateInput = StudentMain.SCANNER.next().trim();

			if (updateInput.equalsIgnoreCase("yes")) {
				student.setBranch(VIEW.getBranchName());
				break;
			} else if (updateInput.equalsIgnoreCase("no")) {
				break;
			} else {
				System.out.println("Enter valid input (Only Use yes or no)");
				continue;
			}
		}
	}

	public static void getPhoneNo(String updateInput, Student student) {

		while (true) {
			updateInput = StudentMain.SCANNER.next().trim();

			if (updateInput.equalsIgnoreCase("yes")) {
				student.setPhoneNumber(VIEW.getPhoneNumber());
				break;
			} else if (updateInput.equalsIgnoreCase("no")) {
				break;
			} else {
				System.out.println("Enter valid input (Only Use yes or no)");
				continue;
			}
		}
	}

	public static void getDate(String updateInput, Student student) {

		while (true) {
			updateInput = StudentMain.SCANNER.next().trim();

			if (updateInput.equalsIgnoreCase("yes")) {
				student.setAdmissionDate(VIEW.getAdmissionDate());
				break;
			} else if (updateInput.equalsIgnoreCase("no")) {
				break;
			} else {
				System.out.println("Enter valid input (Only Use yes or no)");
				continue;
			}
		}
	}

	/**
	 * It displays all students from the table.
	 */
	public static void showAllStudents() {
		List<Student> showStudent = StudentManagement.viewAllStudents();

		System.out.println(showStudent);
	}
}
