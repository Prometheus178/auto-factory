package com.autofactory.service;

import com.autofactory.controller.rest.CarController;
import com.autofactory.exception.ResourceNotFoundException;
import com.autofactory.model.Car;
import com.autofactory.repository.CarDAO;
import com.autofactory.repository.base.Sort;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@SessionScoped
@Named
@SuppressWarnings("unused")
public class CarService implements CarController, Serializable {

    @Inject
    CarDAO dao;

    @Override
    public Response create(Car entity) {
        dao.save(entity);
        return Response.ok().build();
    }

    @Override
    public Response update(long id, Car entity) {
        dao.update(entity);
        return Response.ok().build();
    }

    @Override
    public Response getById(long id) {
        Response response;
        Car car = dao.getById(id);
        if (car != null) {
            response = Response.ok().entity(car).build();
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
