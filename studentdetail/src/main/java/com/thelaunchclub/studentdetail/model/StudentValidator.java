package com.thelaunchclub.studentdetail.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.ws.rs.ext.Provider;

import org.hibernate.validator.HibernateValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Student Validator Validates the input from Rest Services.
 */
@Provider
public class StudentValidator {

    private static final ValidatorFactory FACTORY = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
    private static final Validator VALIDATOR = FACTORY.getValidator();

    /**
     * Setting Validation for add and update student data.
     *
     * @param student
     * @return
     */
    public static List setValidate(final Student student) {
        final Set<ConstraintViolation<Student>> constraintViolations = VALIDATOR.validate(student, AddStudent.class, UpdateStudent.class);
        final List list = new ArrayList();

        for(ConstraintViolation<Student> violation :constraintViolations){
            list.add(violation.getMessage());
        }
        return list;
    }
    /**
     * Validate Student RollNo for select and delete the student data.
     */
    public static List studentRollNoValidate(final Integer rollNo){
        final Student student=new Student();
        student.setRollNo(rollNo);

        final Set<ConstraintViolation<Student>> constraintViolations =
                VALIDATOR.validate(student, SearchStudent.class, DeleteStudent.class );
        final List list = new ArrayList();

        for (ConstraintViolation<Student> violation : constraintViolations) {
            list.add(violation.getMessage());
        }
        return list;
    }
}
