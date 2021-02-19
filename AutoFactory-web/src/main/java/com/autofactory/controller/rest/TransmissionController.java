package com.autofactory.controller.rest;

import com.autofactory.exception.ResourceNotFoundException;
import com.autofactory.model.car.detail.transmission.Transmission;
import com.autofactory.repository.base.Sort;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/rest/transmissions")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface TransmissionController {

    @POST
    Response create(Transmission transmission);

    @PUT
    @Path("{id}")
    Response update(@PathParam("id") long id, Transmission transmission);

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
