package com.thelaunchclub.studentdetail.controller;

import com.thelaunchclub.studentdetail.model.Student;

import javax.ws.rs.*;
import java.util.List;
import java.util.Map;

/**
 * ApiService for an implementation.
 */
public interface ApiService {

    @Consumes("application/json")
    @POST
    Map addStudent(Student student);

    @Produces("application/json")
    @GET
    List searchStudent(int rollNo);

    @Produces("application/json")
    @DELETE
    Map removeStudent(int rollNo);

    @Consumes("application/json")
    @PUT
    Map updateStudent(Student student);

    @Produces("application/json")
    @GET
    List<Student> viewAllStudents();
}
