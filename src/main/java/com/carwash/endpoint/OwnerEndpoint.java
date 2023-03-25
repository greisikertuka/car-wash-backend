package com.carwash.endpoint;

import com.carwash.model.Owner;
import com.carwash.service.OwnerService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/owners")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OwnerEndpoint {

    @Inject
    OwnerService ownerService;

    @GET
    @Path("/all")
    public Response get() {
        var response = ownerService.findAll();
        return Response.status(200).entity(response).build();
    }

    @POST
    @Path("/insert")
    public Response insert(Owner owner) {
        ownerService.insertOwner(owner);
        return Response.status(201).build();
    }

    @PUT
    @Path("/update")
    public Response update(Owner owner) {
        ownerService.update(owner);
        return Response.status(201).build();
    }

    @DELETE
    @Path("{id}/delete")
    public Response delete(@PathParam("id") Long id) {
        ownerService.deleteOwner(id);
        return Response.status(201).build();
    }
}
