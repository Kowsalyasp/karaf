package com.thelaunchclub.studentdetail.dao;

import com.thelaunchclub.studentdetail.model.Student;

import java.util.Map;

/**
 * Provides access to student data from database.
 *
 * @author KowsalyaSP
 */
public interface StudentDao {
	
	 boolean insertStudent(Student student);
	
	 Student selectStudent(Integer rollNo);
	
	 boolean deleteStudent(Integer rollNo);
	
	 boolean updateStudent(Student student);
	
	 Map<Integer, Student> selectAllStudents();
}
