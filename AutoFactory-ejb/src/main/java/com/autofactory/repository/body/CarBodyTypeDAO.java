package com.autofactory.repository.body;

import com.autofactory.model.car.detail.body.CarBodyType;
import com.autofactory.repository.base.AbstractAutoFactoryDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarBodyTypeDAO extends AbstractAutoFactoryDAO<CarBodyType, Long> {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public CarBodyTypeDAO() {
        super(CarBodyType.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
