package com.thelaunchclub.studentdetail.controller;

import com.thelaunchclub.studentdetail.model.Student;
import com.thelaunchclub.studentdetail.service.StudentServiceImp;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Implements the API services and specifies the path to access.
 */
public class ApiServiceImpl extends StudentManagement implements ApiService {
    private static final StudentServiceImp SERVICE_IMP = new StudentServiceImp();

    /**
     * To specify the path and post the data.
     *
     * @param student
     */
    @Override
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Map addStudent(final Student student) {
        return SERVICE_IMP.addStudent(student);
    }

    /**
     * By using the path it gets the data.
     *
     * @param rollNo
     */
    @Override
    @Path("/get/{rollNo}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List searchStudent(@PathParam("rollNo") final int rollNo) {
        return SERVICE_IMP.searchStudent(rollNo);
    }

    /**
     * Specifing the path preferred to remove the data.
     *
     * @param rollNo
     */
    @Override
    @Path("/remove/{rollNo}")
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public Map removeStudent(@PathParam("rollNo") final int rollNo) {
        return SERVICE_IMP.removeStudent(rollNo);
    }

    /**
     * For updating used put method to upload a data.
     *
     * @param student
     */
    @Override
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public Map updateStudent(final Student student) {
        return SERVICE_IMP.updateStudent(student);
    }

    /**
     * View all data and separated as page view using page and limit.
     *
     * @param page
     * @param limit
     */
    @Path("/view")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Student> viewAllStudents(@QueryParam("page") final int page, @DefaultValue("5") @QueryParam("limit") final int limit) {
        return super.PaginationView(page, limit);
    }
}