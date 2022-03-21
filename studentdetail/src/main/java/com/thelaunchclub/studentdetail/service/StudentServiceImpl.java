package com.thelaunchclub.studentdetail.service;

import com.thelaunchclub.studentdetail.model.Student;
import com.thelaunchclub.exception.InvalidStudentDataException;
import com.thelaunchclub.studentdetail.dao.StudentDao;
import com.thelaunchclub.studentdetail.dao.StudentDaoImpl;
import com.thelaunchclub.studentdetail.exception.InvalidRollNumberException;

import java.util.ArrayList;
import java.util.List;

/**
 * The StudentImplV2 retrieve and store the student details from database.
 */
public class StudentServiceImpl implements StudentService {

    private static final StudentDao STUDENT_DAO = new StudentDaoImpl();
    private static final StudentServiceImpl STUDENT_SERVICE = new StudentServiceImpl();

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
            throw new InvalidRollNumberException("Student Not Exist");
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
            throw new InvalidRollNumberException("Student Not Exist");
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
            throw new InvalidStudentDataException("Student Not Exist");
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

