package com.thelaunchclub.studentdetail.controller;

import com.thelaunchclub.studentdetail.model.Student;
import com.thelaunchclub.studentdetail.service.StudentService;
import com.thelaunchclub.studentdetail.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Controls the whole application and managed the student services.
 *
 * @author KowsalyaSP
 */
public class StudentManagement {
	
	private static final StudentService STUDENT_INFORMATION = new StudentServiceImpl();

	public String getString() {
		return "hi";
	}

	/**
	 * Adds the student details.
	 * 
	 * @param student
	 */
	public  boolean addStudent(final Student student) {
		return STUDENT_INFORMATION.addStudent(student);
	}
	
	/**
	 * Search the student.
	 *
	 * @param rollNo
	 */
	public  Student searchStudent(final int rollNo) {
		return STUDENT_INFORMATION.searchStudent(rollNo);
	}

	/**
	 * Remove the student.
	 * 
	 * @param rollNo
	 */
	public  boolean removeStudent(final int rollNo){
		return STUDENT_INFORMATION.removeStudent(rollNo);
	}

	/**
	 * Update the student.
	 * 
	 * @param student
	 */
	public  boolean updateStudent(final Student student){
		return STUDENT_INFORMATION.updateStudent(student);		
	}
	
	/**
	 * View all student.
	 */
	public  List<Student> viewAllStudents() {
		return STUDENT_INFORMATION.viewAllStudents();
	}

	/**
	 * checks roll number for specified student
	 *
	 * @param rollNo
	 */
	public  boolean checkRollNo(final int rollNo) {
		return STUDENT_INFORMATION.checkRollNo(rollNo);
	}

}
