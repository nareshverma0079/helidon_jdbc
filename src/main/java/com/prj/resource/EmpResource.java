package com.prj.resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.ok;

import com.prj.model.Employee;
import com.prj.service.EmpService;

@Path("/emp")
@RequestScoped
public class EmpResource {

	@Inject
	EmpService service;
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveEmp(Employee employee) {
		return ok(this.service.saveEmp(employee)).build();
	}
	
	 @GET
	 @Path("/get/{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Employee getEmp(@PathParam("id") int id) {
		 return service.getEmp(id);
	 }
	 
	 @PUT
	 @Path("/update/{id}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 public boolean updateEmp(Employee employee, @PathParam(value = "id") int id) {
		 return service.updateEmp(employee, id);
	 }
}
