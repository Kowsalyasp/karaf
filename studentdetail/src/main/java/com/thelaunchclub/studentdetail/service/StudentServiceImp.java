package com.thelaunchclub.studentdetail.service;

import com.thelaunchclub.studentdetail.dao.StudentDao;
import com.thelaunchclub.studentdetail.dao.StudentDaoImpl;
import com.thelaunchclub.studentdetail.model.Student;

import java.util.*;

/**
 * The StudentImp retrieve and store the student details from database.
 */
public class StudentServiceImp implements StudentService {

    private static final StudentDao STUDENT_DAO = new StudentDaoImpl();
    private static final StudentServiceImp STUDENT_SERVICE = new StudentServiceImp();

    /**
     * Add Student Details to the database.
     *
     * @param student
     * @return
     */
    public Map addStudent(final Student student) {
        final Map studentData = new HashMap();
        boolean isInserted = false;

        if(!STUDENT_SERVICE.checkRollNo(student.getRollNo())){
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
    public List searchStudent(final int rollNo) {
        final List studentList=new ArrayList<>();
        final Student student = STUDENT_DAO.selectStudent(rollNo);

        if (student == null) {
            studentList.add("Student record Not Found");
             return studentList;
        } else {
            studentList.add(student);
            return studentList;
        }
    }

    /**
     * Remove Student Data by using roll number.
     *
     * @param rollNo
     */
    public Map removeStudent(final int rollNo) {

        final Map studentData=new HashMap();
        boolean isDeleted =  STUDENT_DAO.deleteStudent(rollNo);;

        studentData.put("Student record is removed", isDeleted);
        return studentData;
    }

    /**
     * Update each Student record from database for specified roll number.
     *
     * @param student
     */
    public Map updateStudent(final Student student) {
        final Map studentData=new HashMap();
        final boolean isUpdated = STUDENT_DAO.updateStudent(student);

        studentData.put("Student record is updated", isUpdated);
        return studentData;
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
     * @param rollNo
     */
    public boolean checkRollNo(final int rollNo) {
        return STUDENT_DAO.selectAllStudents().containsKey(rollNo);
    }

    /**
     * Pagination Format Details.
     *
     * @param page
     * @param limit
     */
    public List<Student> showPaginationDetails(final int page, final int limit) {
        List<Student> list = STUDENT_SERVICE.viewAllStudents();
        int size = list.size();
        int start = (page - 1) * limit;
        int end = page * limit;

        if (page > 0 && limit > 0) {
            if (start < size & end < size) {
                return list.subList(start, end);
            }
        } else if (start < size) {
            return list.subList(start, size);
        } else{
            final List emptyList = new ArrayList<>();

            emptyList.add("Not found");
            return emptyList;
        }
        return list;
    }
}

