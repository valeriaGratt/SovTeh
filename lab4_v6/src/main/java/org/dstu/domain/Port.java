package org.dstu.domain;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Port {
    private int id;
    private String country;
    private Set<Plain> machines = new LinkedHashSet<>();

    @Basic
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "port")
    public Set<Plain> getMachines() {
        return machines;
    }

    public void setMachines(Set<Plain> machines) {
        this.machines = machines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Port port = (Port) o;
        return id == port.id && Objects.equals(country, port.country) && Objects.equals(machines, port.machines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, machines);
    }
}
