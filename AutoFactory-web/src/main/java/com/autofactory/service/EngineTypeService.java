package com.autofactory.service;

import com.autofactory.controller.rest.EngineTypeController;
import com.autofactory.exception.ResourceNotFoundException;
import com.autofactory.model.car.detail.engine.Engine;
import com.autofactory.model.car.detail.engine.EngineType;
import com.autofactory.repository.base.Sort;
import com.autofactory.repository.engine.EngineDAO;
import com.autofactory.repository.engine.EngineTypeDAO;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import java.io.Serializable;


@SessionScoped
@Named
@SuppressWarnings("unused")
public class EngineTypeService implements EngineTypeController, Serializable {

    @Inject
    EngineTypeDAO dao;

    @Override
    public Response create(EngineType entity) {
        dao.save(entity);
        return Response.ok().build();
    }

    @Override
    public Response update(long id, EngineType entity) {
        dao.update(entity);
        return Response.ok().build();
    }

    @Override
    public Response getById(long id) {
        Response response;
        EngineType engineType = dao.getById(id);
        if (engineType != null) {
            response = Response.ok().entity(engineType).build();
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
