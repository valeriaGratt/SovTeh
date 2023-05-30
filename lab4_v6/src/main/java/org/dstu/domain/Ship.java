package org.dstu.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ship {
    private int id;
    private String name;
    private Integer maxPassengers;
    private Integer maxBags;
    private Integer length;
    private String captainName;
    private Integer maxSpeed;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "maxpassengers")
    public Integer getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(Integer maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Basic
    @Column(name = "maxbags")
    public Integer getMaxBags() {
        return maxBags;
    }

    public void setMaxBags(Integer maxBags) {
        this.maxBags = maxBags;
    }

    @Basic
    @Column(name = "length")
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Basic
    @Column(name = "capteinname")
    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    @Basic
    @Column(name = "maxspeed")
    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return id == ship.id && Objects.equals(name, ship.name) && Objects.equals(maxPassengers, ship.maxPassengers) && Objects.equals(maxBags, ship.maxBags) && Objects.equals(length, ship.length) && Objects.equals(captainName, ship.captainName) && Objects.equals(maxSpeed, ship.maxSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maxPassengers, maxBags, length, captainName, maxSpeed);
    }
}
