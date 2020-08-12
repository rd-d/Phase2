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
import com.learner_academy.model.Subject;
import com.learner_academy.service.SubjectService;
import com.learner_academy.service.Impl.SubjectServiceImpl;

@Path("/Subject")
public class SubjectController {

	private SubjectService service = new SubjectServiceImpl();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Subject createSubject(Subject subject) {
		return service.createSubject(subject);

	}

	@GET
	@Path("/{subjectId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSubjectById(@PathParam("subjectId") int subjectId) {

		try {
			return Response.ok(service.getSubjectById(subjectId), MediaType.APPLICATION_JSON).build();
		} catch (BusinessException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Subject> getAllSubject() {

		return service.getAllSubject();
	}

	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Subject updateSubject(Subject subject) {

		return service.updateSubject(subject);
	}

	@DELETE
	@Path("/{subjectId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeSubject(@PathParam("subjectId") int subjectId) {

		service.removeSubject(subjectId);

	}

}