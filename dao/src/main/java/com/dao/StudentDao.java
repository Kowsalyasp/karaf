package com.dao;

import com.model.Student;

import java.util.Map;


/**
 * Provides access to student data from database.
 * @author KowsalyaSP
 *
 */
public interface StudentDao {
	
	 boolean insertStudent(Student student);
	
	 Student selectStudent(int rollNo);
	
	 boolean deleteStudent(int rollNo);
	
	 boolean updateStudent(Student student);
	
	 Map<Integer, Student> selectAllStudents();
}
