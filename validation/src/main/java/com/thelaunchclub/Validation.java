package com.thelaunchclub;

public interface Validation {
    boolean validateChoice(final String Choice);
    boolean validateRollNumber(final String rollNumber);
    boolean validateName(final String name);
    boolean validatePhoneNumber(final String phoneNumber);
    boolean validateBranchName(final String branchName);
    boolean validateAdmissionDate(final String date);
}
