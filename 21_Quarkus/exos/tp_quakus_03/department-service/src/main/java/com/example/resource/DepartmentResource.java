package com.example.resource;

import com.example.entity.Department;
import com.example.service.DepartmentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/departments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    @Inject
    DepartmentService departmentService;

    @GET
    public List<Department> getDepartments(){
        return departmentService.findAll();
    }

    @GET
    @Path("/organization/{organizationId}")
    public List<Department> getDepartmentsByOrganizationId(@PathParam("organizationId") Long organizationId) {
        return departmentService.findByOrganizationId(organizationId);
    }

    @POST
    public Department createDepartment(Department department) {
        return departmentService.create(department);
    }

    @GET
    @Path("/{id}")
    public Department getDepartment(@PathParam("id") Long id) {
        return departmentService.findById(id);
    }

    @PUT
    @Path("/{id}")
    public Department updateDepartment(@PathParam("id") Long id, Department department) {
        return departmentService.update(id, department);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDepartment(@PathParam("id") Long id) {
        departmentService.deleteAndNotify(id);
        return Response.noContent().build();
    }
}
