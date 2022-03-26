package com.thelaunchclub.studentdetail.controller;

import com.thelaunchclub.studentdetail.model.Student;
import com.thelaunchclub.studentdetail.model.StudentValidator;
import com.thelaunchclub.studentdetail.service.RestServiceImp;
import jakarta.validation.Valid;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implements the API services and specifies the path to access.
 */
public class ApiServiceImpl implements ApiService {

    private static final RestServiceImp REST_SERVICE = new RestServiceImp();

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
    public Map addStudent(@Valid final Student student) {
        final List list = StudentValidator.setValidate(student);

        if (!list.isEmpty()) {
            Map map = new HashMap();

            map.put("message", list);
            return map;
        }
        return REST_SERVICE.addStudent(student);
    }

    /**
     * By using the path it gets the data.
     *
     * @param rollNo
     */

    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List searchStudent(@Valid @QueryParam("rollNo") final Integer rollNo) {
        final List list = StudentValidator.studentRollNoValidate(rollNo);

        if (!list.isEmpty()) {
            List emptyList = new ArrayList();

            emptyList.add(list);
            return list;
        }
        return REST_SERVICE.searchStudent(rollNo);
    }

    /**
     * Specifing the path preferred to remove the data.
     *
     * @param rollNo
     */

    @Path("/remove")
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public Map removeStudent(@Valid @QueryParam("rollNo") final Integer rollNo) {
        final List list = StudentValidator.studentRollNoValidate(rollNo);

        if (!list.isEmpty()) {
            Map emptymap= new HashMap();

            emptymap.put("message:", list);
            return emptymap;
        }
        return REST_SERVICE.removeStudent(rollNo);
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
    public Map updateStudent(@Valid final Student student) {
        final List list = StudentValidator.setValidate(student);

        if (!list.isEmpty()) {
            Map map = new HashMap();

            map.put("message", list);
            return map;
        }
        return REST_SERVICE.updateStudent(student);
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
    public List<Student> viewAllStudents(@Valid @QueryParam("page") final int page, @DefaultValue("5") @QueryParam("limit") final int limit) {
        return REST_SERVICE.showPaginationDetails(page, limit);
    }
}