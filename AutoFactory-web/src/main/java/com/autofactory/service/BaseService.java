package com.autofactory.service;

import javax.ws.rs.core.Response;
import java.util.List;

public interface BaseService<T> {

    Response create(T entity);

    Response update(T entity);

    Response getById(long id);

    Response delete(long id);

    List<T> getAll();

    List<T> getPage(long page,long size);
}
