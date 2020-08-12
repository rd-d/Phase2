  
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
import com.learner_academy.model.Classes;
import com.learner_academy.service.ClassesService;
import com.learner_academy.service.Impl.ClassesServiceImpl;

@Path("/Classes")
public class ClassesController {

	private ClassesService service = new ClassesServiceImpl();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Classes createClasses(Classes classes) {

		return service.createClasses(classes);
	}

	@GET
	@Path("/{classId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClassesById(@PathParam("classId") int classId) {

		try {
			return Response.ok(service.getClassesById(classId), MediaType.APPLICATION_JSON).build();
		} catch (BusinessException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Classes> getAllClasses() {

		return service.getAllClasses();
	}
	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Classes updateClasses(Classes classes) {

		return service.updateClasses(classes);
	}

	@DELETE
	@Path("/{classId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeClasses(@PathParam("classId") int classId) {

		service.removeClasses(classId);

	}
}
