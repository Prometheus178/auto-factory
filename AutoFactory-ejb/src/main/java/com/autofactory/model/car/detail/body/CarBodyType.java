package com.autofactory.model.car.detail.body;

import com.autofactory.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "car_body_type")
public class CarBodyType extends BaseEntity implements Serializable {

    private String type;

    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private Set<CarBody> carBodies;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    @XmlTransient
    public Set<CarBody> getCarBodies() {
        return carBodies;
    }

    public void setCarBodies(Set<CarBody> carBodies) {
        this.carBodies = carBodies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarBodyType)) return false;
        if (!super.equals(o)) return false;
        CarBodyType that = (CarBodyType) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return "CarBodyType{" +
                "type='" + type + '\'' +
                '}';
    }
}
