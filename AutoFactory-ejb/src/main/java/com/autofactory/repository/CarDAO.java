package com.autofactory.repository;

import com.autofactory.model.Car;
import com.autofactory.repository.base.AbstractAutoFactoryDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarDAO extends AbstractAutoFactoryDAO<Car, Long> {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public CarDAO() {
        super(Car.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
