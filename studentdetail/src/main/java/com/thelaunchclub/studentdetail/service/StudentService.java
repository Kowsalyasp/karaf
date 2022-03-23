package com.thelaunchclub.studentdetail.service;

import com.thelaunchclub.studentdetail.model.Student;

import java.util.List;
import java.util.Map;

/**
 * Interface which provides all services.
 */
public interface StudentService {
	
	Map addStudent(Student student);

	List searchStudent(int rollNo);

    Map removeStudent(int rollNo);

	Map updateStudent(Student student);

	List<Student> viewAllStudents();

	boolean checkRollNo(int rollNo);

	List<Student> showPaginationDetails(int page, int limit);
}
