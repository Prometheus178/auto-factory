package com.autofactory.repository.engine;

import com.autofactory.model.car.detail.engine.EngineType;
import com.autofactory.repository.base.AbstractAutoFactoryDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EngineTypeDAO extends AbstractAutoFactoryDAO<EngineType , Long> {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public EngineTypeDAO() {
        super(EngineType.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
