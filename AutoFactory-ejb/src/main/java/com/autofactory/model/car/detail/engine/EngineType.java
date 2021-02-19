package com.autofactory.model.car.detail.engine;

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
@Table(name = "engine_type")
public class EngineType extends BaseEntity implements Serializable {

    private String type;

    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    Set<Engine> engines;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    @XmlTransient
    public Set<Engine> getEngines() {
        return engines;
    }

    public void setEngines(Set<Engine> engines) {
        this.engines = engines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EngineType)) return false;
        if (!super.equals(o)) return false;
        EngineType that = (EngineType) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return "EngineType{" +
                "type='" + type + '\'' +
                '}';
    }
}
