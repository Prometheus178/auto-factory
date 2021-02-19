package com.autofactory.controller.rest;

import com.autofactory.model.car.detail.body.CarBody;
import com.autofactory.repository.base.Sort;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("/rest/car-bodies")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface CarBodyController {

    @POST
    Response create(CarBody CarBody);

    @PUT
    @Path("{id}")
    Response update(@PathParam("id") long id, CarBody CarBody);

    @GET
    @Path("{id}")
    Response getById(@PathParam("id") long id);

    @DELETE
    @Path("{id}")
    Response delete(@PathParam("id") long id);

    @GET
    Response getAll();

    @GET
    Response sortedGetAll(String value, Sort sortBy);

    @GET
    Response getPage(int page, int size);

}
