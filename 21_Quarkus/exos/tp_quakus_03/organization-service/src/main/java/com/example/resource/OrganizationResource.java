package com.example.resource;

import com.example.entity.Organization;
import com.example.service.OrganizationService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/organizations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganizationResource {

    @Inject
    OrganizationService organizationService;

    @GET
    public List<Organization> getOrganizations() {
        return organizationService.findAll();
    }

    @POST
    public Organization createOrganization(Organization organization) {
        return organizationService.create(organization);
    }

    @GET
    @Path("/{id}")
    public Organization getOrganization(@PathParam("id") Long id) {
        return organizationService.findById(id);
    }

    @PUT
    @Path("/{id}")
    public Organization updateOrganization(@PathParam("id") Long id, Organization organization) {
        return organizationService.update(id, organization);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrganization(@PathParam("id") Long id) {
        organizationService.deleteAndNotify(id);
        return Response.noContent().build();
    }
}
