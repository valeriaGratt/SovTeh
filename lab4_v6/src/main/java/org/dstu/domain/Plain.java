package org.dstu.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Plain {
    private int id;
    private String name;
    private Integer maxPassengers;
    private Integer maxBags;
    public Integer stewardessNumber;
    public Integer maxHeight;
    public String company;
    private Port port;

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
    @Column(name = "stewardessnumber")
    public Integer getStewardessNumber() {
        return stewardessNumber;
    }

    public void setStewardessNumber(Integer stewardessNumber) {
        this.stewardessNumber = stewardessNumber;
    }

    @Basic
    @Column(name = "maxheight")
    public Integer getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "port_id")
    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plain plain = (Plain) o;
        return id == plain.id && Objects.equals(name, plain.name) && Objects.equals(maxPassengers, plain.maxPassengers) && Objects.equals(maxBags, plain.maxBags) && Objects.equals(stewardessNumber, plain.stewardessNumber) && Objects.equals(maxHeight, plain.maxHeight) && Objects.equals(company, plain.company) && Objects.equals(port, plain.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maxPassengers, maxBags, stewardessNumber, maxHeight, company, port);
    }
}
