package com.thelaunchclub.studentdetail.view;

import com.thelaunchclub.studentdetail.Activator;
import com.thelaunchclub.studentdetail.model.Student;
import com.thelaunchclub.userinput.CommonInput;
import com.thelaunchclub.studentdetail.controller.StudentManagement;
import com.thelaunchclub.studentdetail.exception.InvalidQueryException;
import com.thelaunchclub.studentdetail.exception.InvalidRollNumberException;

import org.apache.log4j.Logger;

import java.sql.Date;
import java.util.List;

/**
 * Performs operation such as adding, removing, searching and updating the student details.
 */
public class StudentDetails {

    private static final StudentView VIEW = new StudentView();
    private static final StudentManagement STUDENT_MANAGEMENT = new StudentManagement();
    private static final Logger LOGGER= Logger.getLogger(StudentDetails.class);

    /**
     * Adds the student details.
     */
    public static void addStudent() {
        final int rollNo = VIEW.getRollNo();

        if (STUDENT_MANAGEMENT.checkRollNo(rollNo)) {
            LOGGER.info("Roll Number Already Exist \n  Please enter another roll number");
            StudentDetails.addStudent();
            Activator.studentMain();
        }
        final String name = VIEW.getName();
        final long phoneNumber = VIEW.getPhoneNumber();
        final String branch = VIEW.getBranchName();
        final Date admissionDate = VIEW.getAdmissionDate();
        final Student student = new Student(rollNo, name, phoneNumber, branch, admissionDate);

        try {

            //if (STUDENT_MANAGEMENT.addStudent(student)) {
                LOGGER.info("Successfully Added The Student Data");

        } catch (InvalidQueryException exception) {
            LOGGER.error(exception);
        } catch (InvalidRollNumberException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * Search the student detail based on roll number.
     */
    public static void searchStudent() {
        final int rollNo = VIEW.getRollNo();

        try {
            List student = STUDENT_MANAGEMENT.searchStudent(rollNo);

            LOGGER.info(student);
        } catch (InvalidQueryException exception) {
            LOGGER.error(exception);
        } catch (InvalidRollNumberException exception) {
            LOGGER.error(exception.getMessage());
        }
    }

    /**
     * Remove the student detail for the specified roll number.
     */
    public static void removeStudent() {
        final int rollNo = VIEW.getRollNo();

        try {

           // if (STUDENT_MANAGEMENT.removeStudent(rollNo)) {
                LOGGER.info("Successfully Removed");
           // }
        } catch (InvalidQueryException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * Updates the student detail.
     */

    public static void updateStudent() {
        final Student student = new Student();
        final int rollNo = VIEW.getRollNo();

        if (!STUDENT_MANAGEMENT.checkRollNo(rollNo)) {
            LOGGER.info("Roll Number Not Exist \n  Please enter another roll number");
            StudentDetails.updateStudent();
            Activator.studentMain();
        }
        student.setRollno(rollNo);
        String updateInput = null;

        LOGGER.info("If You Want To Change Your Name Enter yes a no");
        StudentDetails.getName(updateInput, student);
        LOGGER.info("If You Want To Change Your phone number Enter yes or no");
        StudentDetails.getPhoneNo(updateInput, student);
        LOGGER.info("If You Want To Change Your Branch Name Enter yes or no");
        StudentDetails.getBranch(updateInput, student);
        LOGGER.info("If You Want To Change Your date Enter yes or no");
        StudentDetails.getDate(updateInput, student);

        try {
            STUDENT_MANAGEMENT.updateStudent(student);
            LOGGER.info("Successfully updated the student data");
        } catch (InvalidQueryException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * Update student data for the specified name.
     *
     * @param student
     */
    public static void getName(String updateInput, final Student student) {

        while (true) {
            updateInput = CommonInput.SCANNER.next().trim();

            if (updateInput.equalsIgnoreCase("yes")) {
                student.setName(VIEW.getName());
                break;
            } else if (updateInput.equalsIgnoreCase("no")) {
                break;
            } else {
                LOGGER.info("Enter valid input (Only Use yes or no)");
                continue;
            }
        }
    }

    /**
     * Update student data for the branch name.
     *
     * @param student
     */
    public static void getBranch(String updateInput, final Student student) {

        while (true) {
            updateInput = CommonInput.SCANNER.next().trim();

            if (updateInput.equalsIgnoreCase("yes")) {
                student.setBranch(VIEW.getBranchName());
                break;
            } else if (updateInput.equalsIgnoreCase("no")) {
                break;
            } else {
                LOGGER.info("Enter valid input (Only Use yes or no)");
                continue;
            }
        }
    }

    /**
     * Update student data for the phoneno.
     *
     * @param student
     */
    public static void getPhoneNo(String updateInput, final Student student) {

        while (true) {
            updateInput = CommonInput.SCANNER.next().trim();

            if (updateInput.equalsIgnoreCase("yes")) {
                student.setPhoneNumber(VIEW.getPhoneNumber());
                break;
            } else if (updateInput.equalsIgnoreCase("no")) {
                break;
            } else {
                LOGGER.info("Enter valid input (Only Use yes or no)");
                continue;
            }
        }
    }

    /**
     * Update student data for the date.
     *
     * @param student
     */
    public static void getDate(String updateInput, final Student student) {

        while (true) {
            updateInput = CommonInput.SCANNER.next().trim();

            if (updateInput.equalsIgnoreCase("yes")) {
                student.setAdmissionDate(VIEW.getAdmissionDate());
                break;
            } else if (updateInput.equalsIgnoreCase("no")) {
                break;
            } else {
                LOGGER.info("Enter valid input (Only Use yes or no)");
                continue;
            }
        }
    }

    /**
     * It displays all students from the database.
     */
    public static void showAllStudents() {
        List<Student> showStudent = STUDENT_MANAGEMENT.viewAllStudents();

        System.out.println(showStudent);
    }
}
