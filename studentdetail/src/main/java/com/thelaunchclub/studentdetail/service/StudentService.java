package com.thelaunchclub.studentdetail.service;

import com.thelaunchclub.studentdetail.model.Student;

import java.util.List;

public interface StudentService {
    boolean addStudent(Student student);

    Student searchStudent(int rollNo);

    boolean removeStudent(int rollNo);

    boolean updateStudent(Student student);

    List<Student> viewAllStudents();

    boolean checkRollNo(int rollNo);
}
