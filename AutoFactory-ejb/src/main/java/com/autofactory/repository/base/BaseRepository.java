package com.autofactory.repository.base;

import java.io.Serializable;

public interface BaseRepository<T, ID extends Serializable> {

    void save(T entity);

    T getById(ID id);

    void delete(ID id);

    void update(T entity);


}
