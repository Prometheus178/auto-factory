package com.autofactory.repository.body;

import com.autofactory.model.car.detail.body.CarBody;
import com.autofactory.repository.base.AbstractAutoFactoryDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarBodyDAO extends AbstractAutoFactoryDAO<CarBody, Long> {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public CarBodyDAO() {
        super(CarBody.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
