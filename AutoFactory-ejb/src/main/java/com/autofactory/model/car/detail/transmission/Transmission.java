package com.autofactory.model.car.detail.transmission;


import com.autofactory.model.BaseEntity;
import com.autofactory.model.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "transmission")
public class Transmission extends BaseEntity implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "transmission_type_id", referencedColumnName = "id")
    private TransmissionType type;

    @Column(name = "serial_number")
    private String serialNumber;

    @OneToOne(mappedBy = "transmission")
    private Car car;

    public TransmissionType getType() {
        return type;
    }

    public void setType(TransmissionType type) {
        this.type = type;
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
        if (!(o instanceof Transmission)) return false;
        if (!super.equals(o)) return false;
        Transmission that = (Transmission) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, serialNumber);
    }
}
