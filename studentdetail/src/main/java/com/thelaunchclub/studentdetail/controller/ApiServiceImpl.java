package com.thelaunchclub.studentdetail.controller;

import com.thelaunchclub.studentdetail.model.Student;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.*;
import java.util.List;

@Produces("application/json")
@Component
public class ApiServiceImpl extends StudentManagement implements ApiService{

    @Override
    @Path("/add")
    @Consumes("application/json")
    @POST
    public boolean addStudent(Student student) {
        return super.addStudent(student);
    }

    @Override
    @Path("/{rollNo}")
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

    @Override
    @Path("/{rollNo}")
    @DELETE
    public boolean removeStudent(@PathParam("rollNo") int rollNo) {
        return super.removeStudent(rollNo);
    }

    @Override
    @Path("/update")
    @Consumes("application/json")
    @PUT
    public boolean updateStudent(Student student) {
        return super.updateStudent(student);
    }

    @Override
    @Path("/view")
    @Produces("application/json")
    @GET
    public List<Student> viewAllStudents() {
        return super.viewAllStudents();
    }
}




