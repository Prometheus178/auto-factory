package com.autofactory.repository.transsmission;

import com.autofactory.model.car.detail.transmission.TransmissionType;
import com.autofactory.repository.base.AbstractAutoFactoryDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public class TransmissionTypeDAO extends AbstractAutoFactoryDAO<TransmissionType, Long> {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public TransmissionTypeDAO() {
        super(TransmissionType.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
