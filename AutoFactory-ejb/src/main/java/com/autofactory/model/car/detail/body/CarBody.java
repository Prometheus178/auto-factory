package com.autofactory.model.car.detail.body;

import com.autofactory.model.BaseEntity;
import com.autofactory.model.Car;
import com.autofactory.model.car.detail.Detail;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "car_bodies")
public class CarBody extends BaseEntity implements Serializable, Detail {

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_body_type_id", referencedColumnName = "id")
    private CarBodyType type;

    @Column(name = "color")
    private String color;

    @Column(name = "count_door")
    private int countDoor;

    @Column(name = "vin")
    private String vin;

    @OneToOne(mappedBy = "carBody")
    private Car car;

    public CarBodyType getType() {
        return type;
    }

    public void setType(CarBodyType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCountDoor() {
        return countDoor;
    }

    public void setCountDoor(int countDoor) {
        this.countDoor = countDoor;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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
        if (!(o instanceof CarBody)) return false;
        if (!super.equals(o)) return false;
        CarBody carBody = (CarBody) o;
        return countDoor == carBody.countDoor &&
                Objects.equals(type, carBody.type) &&
                Objects.equals(color, carBody.color) &&
                Objects.equals(vin, carBody.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, color, countDoor, vin);
    }

}
