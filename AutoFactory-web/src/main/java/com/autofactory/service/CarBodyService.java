package com.autofactory.service;

import com.autofactory.controller.rest.CarBodyController;
import com.autofactory.exception.ResourceNotFoundException;
import com.autofactory.model.car.detail.body.CarBody;
import com.autofactory.repository.base.Sort;
import com.autofactory.repository.body.CarBodyDAO;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@SessionScoped
@Named
@SuppressWarnings("unused")
public class CarBodyService implements CarBodyController, Serializable {

    @Inject
    CarBodyDAO dao;

    @Override
    public Response create(CarBody entity) {
        if (entity != null) {
            dao.save(entity);
        }
        return Response.ok().build();
    }

    @Override
    public Response update(long id, CarBody entity) {
        dao.update(entity);
        return Response.ok().build();
    }

    @Override
    public Response getById(long id) {
        Response response;
        CarBody carBodyType = dao.getById(id);
        if (carBodyType != null) {
            response = Response.ok().entity(carBodyType).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        return response;
    }

    @Override
    public Response delete(long id) throws ResourceNotFoundException {
        dao.delete(id);
        return Response.ok().build();
    }

    @Override
    public Response getAll() {
        return Response.ok().entity(dao.getAll()).build();
    }

    @Override
    public Response sortedGetAll(String value, Sort sortBy) {
        return Response.ok().entity(dao.sortedGetAll(value, sortBy)).build();
    }

    @Override
    public Response getPage(int page, int size) {
        return Response.ok().entity(dao.getPage(page, size)).build();
    }
}
