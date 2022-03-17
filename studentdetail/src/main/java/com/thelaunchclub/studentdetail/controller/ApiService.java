package com.thelaunchclub.studentdetail.controller;

import com.thelaunchclub.studentdetail.model.Student;

import javax.ws.rs.*;
import java.util.List;

public interface ApiService {

    @Produces("application/json")
    @GET
    String getString();

    @Consumes("application/json")
    @POST
    boolean addStudent(Student student);

    @Produces("application/json")
    @GET
    Student searchStudent(int rollNo);

    @Produces("application/json")
    @DELETE
    boolean removeStudent(int rollNo);

    @Consumes("application/json")
    @PUT
    boolean updateStudent(Student student);

    @Produces("application/json")
    @GET
    List<Student> viewAllStudents();
}
