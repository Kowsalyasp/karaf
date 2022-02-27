package com.service;

import com.atmo.exception.InvalidQueryException;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.model.Student;

import java.util.ArrayList;
import java.util.List;


/**
 * The StudentImplV2 retrieve and store the student details from database.
 */
public class StudentServiceImplV2 implements StudentService {

	private static final StudentDao STUDENT_DAO = new StudentDaoImpl();

	/**
	 * Add Student Details to the database.
	 * 
	 * @param student
	 */
	public boolean addStudent(final Student student) {
		return STUDENT_DAO.insertStudent(student);
	}

	/**
	 * Get Student Detail by using roll number.
	 * 
	 * @param rollNo
	 */
	public Student searchStudent(final int rollNo) {
		final Student student = STUDENT_DAO.selectStudent(rollNo);

		if (student != null) {
			return student;
		} else {
			throw new InvalidQueryException("Student Not Exist");
		}
	}

	/**
	 * Remove Student Data by using roll number.
	 * 
	 * @param rollNo
	 */
	public boolean removeStudent(final int rollNo) {

		if (STUDENT_DAO.deleteStudent(rollNo)) {
			return true;
		} else {
			throw new InvalidQueryException("Student Not Exist");
		}
	}

	/**
	 * Update each Student record from database for specified roll number.
	 * 
	 * @param student
	 */
	public boolean updateStudent(final Student student) {

		if (!STUDENT_DAO.updateStudent(student)) {
			return true;
		} else {
			throw new InvalidQueryException("Student Not Exist");
		}
	}

	/**
	 * View All Student Details from database.
	 */
	public List<Student> viewAllStudents() {
		return new ArrayList<Student>(STUDENT_DAO.selectAllStudents().values());
	}
    
	/**
	 * Check roll number.
	 * 
	 * @param  rollNo
	 */
	public boolean checkRollNo(final int rollNo) {
		return STUDENT_DAO.selectAllStudents().containsKey(rollNo);
	}
}
