package com.autofactory.controller.rest;

import com.autofactory.exception.ResourceNotFoundException;
import com.autofactory.model.Car;
import com.autofactory.repository.base.Sort;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/rest/cars")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface CarController {

    @POST
    Response create(Car engine);

    @PUT
    @Path("{id}")
    Response update(@PathParam("id") long id, Car engine);

    @GET
    @Path("{id}")
    Response getById(@PathParam("id") long id) throws ResourceNotFoundException;

    @DELETE
    @Path("{id}")
    Response delete(@PathParam("id") long id) throws ResourceNotFoundException;

    @GET
    Response getAll();

    @GET
    Response sortedGetAll(String value, Sort sortBy);

    @GET
    Response getPage(int page, int size);
}
