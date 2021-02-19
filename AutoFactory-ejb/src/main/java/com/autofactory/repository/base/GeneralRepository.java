package com.autofactory.repository.base;

import java.io.Serializable;
import java.util.List;

public interface GeneralRepository<T, ID extends Serializable> extends BaseRepository<T, ID> {

    List<T> getAll();

    List<T> sortedGetAll(String value, Sort sortBy);

    List<T> getPage(int page, int size);

}
