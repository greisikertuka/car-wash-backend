package com.carwash.endpoint;

import com.carwash.model.Car;
import com.carwash.service.CarService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cars")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarEndpoint {

    @Inject
    CarService carService;

    @GET
    @Path("")
    public Response get() {
        var response =  carService.findAll();
        return Response.status(200).entity(response).build();
    }

    @POST
    @Path("")
    public Response insert(Car car) {
        carService.insertCar(car);
        return Response.status(201).build();
    }

    @PUT
    @Path("")
    public Response update(Car car) {
        carService.update(car);
        return Response.status(201).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        carService.deleteCar(id);
        return Response.status(201).build();
    }
}
