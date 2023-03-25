package com.carwash.endpoint;

import com.carwash.model.Car;
import com.carwash.service.CarService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cars")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarEndpoint {

    @Inject
    CarService carService;

    @GET
    @Path("/all")
    public Response getAllCars() {
        var response = carService.findAll();
        return Response.status(200).entity(response).build();
    }

    @GET
    @Path("/{ownerId}/cars")
    public Response getCarsByOwnerId(@PathParam("ownerId") Long id) {
        var response = carService.findCarsByOwnerId(id);
        return Response.status(200).entity(response).build();
    }

    @POST
    @Path("create")
    public Response insert(@QueryParam("id") Long id, Car car) {
        carService.insertCar(id, car);
        return Response.status(201).build();
    }

    @PUT
    @Path("update")
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
