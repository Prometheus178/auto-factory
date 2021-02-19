package com.autofactory.repository.transsmission;

import com.autofactory.model.car.detail.transmission.Transmission;
import com.autofactory.repository.base.AbstractAutoFactoryDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TransmissionDAO extends AbstractAutoFactoryDAO<Transmission, Long> {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public TransmissionDAO() {
        super(Transmission.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
