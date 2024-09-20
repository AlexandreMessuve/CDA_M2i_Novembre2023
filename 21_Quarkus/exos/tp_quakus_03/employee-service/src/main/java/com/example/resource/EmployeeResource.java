package com.example.resource;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    @Inject
    EmployeeService employeeService;

    @GET
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GET
    @Path("/organization/{organizationId}")
    public List<Employee> getEmployeesByOrganization(@PathParam("organizationId") Long organizationId) {
        return employeeService.getEmployeesByOrganization(organizationId);
    }

    @GET
    @Path("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartment(@PathParam("departmentId") Long departmentId) {
        return employeeService.getEmployeesByDepartment(departmentId);
    }

    @POST
    public Employee createEmployee(Employee employee) {
        return employeeService.createAndNotify(employee);
    }

    @GET
    @Path("/{id}")
    public Employee getEmployee(@PathParam("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PUT
    @Path("/{id}")
    public Employee updateEmployee(@PathParam("id") Long id, Employee employee) {
        return employeeService.update(id, employee);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam("id") Long id) {
        employeeService.deleteAndNotify(id);
        return Response.noContent().build();
    }
}
