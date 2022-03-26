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
    Map addStudent(final Student student);

    @Produces("application/json")
    @GET
    List searchStudent(final Integer rollNo);

    @Produces("application/json")
    @DELETE
    Map removeStudent(final Integer rollNo);

    @Consumes("application/json")
    @PUT
    Map updateStudent(final Student student);

    @Produces("application/json")
    @GET
    List<Student> viewAllStudents(final int page, final int limit);
}
