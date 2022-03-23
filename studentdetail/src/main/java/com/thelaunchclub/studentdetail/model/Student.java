package com.thelaunchclub.studentdetail.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

/**
 * Represents an student and specified fields and methods to get and set the
 * student details.
 */
public class Student {

    @NotNull
    private int rollNo;

    @NotNull
    @Size(min=5, max=10, message="Your name should be between 5 - 10 characters.")
    private String name;

    @NotNull
    @Size(min=10, max=10)
    private long phoneNumber;

    @NotNull
    private String branch;

    @NotNull
    private Date admissionDate;

    public Student(int rollNo, String name, long phoneNumber, String branch, Date admissionDate) {
        this.rollNo = rollNo;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.branch = branch;
        this.admissionDate = admissionDate;
    }

    public Student() {
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollno(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
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
