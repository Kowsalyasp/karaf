package com.thelaunchclub.studentdetail.service;

import com.thelaunchclub.studentdetail.dao.StudentDao;
import com.thelaunchclub.studentdetail.dao.StudentDaoImpl;
import com.thelaunchclub.studentdetail.model.Student;

import java.util.*;

/**
 * The StudentImp retrieve and store the student details from database.
 */
public class RestServiceImp implements RestService {

    private static final StudentDao STUDENT_DAO = new StudentDaoImpl();
    private static final RestServiceImp STUDENT_SERVICE = new RestServiceImp();

    /**
     * Add Student data through API
     *
     *
     * @param student
     * @return
     */
    public Map addStudent(final Student student) {
        final Map studentData = new HashMap();
        boolean isInserted = false;

        if(!STUDENT_SERVICE.checkRollNo(student.getRollNo())) {
            isInserted = STUDENT_DAO.insertStudent(student);

        }
        studentData.put("Student record Added", isInserted);
        return studentData;
    }

    /**
     * Get Student Detail by using roll number.
     *
     * @param rollNo
     * @return
     */
    public List searchStudent(final Integer rollNo) {
         final List studentList = new ArrayList<>();
         final Student selectStudent = STUDENT_DAO.selectStudent(rollNo);

        if (selectStudent == null) {
            studentList.add("Student record Not Found");
             return studentList;
        } else {
            studentList.add(selectStudent);
            return studentList;
        }
    }

    /**
     * Remove Student Data by using roll number.
     *
     * @param rollNo
     */
    public Map removeStudent(final Integer rollNo) {
        final Map studentData = new HashMap();
        boolean isDeleted =  STUDENT_DAO.deleteStudent(rollNo);;

        studentData.put("Student record is removed", isDeleted);
        return studentData;
    }

    /**
     * Update each Student record through API for specified roll number.
     *
     * @param student
     */
    public Map updateStudent(final Student student) {
        final Map studentData = new HashMap();
        boolean isUpdated = false;

        if(STUDENT_DAO.selectAllStudents().containsKey(student.getRollNo())) {
            isUpdated = STUDENT_DAO.updateStudent(student);
        }
        studentData.put("Student record Updated", isUpdated);
        return studentData;

    }

    /**
     * View All Student Details from database.
     */
    public List<Student> viewAllStudents() {
        return new ArrayList<Student>(STUDENT_DAO.selectAllStudents().values());
    }

    /**
     * Pagination Format Details.
     *
     * @param page
     * @param limit
     */
    public List<Student> showPaginationDetails(final int page, final int limit) {
        final List<Student> list = STUDENT_SERVICE.viewAllStudents();
        final int size = list.size();
        final int start = (page - 1) * limit;
        final int end = page * limit;

        if (page >= 0 && limit >= 0) {
            if (start < size & end < size) {
                return list.subList(start, end);
            }
        } else if (start < size) {
            return list.subList(start, size);
        }
        return list;
    }

    /**
     * Check roll number.
     *
     * @param rollNo
     */
    public boolean checkRollNo(final int rollNo) {
        return STUDENT_DAO.selectAllStudents().containsKey(rollNo);
    }
}