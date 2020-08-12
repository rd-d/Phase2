package com.learner_academy.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.learner_academy.exception.BusinessException;
import com.learner_academy.model.Student;
import com.learner_academy.service.StudentService;
import com.learner_academy.service.Impl.StudentServiceImpl;

@Path("/Student")
public class StudentController {

	private StudentService service = new StudentServiceImpl();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student createStudent(Student student) {

		return service.createStudent(student);
	}

	@GET
	@Path("/{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentById(@PathParam("studentId") int studentId) {

		try {
			return Response.ok(service.getStudentById(studentId), MediaType.APPLICATION_JSON).build();
		} catch (BusinessException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents() {

		return service.getAllStudents();
	}

//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getAllStudents() {
//
//	return Response.ok(service.getAllStudents(), MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*").build();
//	}

//	@PATCH
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Student updateStudent(Student student) {
////		
//		return service.updateStudent(student);
//	}
	
//	@PATCH
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Student updateStudent(Student student) {
//		return service.updateStudent(student);
//	}

	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student updateStudent(Student student) {
		return service.updateStudent(student);
	}
	
//	@PUT
////	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response updateStudent(Student student) {
//		// Presentation Layer to update the student
//		return Response.ok(service.updateStudent(student), MediaType.APPLICATION_JSON).build();
//	} 
	
	@DELETE
	@Path("/{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeStudent(@PathParam("studentId") int studentId) {

		service.removeStudent(studentId);

	}

}
