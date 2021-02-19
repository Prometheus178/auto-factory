package com.autofactory.repository.base;

import com.autofactory.exception.ResourceNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractAutoFactoryDAO<T, ID extends Serializable> implements GeneralRepository<T, ID> {


    private final Class<T> entityClass;

    public AbstractAutoFactoryDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    protected abstract EntityManager getEntityManager();

    @Override
    public void save(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public T getById(ID id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public void delete(ID id) throws ResourceNotFoundException {
        T object = getById(id);
        if (object != null) {
            getEntityManager().remove(object);
        } else {
            throw new ResourceNotFoundException(String.format("Resource by id = %s not found", id));
        }
    }

    @Override
    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public List<T> getAll() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        criteriaQuery.select(criteriaQuery.from(entityClass));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<T> getPage(int page, int size) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(entityClass)));
        Long count = getEntityManager().createQuery(countQuery).getSingleResult();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> from = criteriaQuery.from(entityClass);
        CriteriaQuery<T> select = criteriaQuery.select(from);
        TypedQuery<T> typedQuery = getEntityManager().createQuery(select);
        while (page < count.intValue()) {
            typedQuery.setFirstResult(page - 1);
            typedQuery.setMaxResults(size);
            page += size;
        }
        return typedQuery.getResultList();
    }

    public List<T> sortedGetAll(String value, Sort sortBy) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> from = criteriaQuery.from(entityClass);
        switch (sortBy) {
            case ASC:
                criteriaQuery.orderBy(criteriaBuilder.asc(from.get(value)));
            case DESC:
                criteriaQuery.orderBy(criteriaBuilder.desc(from.get(value)));
        }
        CriteriaQuery<T> select = criteriaQuery.select(from);
        TypedQuery<T> typedQuery = getEntityManager().createQuery(select);
        return typedQuery.getResultList();
    }

}
