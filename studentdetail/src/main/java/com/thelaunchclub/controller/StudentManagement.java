package com.thelaunchclub.controller;

import com.thelaunchclub.model.Student;
import com.thelaunchclub.service.StudentService;
import com.thelaunchclub.service.StudentServiceImplV2;

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
	 * checks roll number for specified student
	 *
	 * @param rollNo
	 */
	public static boolean checkRollNo(final int rollNo) {
		return STUDENT_INFORMATION.checkRollNo(rollNo);
	}
}
