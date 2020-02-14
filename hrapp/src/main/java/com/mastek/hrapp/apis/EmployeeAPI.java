package com.mastek.hrapp.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.hrapp.entities.Employee;



@Path("/hrapp/") //url pattern for current API
public interface EmployeeAPI {
	// http://localhost:7777/hrapp/employees/list
	@GET
	@Path("/employees/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Employee> listAllEmployees();
	
	@GET
	@Path("/employees/find/{empno}")
	@Produces({MediaType.APPLICATION_JSON})
	public Employee findByEmpno(@PathParam("empno") int empno);
	
	@POST
	@Path("/employees/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee registerNewEmployee(@BeanParam Employee newEmployee);
	
}
