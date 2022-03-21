package com.thelaunchclub.studentdetail.service;

import com.thelaunchclub.studentdetail.model.Student;

import java.util.List;

/**
 * Interface which provides all services.
 */
public interface StudentService {
	
	boolean addStudent(Student student);

	Student searchStudent(int rollNo);

    boolean removeStudent(int rollNo);

	boolean updateStudent(Student student);

	List<Student> viewAllStudents();

	boolean checkRollNo(int rollNo);

}
