package com.autofactory.model;

import com.autofactory.model.car.detail.body.CarBody;
import com.autofactory.model.car.detail.engine.Engine;
import com.autofactory.model.car.detail.transmission.Transmission;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "car")
public class Car extends BaseEntity implements Serializable {

    @OneToOne()
    @JoinColumn(name = "car_body_id", referencedColumnName = "id")
    private CarBody carBody;

    @OneToOne()
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    private Engine engine;

    @OneToOne()
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Transmission transmission;

    public CarBody getCarBody() {
        return carBody;
    }

    public void setCarBody(CarBody carBody) {
        this.carBody = carBody;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

}
