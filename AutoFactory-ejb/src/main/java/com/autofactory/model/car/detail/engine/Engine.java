package com.autofactory.model.car.detail.engine;

import com.autofactory.model.BaseEntity;
import com.autofactory.model.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "engine")
public class Engine extends BaseEntity implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "engine_type_id",  referencedColumnName = "id")
    private EngineType type;

    @Column(name = "volume")
    private Double volume;

    @Column(name = "power")
    private Double power;

    @Column(name = "serial_number")
    private String serialNumber;

    @OneToOne(mappedBy = "engine")
    private Car car;

    public EngineType getType() {
        return type;
    }

    public void setType(EngineType type) {
        this.type = type;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @JsonIgnore
    @XmlTransient
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine)) return false;
        if (!super.equals(o)) return false;
        Engine engine = (Engine) o;
        return Objects.equals(type, engine.type) &&
                Objects.equals(volume, engine.volume) &&
                Objects.equals(power, engine.power) &&
                Objects.equals(serialNumber, engine.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, volume, power, serialNumber);
    }
}
