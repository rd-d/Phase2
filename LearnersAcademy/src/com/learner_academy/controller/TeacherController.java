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
import com.learner_academy.model.Teacher;
import com.learner_academy.service.TeacherService;
import com.learner_academy.service.Impl.TeacherServiceImpl;

@Path("/Teacher")
public class TeacherController {

	private TeacherService service = new TeacherServiceImpl();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Teacher createTeacher(Teacher teacher) {

		return service.createTeacher(teacher);
	}

	@GET
	@Path("/{teacherId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTeacherById(@PathParam("teacherId") int teacherId) {
		try {
			return Response.ok(service.getTeacherById(teacherId), MediaType.APPLICATION_JSON).build();
		} catch (BusinessException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Teacher> getAllTeachers() {

		return service.getAllTeachers();
	}

	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Teacher updateTeacher(Teacher teacher) {

		return service.updateTeacher(teacher);
	}

	@DELETE
	@Path("/{teacherId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeTeacher(@PathParam("teacherId") int teacherId) {

		service.removeTeacher(teacherId);

	}

}
