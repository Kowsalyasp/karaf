package com.thelaunchclub.studentdetail.controller;

import com.thelaunchclub.studentdetail.model.Student;
import com.thelaunchclub.studentdetail.service.StudentService;
import com.thelaunchclub.studentdetail.service.StudentServiceImp;

import java.util.List;
import java.util.Map;

/**
 * Controls the whole application and managed the student services.
 *
 * @author KowsalyaSP
 */
public class StudentManagement {

    private static final StudentService STUDENT_INFORMATION = new StudentServiceImp();

    /**
     * Adds the student details.
     *
     * @param student
     */
    public Map addStudent(final Student student) {
        return STUDENT_INFORMATION.addStudent(student);
    }

    /**
     * Search the student.
     *
     * @param rollNo
     */
    public List searchStudent(final int rollNo) {
        return STUDENT_INFORMATION.searchStudent(rollNo);
    }

    /**
     * Remove the student.
     *
     * @param rollNo
     */
    public Map removeStudent(final int rollNo) {
        return STUDENT_INFORMATION.removeStudent(rollNo);
    }

    /**
     * Update the student.
     *
     * @param student
     */
    public Map updateStudent(final Student student) {
        return STUDENT_INFORMATION.updateStudent(student);
    }

    /**
     * View all student.
     */
    public List<Student> viewAllStudents() {
        return STUDENT_INFORMATION.viewAllStudents();
    }

    /**
     * checks roll number for specified student
     *
     * @param rollNo
     */
    public boolean checkRollNo(final int rollNo) {
        return STUDENT_INFORMATION.checkRollNo(rollNo);
    }

    /**
     * pass into specified details
     *
     * @param page
     * @param limit
     */
    public List<Student> PaginationView(int page, int limit) {
        return STUDENT_INFORMATION.showPaginationDetails(page, limit);
    }
}
