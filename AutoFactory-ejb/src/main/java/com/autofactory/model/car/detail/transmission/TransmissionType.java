package com.autofactory.model.car.detail.transmission;

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
@Table(name = "transmission_type")
public class TransmissionType extends BaseEntity implements Serializable {

    private String type;

    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private Set<Transmission> transmissions;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    @XmlTransient
    public Set<Transmission> getTransmissions() {
        return transmissions;
    }

    public void setTransmissions(Set<Transmission> transmissions) {
        this.transmissions = transmissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransmissionType)) return false;
        if (!super.equals(o)) return false;
        TransmissionType that = (TransmissionType) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return "TransmissionType{" +
                "type='" + type + '\'' +
                '}';
    }
}
