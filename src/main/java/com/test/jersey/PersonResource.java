package com.test.jersey;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.gradle.model.Person;
import org.springframework.stereotype.Component;

import com.test.exceptions.NotFoundException;

@Component
@Path("/person")
@Api(tags = { "person" })
@Produces({ "application/json", "application/xml" })
public class PersonResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "list api", notes = "Multiple status values can be provided with comma seperated strings", response = Person.class, responseContainer = "List")
	public Response index() {
		List<Person> list = new ArrayList<Person>();
		return Response.ok(list).build();
	}

	@SuppressWarnings("unused")
	@GET
	@Path("/{id}")
	@ApiOperation(value = "Find person by ID", notes = "Returns a pet when 0 < ID <= 10.  ID > 10 or nonintegers will simulate API error conditions", response = Person.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Person not found") })
	public Response getPetById(
			@ApiParam(value = "ID of person", allowableValues = "range[1,10]", required = true) @PathParam("id") Integer id)
			throws NotFoundException {
		Person person = new Person("testof");
		if (null != person) {
			return Response.ok().entity(person).build();
		} else {
			throw new NotFoundException(404, "Pet not found");
		}
	}
}
