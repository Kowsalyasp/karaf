package com.controller;

import com.model.Student;
import com.service.StudentService;
import com.service.StudentServiceImplV2;
import com.service.StudentValidation;

import java.util.List;

/**
 * Controls the whole application and managed the student services.
 *
 * @author KowsalyaSP
 */
public class StudentManagement {
	
	private static final StudentService STUDENT_INFORMATION = new StudentServiceImplV2();
	//private static final StudentView VIEW = new StudentView();
	
	/**
	 * Adds the student details.
	 * 
	 * @param student
	 */
	public static boolean addStudent(final Student student) {
		return STUDENT_INFORMATION.addStudent(student);
	}
	
	/**
	 * Search the student.
	 *
	 * @param rollNo
	 */
	public static Student searchStudent(final int rollNo) {
		return STUDENT_INFORMATION.searchStudent(rollNo);
	}

	/**
	 * Remove the student.
	 * 
	 * @param rollNo
	 */
	public static boolean removeStudent(final int rollNo){
		return STUDENT_INFORMATION.removeStudent(rollNo);
	}

	/**
	 * Update the student.
	 * 
	 * @param student
	 */
	public static boolean updateStudent(final Student student){
		return STUDENT_INFORMATION.updateStudent(student);		
	}
	
	/**
	 * View all student.
	 */
	public static List<Student> viewAllStudents() {
		return STUDENT_INFORMATION.viewAllStudents();
	}

	/**
	 * gets roll number
	 */
	//public static int getRollNo() {
	//	return VIEW.getRollNo();
	//}
	
	/**
	 * gets roll number
	 * 
	 * @param rollNo
	 */
	public static boolean getRollNumber(final String rollNo) {
		return StudentValidation.validateRollNumber(rollNo);
	}

	/**
	 * get name
	 * 
	 * @param name
	 */
	public static boolean getName(final String name) {
		return StudentValidation.validateName(name);	
	}
	
	/**
	 * get phone Number 
	 * 
	 * @param phoneNo
	 */
	public static boolean getPhoneNumber(final String phoneNo) {
		return StudentValidation.validatePhoneNumber(phoneNo);
	}
	
	/**
	 * get branch Name 
	 * 
	 * @param branchName
	 */
	public static boolean getBranch(final String branchName) {
	    return StudentValidation.validateBranchName(branchName);
	}

	/**
	 * get admission date 
	 * 
	 * @param date
	 */
	public static boolean getAdmissionDate(final String date) {
	    return StudentValidation.validateAdmissionDate(date);
    }
	
	/**
	 * get user choice from student 
	 * 
	 * @param choice
	 */
	public static boolean getUserChoice(final String choice) {
		return StudentValidation.validateChoice(choice);
	}
	
	/**
	 * checks roll number for specified student 
	 * 
	 * @param rollNo
	 */
	public static boolean checkRollNo(final int rollNo) {
		return STUDENT_INFORMATION.checkRollNo(rollNo);		
	}
}
