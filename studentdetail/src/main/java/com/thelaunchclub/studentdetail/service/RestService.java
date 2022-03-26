package com.thelaunchclub.studentdetail.service;

import com.thelaunchclub.studentdetail.model.Student;

import java.util.List;
import java.util.Map;

/**
 * Interface which provides all services.
 */
public interface RestService {
	
	Map addStudent(final Student student);

	List searchStudent(final Integer rollNo);

    Map removeStudent(final Integer rollNo);

	Map updateStudent(final Student student);

	List<Student> viewAllStudents();

	boolean checkRollNo(final int rollNo);

	List<Student> showPaginationDetails(final int page, final int limit);
}
