package com.thelaunchclub.studentdetail.controller;

import com.thelaunchclub.studentdetail.model.Student;

import javax.ws.rs.*;
import java.util.List;

/**
 * Implements the API services and specifies the path to access.
 */
public class ApiServiceImpl extends StudentManagement implements ApiService {

    /**
     * To specify the path and post the data.
     *
     * @param student
     * @return
     */
    @Override
    @Path("/add")
    @Consumes("application/json")
    @POST
    public boolean addStudent(Student student) {
        return super.addStudent(student);
    }

    /**
     * By using the path it gets the data.
     *
     * @param rollNo
     * @return
     */
    @Override
    @Path("/get/{rollNo}")
    @Produces("application/json")
    @GET
    public Student searchStudent(@PathParam("rollNo") int rollNo) {
        return super.searchStudent(rollNo);
    }

    @Path("/hello")
    @Produces("application/json")
    @GET
    public String getString() {
        return "Hi I am Kowsi";
    }

    /**
     * Specifing the path preferred to remove the data.
     *
     * @param rollNo
     * @return
     */
    @Override
    @Path("/remove/{rollNo}")
    @DELETE
    public boolean removeStudent(@PathParam("rollNo") int rollNo) {
        return super.removeStudent(rollNo);
    }

    /**
     * For updating used put method to upload a data.
     *
     * @param student
     * @return
     */
    @Override
    @Path("/update")
    @Consumes("application/json")
    @PUT
    public boolean updateStudent(Student student) {
        return super.updateStudent(student);
    }

    /**
     * View all data and separated as page view using page and limit.
     *
     * @param page
     * @param limit
     * @return
     */
    @Path("/view")
    @Produces("application/json")
    @GET
    public List<Student> viewAllStudents(@QueryParam("page") int page, @DefaultValue("5") @QueryParam("limit") int limit) {
        List<Student> list = super.viewAllStudents();
        int size = list.size();
        int start = 0;
        int end = 0;

        if (page >= 0 && limit >= 0) {
            start = (page - 1) * limit;
            end = page * limit;
        }
        if (start < size & end < size) {
            return list.subList(start, end);
        } else if (start < size) {
            return list.subList(start, size);
        }
        return null;
    }
}