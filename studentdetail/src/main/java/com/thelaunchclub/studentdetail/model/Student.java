package com.thelaunchclub.studentdetail.model;

import jakarta.validation.constraints.*;

import java.sql.Date;

/**
 * Represents an student and specified fields and methods to get and set the
 * student details.
 */
public class Student {

    @NotNull(message = "Roll number should not be null value",groups = {AddStudent.class, UpdateStudent.class, SearchStudent.class, DeleteStudent.class})
    private Integer rollNo;

    @NotEmpty(message = "Name should not be null value", groups = {AddStudent.class, UpdateStudent.class})
    @Size(min = 2, max = 15, groups = {AddStudent.class, UpdateStudent.class})
    @Pattern(regexp = "^[A-Za-z\\s]*$", groups = {AddStudent.class, UpdateStudent.class})
    private String name;

    @NotNull(message = "PhoneNumber should not be null value", groups = {AddStudent.class, UpdateStudent.class})
    private Long phoneNumber;

    @NotEmpty( message = "Branch Name should not be null value", groups =  {AddStudent.class, UpdateStudent.class})
    @Size(min = 2, max = 4, groups = {AddStudent.class, UpdateStudent.class})
    @Pattern(regexp = "IT||CSE||MECH||CIVIL||ECE", groups = {AddStudent.class, UpdateStudent.class})
    private String branch;

    @NotNull(message = "Admission Date should not be null value", groups = {AddStudent.class, UpdateStudent.class})
    private Date admissionDate;

    public Student(Integer rollNo, String name, Long phoneNumber, String branch, Date admissionDate) {
        this.rollNo = rollNo;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.branch = branch;
        this.admissionDate = admissionDate;
    }

    public Student() {
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String toString() {
        return String.format("\n RollNo: %s - Name: %s - PhoneNumber: %s - BranchName: %s - AdmissionDate: %s  \n", Integer.toString(rollNo), name, Long.toString(phoneNumber), branch,
                admissionDate.toString());
    }
}