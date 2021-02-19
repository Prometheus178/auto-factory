package com.autofactory.repository.engine;

import com.autofactory.model.car.detail.engine.Engine;
import com.autofactory.repository.base.AbstractAutoFactoryDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EngineDAO extends AbstractAutoFactoryDAO<Engine, Long> {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public EngineDAO() {
        super(Engine.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
